package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
    public static void main(String... args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println(redApples);

        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getColor() == Color.RED;
            }
        });
        System.out.println(redApples2);


    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory
             ) {
            if(apple.getColor() == color){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :
                inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


    enum Color {
        RED,
        GREEN
    }


    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing") //컴파일 단위의 서브세트와 관련된 컴파일 경고를 사용하지 않도록 설정 boxing - 오퍼레이션과 관련된 경고 무시
        @Override
        public String toString() {
            return "Apple{" + "weight=" + weight + ", color='" + color + '\'' +'}';
        }
    }

    interface ApplePredicate {
        boolean test(Apple a);
    }

    static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getWeight() > 150;
        }
    }

    static class AppleColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getColor() == Color.GREEN;
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getColor() == Color.RED && a.getWeight() > 150;
        }
    }

}
