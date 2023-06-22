## 230609 h2 database 연결 및 테스트 해보기

springboot에서 myBatis를 통해 DB를 연결하고 테스트를 진행하는 예제이다.

사용하는 DB는 in-memory db인 h2를 사용하였다.

gradle 파일에 의존성을 주입해주자.

`testImplementation group:'org.mybatis.spring.boot', name:'mybatis-spring-boot-starter-test', version: '2.2.2'`


사용한 application.yaml 파일은 다음과 같다.
```yaml
server:
  port: 8080
  servlet:
    encoding:
      charset: utf-8
      force: true
 
spring:
  mvc:
    view:
      prefix: /WEB-INF/view/
      suffix: .jsp 
  datasource:
    url: jdbc:h2:mem:test;MODE=MySQL
    driver-class-name: org.h2.Driver
    username: sa
    password:
  sql:
    init:
      schema-locations:
        - classpath:db/table.sql
      data-locations:
        - classpath:db/data.sql
  h2:
    console:
      enabled: true

mybatis:
  mapper-locations:
  - classpath:mapper/**.xml
  configuration:
    map-underscore-to-camel-case: true
```

테이블과 테이블에 넣을 정보를 sql 형태로 만들어놓고   
sql : init : 부분을 통해 서버 실행 시 자동으로 sql 를 실행하게 만든다.


```sql
-- table.sql
CREATE TABLE user_tb(
                        id int auto_increment primary key,
                        username varchar unique not null,
                        password varchar not null,
                        fullname varchar not null,
                        created_at timestamp not null
);
CREATE TABLE account_tb(
                           id int auto_increment primary key,
                           number varchar unique not null,
                           password varchar not null,
                           balance bigint not null,
                           user_id int,
                           created_at timestamp not null
);
CREATE TABLE history_tb(
                           id int auto_increment primary key,
                           amount bigint not null,
                           w_balance bigint,
                           d_balance bigint,
                           w_account_id int,
                           d_account_id int,
                           created_at timestamp not null
);

-- data.sql
INSERT INTO user_tb(username, password, fullname, created_at) values('ssar', '1234', '쌀', now());
INSERT INTO user_tb(username, password, fullname, created_at) values('cos', '1234', '코스', now());
INSERT INTO account_tb(number, password, balance, user_id, created_at) values('1111', '1234', 1000, 1, now());
INSERT INTO account_tb(number, password, balance, user_id, created_at) values('2222', '1234', 1000, 2, now());

INSERT INTO history_tb(amount, w_balance, d_balance, w_account_id, d_account_id, created_at) values(100, 900, 1100, 1, 2, now());
INSERT INTO history_tb(amount, w_balance, d_balance, w_account_id, d_account_id, created_at) values(100, 800, null, 1, null, now());
INSERT INTO history_tb(amount, w_balance, d_balance, w_account_id, d_account_id, created_at) values(100, null, 900, null, 1, now());

commit;
```


설정 해둔 mapper 파일의 내용을 테스트하기 위해 test/java/.. 에 클래스와 같은 폴더 구조를 생성하고
테스트할 RepositoryTest 파일을 생성해준다.


테스트 할 mapper 파일
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="shop.mtcoding.bankapp.model.user.UserRepository">
     <select id="findAll" resultType="shop.mtcoding.bankapp.model.user.User">
        select * from user_tb
    </select>

    <select id="findById" resultType="shop.mtcoding.bankapp.model.user.User">
        select * from user_tb where id = #{id}
    </select>   

    <select id="findByUsernameAndPassword" resultType="shop.mtcoding.bankapp.model.user.User">
        select * from user_tb where username = #{username} and password = #{password}
    </select> 

    <insert id="insert">
        insert into user_tb (username, password, fullname, created_at) values(#{username}, #{password}, #{fullname}, now())
    </insert>    

    <delete id="deleteById" >
        delete from user_tb where id = #{id} 
    </delete>    

    <update id="updateById" >
        update user_tb set username= #{username}, password= #{password}, fullname= #{fullname} where id = #{id} 
    </update>    

</mapper>
```


테스트 파일은 다음과 같이 작성된다.

```java
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// @MybatisTest 어노테이션 추가
@MybatisTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findById_test(){
        //given
        int id = 1;

        //when
        User user = userRepository.findById(id);

        // then (눈으로 검증)
        System.out.println(user.getUsername());
        Assertions.assertThat(user.getUsername()).isEqualTo("ssar");
    }

    @Test
    public void findAll_test(){
        //given

        //when
        List<User> userList = userRepository.findAll();

        // then
        Assertions.assertThat(userList.get(0).getUsername()).isEqualTo("ssar");
        Assertions.assertThat(userList.get(1).getUsername()).isEqualTo("cos");
    }

    @Test
    public void insert_success_test(){
        //given
        String username = "ssar";
        String password = "1234";
        String fullName = "쌀";

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullName);

        //when
        int result = userRepository.insert(user);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void insert_fail_test(){
        //given
        String username = "ssar";
        String password = "1234";
        String fullName = "쌀";

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullName);

        //when
        int checkError = 0;
        try {
            int result = userRepository.insert(user);
        } catch (Exception e){
            checkError++;
        }
        //then
        Assertions.assertThat(checkError).isEqualTo(1);

    }

    @Test
    public void delete_test(){
        //given
        int id = 1;
        //when
        int result = userRepository.deleteById(id);
        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void update_test() {
        //given
        int id = 5;

        String username = "ssar";
        String password = "1234";
        String fullName = "쌀";

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullName);

        //when
        int result = userRepository.updateById(user);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }
}
```

기본적으로  given-when-then 형태로 테스트를 구성한다.

- given(준비): 어떠한 데이터가 준비되었을 때
- when(실행): 어떠한 함수를 실행하면
- then(검증): 어떠한 결과가 나와야 한다.

이번 수업에서 BDD 와 TDD에 대해서도 설명을 해주셨다.

BDD (Behavior Driven Development) : 행동 주도 개발 - 본 코드를 먼저 작성
TDD (Test Driven Development) : 테스트 주도로 개발 - 테스트 코드를 먼저 작성

웹을 사용할 때는 BDD로 짜는 것이 더 유리하고 그런 환경이라고 말씀하셨다.
장단점이 있으나 테스트가 힘든 상황인 경우에는 BDD가 유리할 듯 싶다.