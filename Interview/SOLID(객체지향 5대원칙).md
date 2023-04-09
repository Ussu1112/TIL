

> ⭐객체 지향의 4대 특성⭐  
캡슐화 : 정보은닉  
상속  
추상화 : 모델링  
다형성 : 사용 편의  

SOLID 원칙
===
클래스를 작성하기 위한 다섯 가지의 유명한 디자인 패턴을 모아 SOLID 원칙이라고 한다.  
프로그래머가 시간이 지나도 유지 보수와 확장이 쉬운 시스템을 만들고자 할 때 이 원칙들을 함께 적용하여 프로그래머가 소스 코드가 읽기 쉽고 확장하기 쉽도록 설계하기 위해 원칙을 적용하여 개발한다.

<br>

S : 단일 책임 원칙(Single responsibility principle, SRP)   
O : 개방-폐쇄 원칙(open-closed princicle, OCP)  
L : 리스코프 치환 원칙(Liskov subsitution principle, LSP)  
I : 인터페이스 분리 원칙(Interface segregation principle, ISP)  
D : 의존관계 역전 원칙 (Dependency inversion principle, DIP)  


SRP - 단일 책임 원칙 
---
> 어떤 클래스를 변경해야 하는 이유는 오직 하나뿐이어야 한다.

-  하나의 객체가 하나의 책임만 져야 한다.
- 클래스를 단 한 가지 목표만 가지고 작성해야 한다.
- 애플리케이션 모듈 전반에서 높은 유지보수성과 가시성 제어 기능을 유지하는 원칙이다.

<br>

SRP 예제
-

```java
//직사각형의 넓이를 구하는 클래스
public class RectangleAreaCalculator {
    private static final double INCH_TERM = 0.0254d;
    private final int width;
    private final int height;

    public double areaRectangle(double width, double height){
        // 직사각형의 넓이
        return width * height;
    }

    public double meterToInches(int area) {
        // 미터를 인치로 바꾸는 메소드?
        return area / INCH_TERM;
    }
    // 메소드 제거 후 클래스 분리
}
```

**RectangleAreaCalculator** 클래스는 직사각형의 넓이를 구하는 클래스이지만 미터를 인치로 바꾸는 메소드를 포함하고 있어 단일 책임 원칙을 위한한다.  
**meterToInches** 메소드를 별도의 **AreaConverter** 클래스로 생성하여 옮겨주어 단일 책임 원칙을 따르도록 변경한다.

클래스가 수행하는 일을 표현하기 위해 또한(or)을 넣어 여러가지 일을 하는것처럼 생성하는것도 단일 책임 원칙에 어긋난다.


<br>

OCP - 개방 폐쇄 원칙
----
> 자신의 확장에는 열려 있고, 주변의 변화에 대해서는 닫혀 있어야 한다.

- 소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에 대해서는 열려 있어야 하지만 변경에 대해서는 닫혀 있어야 한다.  
- 다른 개발자가 작업을 수행하기 위해 반드시 수정해야 하는 제약 사항을 클래스에 포함해서는 안되고, 다른 개발자가 클래스를 확장하기만 하면 원하는 작업을 할 수 있도록 해야한다.
- 다양하고 직관적이며 유해하지 않은 방식으로 소프트웨어 확장성을 유지한다.

<br>

OCP 예제
---
```java
public interface Shape {}

public class Rectangle implements Shape {
    private final int width;
    private final int height;

    ···
}

public class Circle implements Shape {
    private final int radius;

    ···
}

public class AreaCalculator {
    private final List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes){
        this.shapes = shapes;
    }

    public double sum() {
        int sum = 0;
        for (Shape shape : sheaps) {
            // 각 도형 별로 if-else문으로 구성 (개방-폐쇄 원칙 위반)
            if (shape.getClass().equals(Circle.class)){
                ···
            } else if (shape.getClass().equals(Rectangle.class)) {
                ···
            }
        }
        return sum
    }
}
```

현재 클래스 에서는 각 도형 별로 if-else문으로 구성되어있어 새로운 도형 추가 시 else-if문이 추가 되어야한다. 해당 내용은 개방-폐쇄 원칙을 위반한다.

개방 폐쇄 원칙을 따르기 위해서 인터페이스 내에 각 넓이를 구하는 메소드를 추가하여 각 도형에 따른 area 객체를 호출하여 사용한다.


```java
public interface Shape {
    public double area();
}

public class Rectangle implements Shape {
    private final int width;
    private final int height;

    ···

    @Override
    public double area() {
        return width * height;
    }
}

public class Circle implements Shape {
    private final int radius;

    ···

    @Override
    public double area() {
        return Math.Pi * Math.pow(radius, 2);
    }
}

public class AreaCalculator {
    private final List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes){
        this.shapes = shapes;
    }

    public double sum() {
        int sum = 0;
        for (Shape shape : sheaps) {
            // 다른 도형 추가시에도 지장 없음. (개방-폐쇄 원칙 성립)
            sum == shape.area();
        }
        return sum;
    }
}
```

이전 if-else 문으로 작성을 했을 때와 차이는 도형이 추가되더라도 **AreaCalculator** 클래스에는 영향이 없다.

<br>

LSP - 리스코프 치환 원칙
---

> 서브 타입은 언제나 자신의 기반 타입(base type)으로 교체할 수 있어야 한다.
- 리스코프 치환 원칙으로 파생 타입은 반드시 기본 타입을 완벽하게 대체할 수 있어야 한다.
- 서브클래스의 객체는 슈퍼클래스의 객체와 반드시 같은 방식으로 동작해야한다.
- 타입 변환 후에 뒤따라오는 런타임 식별에 유용한 원칙이다.


> 하위 클래스 is a kind of 상위 클래스 - 하위 분류는 상위 분류의 한 종류다.  
구현 글래스 is able to "인터페이스" - 구현 분류는 "인터페이스"할 수 있어야 한다.

***인터페이스 할 수 있어야한다는 인터페이스 이름을 명명한 것에 따라 부르면 자연스럽다.***
위 두개의 문장대로 구현된 프로그램 이라면 리스코프 원칙을 잘 지키고 있다는 것이다.


<br>

리스코프 치환 원칙 사례
---
앞서 내용을 정리 하였지만 글로는 잘 이해가 되지않아 예시를 보고 확인해보자.

객체 지향에서의 상속과 같이 조직도나 계층도가 아닌 분류도가 되어야한다라고 제안한다.

예를 들어 가족간의 관계도에서 아버지라는 상위 클래스를 상속 받는 딸이라는 하위 클래스가 있다면 상위 클래스의 객체 참조 변수에는 하위 클래스의 인스턴스를 할당 할 수 있다.

```
아버지 춘향이 = new 딸();
```

아버지의 역할(메소드)을 딸에게 상속을 해봤자 딸은 아버지의 역할을 하는 것이 말이 안된다.


```
동물 펭수 = new 펭귄();
```

동물 클래스와 이를 상속받는 펭귄 클래스의 경우에 논리적으로 틀리지 않는다.
펭수라고 이름을 지은 펭귄이 동물 클래스에 있는 행위를 하는 것이 이상하지않다.

> 하위 클래스의 인스턴스는 상위형 객체 참조 변수에 대입해 상위 클래스의 역할을 하는 데 문제가 없어야 한다.
>> 하위형에서 선행 조건은 강화될 수 없다.  
하위형에서 후행 조건은 약화될 수 없다.  
하위형에서 상위형의 불변 조건은 반드시 유지돼야 한다.


<br>

ISP - 인터페이스 분리 원칙
---

> 클라이언트는 자신이 사용하지 않는 메서드에 의존 관계를 맺으면 안된다.

- 인터페이스 분리 원칙으로 클라이언트가 사용하지 않을 불필요한 메소드를 강제로 구현하게 해서는 안된다.
- 클라이언트가 사용하지 않을 메소드를 강제로 구현하는 일이 없을 때까지 하나의 인터페이스를 2개 이상의 인터페이스로 분할하는 원칙

<br>

인터페이스 분리 원칙 위반 예시
---
```java 
//Connection.java
public interface Connection {
    public void socker();
    public void http();
    public void connect();
}

//WwwPingConnection.java
public class WwwPingConnection implements Connection {
    private final String www;

    public WwwPingConnection(String www) {
        this.www = www;
    }

    @Override
    public void http(){ ··· }

    @Override
    public void connect(){ ··· }

    
    @Override
    public void socker(){ 
        //해당 클래스에서는 socket이 필요가 없어 실행 코드가 없다.
    }    
}
```

```java
WwwPingConnection www1 = new WwwPingConnection("www.naver.com");

www1.socket(); // 소켓을 선언하여도 클라이언트는 아무것도 알 수 없게 된다.
```

Connection 인터페이스를 WwwPingConnection을 통해 구현하지만 해당 클래스에서 socket과 같이 필요가 없는 메소드는 빈칸으로 구현된다.

인터페이스 분리 원칙 올바른 예시
---

```java
//Connection.java
public interface Connection {    
    public void connect();
}
//HttpConnection.java
public interface HttpConnection extends Connection {
    public void http();
}
//SocketConnection.java
public interface SocketConnection extends Connection {
    public void socket();
}
//WwwPingConnection.java
public class WwwPingConnection implements HttpConnection {
    private final String www;

    public WwwPingConnection(String www) {
        this.www = www;
    }
    @Override
    public void http(){ ··· }

    @Override
    public void connect(){ ··· }
}
```
인터페이스 분리 원칙을 준수하기 위해 Connection 클래스를 분리 하여 작성한다.






<br>

DIP - 의존 역전 원칙
---
> 자신보다 변하기 쉬운 것에 의존하지 말라

- 고차원 모듈은 저차원 모듈에 의존하면 안 된다. 이 두 모듈 모두 다른 추상화된 것에 의존해야 한다.  
- 추상화된 것은 구체적인 것에 의존하면 안 된다. 구체적인 것은 추상화된 것에 의존해야 한다.  
- 자주 변경되는 구체(Concrete) 클래스에 의존하지 마라.

<br>

의존관계 역전 원칙 위반 예시
----

```java
//PostgreSQLJdbcUrl.java
public class PostgreSQLJdbcUrl {
    private final String dbName;

    public PostgreSQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }
    public String get() {
        return "jdbc:postgresql:// ..." + this.dbName;
    }
}
//ConnectToDatabase.java
public void connect(PostgreSQLJdbcUrl postgresql){
    System.out.println("Connecting to " + postgresql.get())
}
```

다른 DB 연결을 위해 JDBC URL을 추가한다고 하면 **connect(PostgreSQLJdbcUrl postgresql)**은 재사용 할 수 없다.

따라서 구체화에 대한 의존관계를 버리고 추상화에 대한 의존관계를 만들어야 한다.


의존관계 역전 원칙 준수 예시
---
```java
//JdbcUrl.java
public interface JdbcUrl {
    //인터페이스로 추상화 구현
    public String get();
}
//PostgreSQLJdbcUrl.java
public class PostgreSQLJdbcUrl implements JdbcUrl {
    private final String dbName;

    public PostgreSQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String get() {
        return "jdbc:postgresql:// ..." + this.dbName;
    }
}
//ConnectToDatabase.java
public void connect(JdbcUrl jdbcUrl){
    //새로운 Jdbc연결이 필요해도 변경할 부분이 없다.
    System.out.println("Connecting to " + jdbcUrl.get())
}
```


<br>

🍕 SoC(Separation Of Concerns) - 관심사의 분리
---
관심이 같은 것끼리는 하나의 객체 안으로 또는 친한 객체로 모으고, 관심이 다른 것은 가능한 따로 떨어져 서로 영향을 주지 않도록 분리하라는 것이다.

하나의 속성, 하나의 메서드, 하나의 클래스, 하나의 모듈, 또는 하나의 패키지에는 하나의 관심사만 들어있어야 한다.

SOLID 원칙과 함께 자주 나오는 용어이다!


<br>

면접예상질문
--
각 개념에 대한 이해를 묻는 질문 또는 간단한 코드를 통한 예시 설명

<br>



출처 : 스프링 입문을 위한 자바 객체 지향의 원리와 이해,   
자바 코딩 인터뷰완벽가이드