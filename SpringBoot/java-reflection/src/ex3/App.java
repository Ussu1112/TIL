package ex3;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static Set<Class> componentScan(String pkg) throws Exception {
        // 현재 패키지 위치를 받아옴 (shop.mtcoding._core)
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        // 클래스들을 담을 컬렉션
        Set<Class> classes = new HashSet<>();

        // 매개변수로 전달받은 패키지 위치
        URL packageUrl = classLoader.getResource(pkg);

        // 지정한 패키지의 모든 파일 불러오기
        File packageDirectory = new File(packageUrl.toURI());

        // 패키지의 클래스 스캔
        for (File file : packageDirectory.listFiles()) {
            if (file.getName().endsWith(".class")) {
                String className = pkg + "." + file.getName().replace(".class", "");
                Class cls = Class.forName(className);
                classes.add(cls);
            }
        }
        return classes;
    }

    public static void findUri(Set<Class> classes, String uri) throws Exception {
        boolean isFind = false;

        for (Class cls : classes) {
            // 전체 class 순회
            if (cls.isAnnotationPresent(Controller.class)) {
                // controller가 있는 클래스 new
                Object instance = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();

                for (Method mt : methods) {
                    Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
                    RequestMapping rm = (RequestMapping) anno;
                    if (rm.uri().equals(uri)) {
                        isFind = true;
                        mt.invoke(instance);
                    }
                }
            }
        }

        if(isFind == false){
            System.out.println("404 Not Found");
        }
    }
    public static void main(String[] args) throws Exception {
//       Scanner sc = new Scanner(System.in);
//       String uri = sc.nextLine();

       String uri = "/login";

       Set<Class> classes = componentScan("ex3");

       //findUri(classes, uri);



    }
}
