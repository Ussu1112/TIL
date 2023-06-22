## 230612 Mybatis 활용 회원가입 및 로그인 구현

DTO란 Data Transfer Object의 약자로, 계층 간 데이터 전송을 위해 도메인 모델 대신 사용되는 객체이다.

로그인과 회원가입을 위해 dto를 다음과 같이 구성한다.

```java
@Getter
@Setter
public class LoginReqDTO {
    private String username;
    private String password;
}
```

```java
@Getter
@Setter
@ToString
public class JoinReqDTO {
    private String username;
    private String password;
    private String fullname;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .fullname(fullname)
                .build();
    }
}
```

로그인은 select 이지만, post 요청 보낸다.

```java
@PostMapping("/login")
public String login(LoginReqDto loginReqDto) {
    System.out.println("실서버");
    System.out.println(loginReqDto.getUsername());
    System.out.println(loginReqDto.getPassword());
    if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty()) {
        throw new CustomException("username을 입력해주세요", HttpStatus.BAD_REQUEST);
    }
    if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty()) {
        throw new CustomException("password를 입력해주세요", HttpStatus.BAD_REQUEST);
    }

    // 레파지토리 호출 (조회)
    User principal = userRepository.findByUsernameAndPassword(loginReqDto);

    if (principal == null) {
        throw new CustomException("아이디 혹은 비번이 틀렸습니다", HttpStatus.BAD_REQUEST);
    }    

    // 아파치/톰켓의 저장 영역
    // (request - 응답이 되는 순간 사라짐, session - 브라우저가 켜져 있는 동안)
    session.setAttribute("principal", principal);

    return "redirect:/";
}
```

------ HTTP 최초 로직!!!!!!!!
HTTP로 만들어진 서버는 stateless 이다.   
stateless 상태를 저장하지 않는 서버!!   
클라이언트가 request(get,post,put,delete) 요청을 하면!!   
서버는 거기에 해당하는 처리를 하고, response 응답을 한다.   
서버는 클라이언트의 정보를 저장하지 않는다.  
서버는 멀티쓰레드 프로세스이다. 서버는 다수의 클라이언트의 요청 동시에 받을 수 있다.   
부하를 방지하기 위해서 클라이언트 정보를 기억안함.    

클라이언트의 정보를 기억해야하는 stateful 한 서버가 필요해진다.   
그 저장공간에 session이다. 그래서 세션에 저장해야한다.

session에 저장한 principal를 확인하여 로그인 상태를 확인한다.
로그인 상태에 따라 메뉴를 분기하여 노출할 수 있다.

```html
<c:choose>
    <c:when test="${principal != null}">
        <li><a href="/account">계좌목록(인증)</a></li>
        <li><a href="/account/saveForm">계좌생성(인증)</a></li>
        <li><a href="/account/transferForm">이체하기(인증)</a></li>
        <li><a href="/logout">로그아웃</a></li>
    </c:when>
    <c:otherwise>
        <li><a href="/loginForm">로그인</a></li>
        <li><a href="/joinForm">회원가입</a></li>
        <li><a href="/account/withdrawForm">출금하기(미인증)</a></li>
        <li><a href="/account/depositForm">입금하기(미인증)</a></li>
    </c:otherwise>
</c:choose>
```



```java 
    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) { // DTO로 받는 것이 좋다.
        // 1. POST, PUT일 때만 유효성 검사 (이것보다 우선되는 것이 인증 검사이다)
        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new CustomException("username을 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getFullname() == null || joinReqDto.getFullname().isEmpty()) {
            throw new CustomException("fullname을 입력해주세요", HttpStatus.BAD_REQUEST);
        }

        // 컨벤션 : post, put, delete 할때만 하기
        // 서비스 호출 => 회원가입();
        userService.회원가입(joinReqDto);

        return "redirect:/loginForm";
    }
```

POST요청과 PUT요청시에만 BODY 데이터가 있다.  
해당 BODY데이터는 컨트롤러 메서드의 매개변수에 주입된다.(DS)   
스프링은 x-www-form-urlencoded가 기본 파싱전략   
key=value&key=value (form태그의 기본 전송 전략)   
컨트롤러의 메서드는 매개변수에서 두가지 방식으로 데이터를 받는다.   
1. 그냥 변수, 2. DTO(Object)   
주의 : key이름과 변수이름이 동일해야 한다.  


## 230614 

- HttpServletRequest

Controller 매개변수에는 request정보와 IoC 컨테이너 정부를 전부 주입할 수 있다.

해당 코드는 가능한가?
@Autowired
private HttpServletRequest request;
-> 싱글톤으로 관리가 되는 것이기 때문에 불가

@Autowired
private HttpSession session;
-> 독립적으로 하나만 가지고 있기 때문에 가능


- 프레임워크에서는 model을 정의 하여 사용하지만 원래는 HttpServletRequest request에 저장하는 것이다.
request.setAttribute("accountList", accountList);
request.setAttribute("name", "gildong");
- 프레임 워크 사용시에는 model에 add하여 사용한다.


DTO는 똑같은게 존재해도 공유해서 쓰지 않는다.
-> DTO는 화면에 나타나는 데이터 (자주 변경될 수 있음)


```java
@GetMapping({ "/", "/account" })
    public String main(Model model) {
        // 부가 로직 - 공통 코드로 뺄 수 있다. 리플렉션 활용하여 AOP로 활용
        // 1. 인증 검사 (시큐리티, 인터셉터)
        // 다운캐스팅
        User principal = (User) session.getAttribute("principal");
        if (principal == null){
            throw new AuthException("인증되지 않았습니다.");
        }
        // 부가 로직 끝

        // 핵심로직
        // 2. 레포지토리 - 조회
        List<Account> accountList = accountRepository.findByUserId(principal.getId());

        // 3. 조회된 결과를 - 가방에 담는다. (request)
        model.addAttribute("accountList", accountList);
        model.addAttribute("name", "gildong");

        // 핵심 로직 끝
        return "account/main";
    }
```

부가 로직과 핵심 로직으로 나누어 작성한다.
부가 로직은 공통 코드로 뺄 수 있다. 리플렉션 활용하여 AOP로 활용


### JSP


jsp - foreach
```jsp
<c:forEach var="account" items="${accountList}">
    <tr>
    <td><a href=/account/${account.id}>${account.number}</a></td>
    <td>${account.balance}</td>
    </tr>
</c:forEach>
```

jsp - 로직에 따른 분기
```jsp
<c:choose>
    <c:when test="${principal != null}">
        <li><a href="/account">계좌목록(인증)</a></li>
        <li><a href="/account/saveForm">계좌생성(인증)</a></li>
        <li><a href="/account/transferForm">이체하기(인증)</a></li>
        <li><a href="/logout">로그아웃</a></li>
    </c:when>
    <c:otherwise>
        <li><a href="/loginForm">로그인</a></li>
        <li><a href="/joinForm">회원가입</a></li>
        <li><a href="/account/withdrawForm">출금하기(미인증)</a></li>
        <li><a href="/account/depositForm">입금하기(미인증)</a></li>
    </c:otherwise>
</c:choose>
```



공부해볼만한 것
1. 소켓통신
2. 네트워크 이론 (유튜브)
3. 디자인패턴 (SOLID)