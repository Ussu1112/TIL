package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Json {
    private static String endPoint = "https://jsonplaceholder.typicode.com/users/1";

    public static void main(String[] args) {

        System.out.println(requestAPI());


        String jsonString = requestAPI();
//                "{\n" +
//                "  \"name\": \"Madame Uppercut\",\n" +
//                "  \"age\": 39,\n" +
//                "  \"secretIdentity\": \"Jane Wilson\",\n" +
//                "  \"powers\": [\n" +
//                "    \"Million tonne punch\",\n" +
//                "    \"Damage resistance\",\n" +
//                "    \"Superhuman reflexes\"\n" +
//                "  ],\n" +
//                "  \"secretIdentity2\": \"Jane Wilson\",\n" +
//                "  \"powers2\": [\n" +
//                "    \"Million tonne punch\",\n" +
//                "    \"Damage resistance\",\n" +
//                "    \"Superhuman reflexes\"\n" +
//                "  ]\n" +
//                "}";

        Map<String, Object> jsonMap = parseJsonString(jsonString);

        System.out.println(jsonMap.get("website"));

        jsonMap.entrySet().stream().forEach(entry -> {
            System.out.println("key = " + entry.getKey());
            System.out.println("value = " + entry.getValue());
            System.out.println();
        });

    }

    public static String requestAPI() {
        String response = "";
        try {
            URL url = new URL(endPoint);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET"); // http 메서드
            conn.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보
            conn.setRequestProperty("auth", "myAuth"); // header의 auth 정보
            conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true

            // 서버로부터 데이터 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                sb.append(line);
            }
            response = sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public static Map<String, Object> parseJsonString(String jsonString) {
        String[] jsonArr = jsonString.replaceAll("[{}\\[\\]\"]", "").split(",");
        Arrays.stream(jsonArr).forEach(System.out::println);


        String key = "";
        String value = "";
        String saveKey = "";
        List<String> values = new LinkedList<>(); // 여러개 value 저장
        Map<String, Object> jsonMap = new HashMap<>(); // 실제 parsing 결과
        for (int i = 0; i < jsonArr.length; i++) {
            if (jsonArr[i].contains(":")) {
                if (values.size() > 1) {
                    jsonMap.put(saveKey.strip(), values);
                }
                // 초기화
                saveKey = "";
                values = new LinkedList<>();

                ///////////////////////////////
                // 일반적인 경우
                int idx = jsonArr[i].indexOf(":");
                key = jsonArr[i].substring(0, idx);
                value = jsonArr[i].substring(idx + 1);

                jsonMap.put(key.strip(), value.strip());
                ///////////////////////////////

                values.add(value.strip()); // 임시 넣어놈

            } else {
                saveKey = key;
                values.add(jsonArr[i].strip());
            }
        }
        if (values.size() > 1) {
            jsonMap.put(saveKey.strip(), values);
        }

        return jsonMap;
    }
}
