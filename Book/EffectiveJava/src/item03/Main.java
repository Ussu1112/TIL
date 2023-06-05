package item03;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) throws NotSerializableException, Exception {
        staticFactorySingleton singleton1 = staticFactorySingleton.getInstance();
        staticFactorySingleton singleton2 = staticFactorySingleton.getInstance();

        System.out.println(singleton1); //item3.staticFactorySingleton@7c30a502
        System.out.println(singleton2); //item3.staticFactorySingleton@7c30a502

        Class<?> clazz = Class.forName("item3.staticFactorySingleton");
        Constructor<?> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);
        staticFactorySingleton singleton3 = (staticFactorySingleton) constructor.newInstance();
        System.out.println(singleton3); //item3.staticFactorySingleton@49e4cb85



        publicSingleton singleton4 = publicSingleton.INSTANCE;
        publicSingleton singleton5 = publicSingleton.INSTANCE;

        System.out.println(singleton4); //item3.publicSingleton@43a25848
        System.out.println(singleton5); //item3.publicSingleton@43a25848

        Class<?> clazz2 = Class.forName("item3.publicSingleton");
        Constructor<?> constructor2 = clazz2.getDeclaredConstructor();

        constructor2.setAccessible(true);
        publicSingleton singleton6 = (publicSingleton) constructor2.newInstance();
        System.out.println(singleton6); //item3.publicSingleton@3ac3fd8b


//
        Supplier<staticFactorySingleton> supplier1 = staticFactorySingleton::getInstance;
        System.out.println(supplier1);

        Supplier<publicSingleton> supplier2 = () -> singleton4;

        System.out.println(supplier2);


        System.out.println(singleton1); // item3.staticFactorySingleton@7c30a502

        // serialization
        File file = new File("./Singleton.file");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(singleton1);
            oos.flush();
        }

        // deserialization
        staticFactorySingleton result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (staticFactorySingleton) ois.readObject();
        }

        System.out.println(result); // item3.staticFactorySingleton@5f375618


    }


}


