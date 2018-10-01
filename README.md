

## 즐거운 자바 04 -  new 연산자와 인스턴스, static 키워드와 Hello 실행순서

- int 초기값은 0
- boolean 초기값은 false
- 객체가 메모리에 올라간 것을 인스턴스라고 한다.
- 클래스는 하나지만, 해당 클래스 때문에 메모리가 부족하여 죽을 수 있다.
  - for문으로 객체생성



### Hello class가 실행되기까지의 과정

1. 자바프로그램은 실행되려면 가져야 되는 메소드 : public static void main(String[] args)
2. java Hello [enter]   <---------- enter를 하게 되면 hello가 가지고 있는 static을 특별취급해서 메모리에 올려준다.

- java : JVM이 class를 읽어들이고 실행한다.
- 환경변수 설정 **CLASSPATH**의 값으로 .   .은 무엇을 의미할까요?  // 현재 폴더
- 만약 **CLASSPATH**의 값으로 C:/tmp 라고 설정되어있다 Hello 클래스를 어디서 찾을까요? // c:tmp 폴더

1. 디스크에서 Hello라는 클래스를 찾았다면 Hello 클래스를 사용하기 위하여 일겅 들입니다. 읽어 들일 때 static이라고 붙어 있는 것들은 특별 취급을 하게 됩니다. Hello 클래스는 어떤 부분에 static 이라는 단어가 붙어있나요?

   네 바로 아래와 같이 main 이라고 부르는 메소드에 static 이 붙어 있는 것을 학인 할 수 있습니다.

```java
public class Hello{
    public static void main(String[] args){
       System.out.println("Hello!!");
   }
}  

```

   JVM 은 Hello 의 main 메소는 특별 취급하게 됩니다. 여기서 특별취급이라 실행 가능하도록 메모리에 올려준다는 것입니다. 즉 Hello 클래스가 가지고 있는 모든 것들이 메모리에 올라가는 것이 아니라 Hello의 main메소드가 실행 가능하도록 메모리에 올라간다는 것을 의미합니다.

만약 Hello가 3개의 메소드를 가지고 있고, 3개의 메소드에 모두 static이 붙어 있다면 3개의 메소드가 모두실행 가능하도록 메모리에 올라가게 됩니다.



JVM은 Hello 클래스를 읽어 들인 후 Hello 클래스가 가지고 있는 메소드 중 static이라고 붙어 있는 것은 실행 가능하도록  합니다.

그리고 나서 JVM은 static 한 메소드 중에서 String 배열을 받아들이는 main 메소드를 찾습니다. main 메소드를 찾았다면 main메소드를 한 줄 한 줄 실행해 나갑니다.

main 메소드를 찾을 수 있는 이유는 메인메소드가 static하기 떄문에 메모리에 올라가 있기 때문에 찾을 수 있습니다.



##### 자바에서 메로리에 올리는 방법은 크게 2가지 방법이 있음

- new 클래스이름():  메모리에 인스턴스가 만들어진다.
- 클래스가 가지고 있는 필드나 메소드에 static을 붙여준다.
  특별취급. 메소드에 static이 붙어 있으면 실행가능.
  - 프로그램은 실행되려면 메모리에 올라가야 된다.
    메모리에 올라가 있지 않으면 실행할 수 없다.
    클래스를 사용하려면 인스턴스를 만들어줘야 한다.



##### 인스터스로 메모리에 올리는거와 static으로 메모리에 올리는 것의 차이는?

```java
Bus b1 = new Bus();
Bus b2 = new Bus();

b1.버스가 가지는 기능();
b2.버스가 가지는 기능();

//인스턴스가 없어도 어떤 기능을 사용하고 싶다.

public class Bus(){
    public static void ppangppang(){
        
    }
}
// 인스턴스를 만들지 않아도 기능을 사용할 수 있다.
Bus.ppangppang();
```

##### 클래스 선언문 자체는 메모리에 올라가나요??  즉 실행 파일에 포함이 되는건가요? 클래스 선언문 역시 소스코드의 용량을차지하니까 궁금합니다.

- 소스코드가 메모리가 올라가지 않는다. 클래스에 대한 정보가 딱 한 번 올라간다.
- 클래스에 대한 정보는 Perm이라는 영역에 딱 한 번 올라간다.(Perm은 자바가 관리하는 메모리영역임)





java Hello
Hello.main <--- static. 실행 가능하도록 메모리에 올린다.

만약 Hello가 다른 메소드를 가지고 있고, 해당 메소드가 static이 붙어 있으면 그 메소드도 실행가능하도록 메모리에 올라갈 것이다.

JVM은 static한 메소드 중에서 main(String[]) 메소드를 찾아서 실행한다. 그리고 난후 JVM은

main메소드를 찾아서 한줄 한줄 실행한다.(인터프리터 방식)



```java
java Hello 안녕하세요 홍길동 [enter] // 메인 메소드의 파라미터로 들어간다. 프로그램 아규먼트(실행할때 넣어주는 것) : 홀길동 안녕은 프로그램 아규먼트이고 String[] 스트링 배열이다.

public static void main(String[] args){
    System.out.println("Hello!!");
}
```

main메소드를 실행할 때 String을 발견!!!!
JVM은 String클래스를 찾아서 읽는다.
String이 static한 것들을 가지고 있는지 본다.
즉 String 인스턴스가 만들어지기 전에 static한 것들은 미리 사용가능하게 됩니다.

인스턴스보다 static한 것들은 무조건 먼저 메모리에 올라간다.
그 클래스가 발견되고 읽혀질때 올라간다

System 을 발견!!! System이 가지고 있는 무엇을 특별취급? static

System.out이 통째로 메모리에 올라간다. out은 printStream이라는 Class임.

System.out.println("Hello!!");

System이 가지고 있는 static한 필드 out

그 static한 필드 out이 가지고 있는 println이라는 기능을 사용

```java
class System{
    static PrintStream out = new ....(); //초기화
}
```





## 즐거운 자바05 - 다른 사람이 만든 클래스 사용하기, package, import, 클래스 변수와 인스턴스 변수



### 다른 사람이 만든 클래스 사용하기(Random, Math)



- 자바도 java 파일 -> 컴파일 -> class 파일

  class 파일도 많아진다.

  class도 폴더 별로 관리할 필요가 있다

  한 폴더에 같은 이름의 파일이 여러개 있을 수 있나?

  자바를 만든 사람들은 클래스를 관리하기 위해여 package라는 개념을 만들었다.
  package = 폴더

- class를 만들 때 package 이름을 kr.co.sunnyvale.first
  컴파일이 될 때 kr폴더 - co폴더 - sunnyvale폴더 - first 폴더 - class 파일 생성

  - package가 있을 경우 컴파일 할 때 -d 라는 옵션을 넣어준다.

    ```java
    javac Hello.java // 피키지가 없을 경우
    javac -d 폴더명 Hello.java // 패키지가 있을 경우 -d
    javac -d c:\tmp Hello.java
    
    c:\tmp 디렉토리에 kr - co - sunnyvale -first - Hello.java
    ```




- package는? 폴더
  보통의 경우 도메인 이름을 거꾸로 + 프로젝트명
  package가 있을 경우 컴파일 할 떄 -d 옵션으로 패키지가 생성될 경로를 지정한다.



- 자바가 기본으로 제공하는 package 중에서 초보자들이 꼭 봐야 할 package?

  - java.lang - 기본이 되는 package (import 하지 않아도 사용할 수 있다.)
  - java.util - 유용한 class - 날짜, 자료구조 ....
  - java.io - 입출력
  - java.net - 네트워크




- import 라는 것은 사용하는 클래스가 어떤 패키지에 있느냐라는 것을 JVM과 컴파일러에게 알려준다. 
  - java.lang 패키지에 있는 클래스들은 import하지 않아도 사용가능



#### Constructor ( 생성자 )

- 생성자 : 인스턴를 생성.
  Book book = new Book();



- 생성자는 왜 중요? 

  - 어떤 클래스를 사용하려면 인스턴스를 만들어야 한다. 

- Random Constructor

  ```java
  - Random()
  Create a new random number generator.
  
  - Random(long seed)
  Creates a new random number generator using a single long seed.
  ```

  - import java.util
    Random r1 = new Random();  // 인스턴스를 만들어야 사용가능
    r1.메소드();



- Random 예제

  ```java
  public class RandomTest {
      
      public static void main(String[] args){
          // ctrl + shift + o
          Random r= new Random();
          
          // r.nextInt(6)     -->     0 <= x < 5
          // r.nextInt(6) + 1 -->     1 <= x < 6
          int dice = r.nextInt(6) + 1;
          System.out.println(dice);
      }
  }
  ```

- static 이 붙어 있지 않은 메소드는 반드시 인스턴스를 만들고, 그 인스턴스를 참조하는 참조 변수를 통하여 사용



- Math

  - 생성자에 대한 설명이 api에 없다 - 생성자가 없는 class는 없다.
  - 생성자를 사용못하게 하는 class 는 있다. -> private 생성자를 가지고 있으면 사용불가.
    private 생성자는 api설명서에 나오지 않는다.
  - import java.lang.Math; // <----  삽입할 필요가 없다.
    Math m =  new Math(); // 컴파일 오류

  ```java
  public class MathText {
      
      public static void main(String[] args){
          
          // static메소드는 Class이름.메소드(); 이런 형식이다.
          // 기본적으로는 Class를 사용하려면 인스턴스를 만들고 사용해야한다.
          // 0.0 <= x < 1.0
          double rand = Math.random();
          // 0.0 <= x < 6.0
          rand = rand * 6;
          // (int) 로 형변환 - 정수 -> 잘림
          // 0 <= x < 6
          int irand = (int) rand;
          // 1 <= x < 7
          int dice = irand + 1;
          
          System.out.println(rand);
          
          int dice2 = (int)(Math.random() * 6) + 1;
          System.out.println(dice2);
      }
  }
  ```


### 모든 공부는 반복 훈련



### 클래스 변수와 인스턴스 변수

- 클래스 가지는 것 - 필드, 메소드

  - 필드 -> 클래스 변수(static이 붙어 있다), 인스턴스 변수

  **꼭 기억하자!!**
  static은 인스턴스가 만들어지기 전에 딱 한 번만 메모리에 올라간다.
  인스턴스(메모리에 올라감)는 언제 만들어지는가?  new 생성자();
  인스턴스가 만들어지지 않아도 static하다고 써있는 애들은 미리 클래스가 발견되는 순간 static한 것들은 미리 메모리에 올라간다.

```java
package kr.co.ksunnyvale.first;

public class MyBean {
    // class 변수
    static int staticValeu;
    
    // 인스턴스 변수 
    int instanceValue;
}
```



```java
package kr.co.ksunnyvale.first;

public class MyBeanTest {
    
    public static void main(String[] args) {
        // 같은 package에 있는 클래스는 import할 필요가 없다.
        // MyBean이 가지고 있는 클래스변수는 특별 취급 -> 사용할 수 있또록 미리 메모리에 올라간다. 아직 생성사 실행전
        // 같은 클래스는 디스크에서 딱 한번 만 읽어들인다.
        // 한 번 읽어들인 클래스 정보는 메모리에 올라가 있고,
        // 두번쨰 부터는 메모리에 있는 클래스 정보를 사용한다.
        // 1) MyBean.staticValue 는 미리 메모리에 올라간다.
        // 2) MyBean인스턴스가 만들어지고 이 인스턴스를 사용할 수 있는 
        //    bean1 참수변수가 만들어진다.
        MyBean bean1 = new MyBean();
        // 3) MyBean인스턴스가 만들어지고 이 인스턴스를 사용할 수 있는 
        //    bean2 참조변수가 만들어진다.
        MyBean bean2 = new MyBean();
        MyBean.staticValue = 5;
        System.out.println(MyBean.staticValue); // 5
        
    }
}
```



- package는 디렉토리
  kr.co.sunnyvale.first : package이름
  MyBean이라는 클래스가 해당 package가 있다.

  위의 클래스를 다른 클래스에서 사용하려면
  import kr.co.sunnyvale.first.MyBean;

  c:\tmp

  ​	-- kr
  ​		--- co
  ​			--- sunnyvale
  ​				--
  ​				first
  ​				---MyBean

  CLASSPATH=c:\tmp





## 즐거운 자바06 - 객체지향이란? 1/3



### 객체지향 개요

- **이름이 가지는 직관성**
  -  객체지향에서 가장 중요한 것은 무엇입니까?   // 이름
      이름만 봐도 무엇을 가지고 있는지 어떤 기능을 가지고 있는지 알 수 있다.
      이름을 봐도 모른다는 것은? 그것에 대한 경험이 없다.
      알아야지만 이름을 보고 이해를 할 수 있다.
      알아야지만 직관성이 생긴다. 

1. **추상화, 응집도** 

   - 추상화 : 중요한 것은 남기고 불필요한 것은 삭제한다.
     - 어디서의 고객이냐에 따라서 고객이 가지는 속성이 중요도가 달라진다
     - 재상용은 어렵다. 업무와 관련된 것은 재사용이 어렵다
       - 도서대여점
       - 신발가게
     - 도서대여점이 망할 것 같으니깐...  미리 신발사이즈를 넣어 놓겠다 ---> 이러면 안된다.
       - 객체지향을 한다는 것은 현실것만 집중하는 것이다. 미래는 아니다
   - 응집도 : 관련된 것을 잘 모아서 가지고 있다.
     - Math - 이름이 중요. 직관! 수학과 관련된 것을 잘 모아서 가지고있겠다.
       - Mat안에 있는 것을 다 외울 필요가 없다.
       - 당연히 Math에는 이러이러한 것이 있겠지? 접근



   **추상화, 응집도, 이름 ---- '객체는 역할이 있다. 책임도 있다'**

   - 알바의 역할이 있다는 것은, 알바에 대한 책임도 있다.



   **좋은 객체란 무엇인가? - 응집도는 높고, 결합도는 낮다**

   - 잘 추상화 되어있고
   - 잘 모아져야 있고
   - 이름도 잘 적혀있고

2.  **오버로딩(Overloading)**

   - 무엇을 먹었어요?
     밥버거를 먹었습니다.
     보쌈을 먹었습니다.
     장조림을 먹었습니다.

     000를 먹었습니다.


   - C언어
     plusint(int, int) - 함수
     plusfloat(float, float) - 함수
     C언어의 경우 파라미터의 수가 달라지거나, 파라미터의 type이 다르면 이름이 다른 함수를 만들어야 한다.

3. - 더하다! - 파라미터의 수가 달라지거나, 파라미터의 type가 다르다면 같은 이름으로 메소드를 여러개 만들 수 있다.  ---> 오버로딩

      

     - println을 여러개 만든 개발자는 피곤하였을꺼다. 하지만 사용하는 사람은 편하다.
     - 만드는 사람은 어렵게만들더라도, 사용하는 사람은 쉽게 사용한다.



**객체지향 프로그래밍이란?**

3. 도서 대여점에 존재하는 객체들

   - 도서 대여점에서 책을 관리하는 것은 누구?

   - 도서 대여점에서 고객을 관리하는 것은 누구?

   - 도서 대여점에서 돈을 관리하는 것은 누구?

   - 미녀와 야수 에니메이션 ~~ 야수의 성에 등장하는 인물은 누구?
     마법에 걸린 물건들....

     도서대여점도 야수의 성처럼 마법에 걸렸다.
     모든 물체가 살아있다.

      도서대여점엔 여러가지 물체가 있다.

      책장은 무엇을 가지고 있는가? 책을 가지고 있다.
      책장의 역할? -- 책을 관리하려면 책장

      책장아 너 책 몇 권 가지고 있어?
      금고에게 질문하기않고 책장에게 질문하는 것은 책장이 책을 가지고 있으니 책이 몇권 가지고 있는지 알려줄 수 있다고 기대한다.

      책은 무엇을 가지고 있느냐?
      책에게 너 제목이 뭐야?

      도서대여점의 모든 물체들이 살아 있다면.. 그 물체들은 모두 중요할까? 도서대여점을 관리하는 입장으로 봤을때?

      도서대여점 관리 프로그램을 만든다면...

      도서대여점 주인이 하는 일을 편하게  - 업무

      책을 관리하는 것은 누구? 책장
      고객을 관리하는 것은 누구? 고객장부
      돈을 관리하는 것은 누구? 금고

      객체지향프로그램 - 현실 세계를 그대로 프로그래밍으로 옮기는 것

     **현실 세계의 업무를 컴퓨터 세상에 맞도록 재창조 하는 것**

     책장 -> BookService 클래스
     고객명부 -> UserService 클래스

4. 현실 세계를 그대로 옮기는 것이 객체지향이다. 과연?

   - 현실 세계의 업무를 컴퓨터 세상에 맞도록 재창조 하는 것



5. 역할, 책임, 협력

   속성 ---> 필드
   기능 ---> 메소드

   - 협력 : 객체와 객체는 관계를 맺고 있다. 그래서 서로서로가 도와준다.
     - Sort를 하는 클래스가 있다면, 값을 비교하는 기능을 가지고 있는 클래스는 사용할 수 도 있다.

6. **has a 관계** :  속성(필드)  - 가지는 관계 (association 관계)



   선풍기 -----> -wing   날개   - 선풍기는 날개를 가진다. 



   선풍기

   wing : 날개

   on() : void







   Book

   price : int
   titile : String

   getTitle() : String
   setTitle() : void



​	어떤 기능이 사용될 때 다른 클래스가 사용된다면 이건 보통 의존한다.  - **Dependency관계**

​	PrintWriter             

​	println(String) : void    -----> String 



​	할아버지

​	걷다(지팡이): void    ------> 지팡이

​	메소드 안에서 사용되는 클래스들은 모두 의존관계이다. 여기서는 String만 보이지만
​	가지는 관계가 아닌데 메소드안에서만 사용되면 의존관계이다. 
​	가장많이 쓰이는 관계가 의존관계이다.  - 중요한 것만 표현한다.





7. 일반화, 확장, 추상클래스 그리고 상속 관계

   -  클래스는 객체를 만들기 위한 틀   ----> 인스턴스(객체)
       포유류 중에서 좋아하는 포유류 이름

     내일 점심에 먹고 싶은 음식의 이름

     포유류라는 단어는 실제 세상에 존재하는 것인가?
     사자는 존재하는데....



     포유류를 그리시오. 누군가에게 시켰을 때 그 결과가 다양하게 나온다면
     포유류는 구체적인 것이 아니다. 구체적인 것은 포유류라고 불리는 사자, 코끼리, 고래가 구체적인 것이다.
     사자, 코끼리, 고래 등을 일반화시켜서 부르는 단어가 포유류 



   단어로써는 존재하지만 실제로 인스턴스는 없는 것들은 우리가 그것을 추상클래스라고 말한다.
   단어는 있지만, 인스턴스다 ---> 가구, 전자제품 등

   ​		

   버스는 자동차다

   혹은 버스는 자동차의 한 종류다

   - 여러가지 있을 때 여러가지 것들에 대한 공통적인 개념을 뽑아서 하나로 부를 수 있다면 일반화 시키는 것
     - 버스, 트럭, 스포츠카 등에서 공통적인 개념을 뽑아서 자동차라고 부른다면 일반화

   - 반대로 자동차라는 단어를 보고 뒤에다 짐을 실고 흙을 싣는 것을 만들자  그럼 트럭이 될 수 있겠죠

     - 자동차 ---> 버스 or 트럭 이라는 개념이 등장한다면 확장



     일반화 + 확장 =======> 상속(  is a )
    
     - ~은 ~ 이다. 라는 개념적인 관계가 되어야만 상속을 사용 할 수 있다.



     많은 클래스를 보고 공통적인 것을 뽑아서 일반적인 클래스를 만들었다면   :: 상속
    
     어떤 클래스를 보고 개념을 확장시켜서 클래스를 만들었다면 : 상속
    
     위에 있는 것은 부모클래스
    
     아래에 있으면 자식클래스
    
     ​	
    
     자동차 c = new 자동차(); // 틀림 구체적인 모양이 없기때문에 실제 존재할 수 없다. 단어만 존재함.
    
     버스 b = new 버스(); // 버스인스턴스를 만들고, 저건 버스 b라고 부르자



   ​	버스가 있는데, 해당 버스를 가리키면서 자동차네~~

   ​	자동차 c = new 버스(); // 버스 인스턴스를 만들고, 자동차 c라고 부르자





   ​		   자동차

​	버스 	스포츠카 	트럭	

​	이층 버스





## 즐거운 자바07 - 객체지향이란? 2/3

- 상속?
  일반화 + 확장  == 상속

  자식을 보고                              부모를 도출

  버스, 트럭,  스포츠카 --------> 자동차라고 부르자 ( 일반화 )

  ​	-----------------------------------------

  부모 + 새로운것 --------> 자식

​	자동차 + 짐 ------------> 트럭( 확장 )



- 자동차라는 클래스는 개념만 있고, 인스턴스를 만들 수 없다면 -----> 추상클래스

```java

// 자동차는 추상클래스다.
public abstract class 자동차 {
    public void 달리다(){
        System.out.println("전륜구동으로 달리다");
    }
}

```

```java
// 자동차를 상속받고 있는 버스
public class 버스 extends 자동차 {
    public void 안내방송(){
        System.out.println("안내방송~");
    }
} 
```

```java
public class 이층버스 extends 버스 {
    
}
```

```java
public class 스포츠카 extends 자동차 {
    public void 터보() {
        System.out.println("터보!!")
    }
}
```

```java
public class 트럭 extends 자동차 { 
	
}
```



상속 관계 - is a, kind of,

- 트럭은 자동차다
  버스는 자동차다
  트럭은 자동차의 한 종류다
  버스는 자동차의 한 종류다.
- Stack - FILO 자료구조, 
- List - 순서가 있고, index에 해당하는 것을 꺼낼 수 있다, 순서를 기억한다.
  - Vector(리스트 형 자료구조)



Stack은 Vector다. == (Stack은 Vector를 상속받는다.)   // 같은말을 하는 것임  //자바에서 잘 못 구현! JDK 1.0 때 잘못구현 함.



**상속! 문법보다도 더 중요한 것은 개념.**
**is a 관계가 안 된다면 상속을 받으면 안 된다.**



api에

//자동차나 자동차의 후손들이 들어갈 수 있다.

// 아 자동차는 인스턴스가 될 수 없구나 그래서 자동차의 후손만 들어갈 수 있구나

public void 주차(자동차 c)



// Action이나 Action의 후손들
public void exec(Action a)



**노트북은 컴퓨터다**
**(자식)       (부모)**

```java
public class Test {
    public static void main(String[] args){
        버스 b1 = new 버스();
        b1.달리다(); // 부모가 가지고 있는 메소드
        b1.안내방송();
        
        자동차 c1 = new 자동차();  // (x) 추상클래스여서 자동차는 인스턴스가 될 수 없다.
        
        //버스가 있다. 해당 버스를 가리키면서 자동차다! (0)
        
        // 별표 10개
        //암기 : 조상타입의 참조변수로 후손 인스턴스를 가리킬수 있다.
        자동차 c2 = new 버스();
        c2.달리다();
        
        // 장점은???
        자동차 c3 = new 스포츠카(); // 주차요원이 스포츠카를 사용할 때 
        스포츠카 c4 = new 스포츠카(); // 주인이 스포츠카를 사용할 때
        
        
        
        
    }
}
```

```java
public class 주차장 {
    // 자동차는 추상class 인스턴스가 될 수 없다.
    // 주차메소드에 자동차는 못들어온다.
    // 자동차라고 불리는 것들(자동차의 자식들)이 들어올 수 있다.
    public void 주차(자동차 c){
        c.달리다();
    }
    
    // 이메소드는 자동차는 추상클래스니깐 자동차의 후손이 나오는 클래스야
    public 자동차 get() {
        return new 스포츠카();
    }
}
```



### **조상type으로 후손인스턴스를 참조할 수 있다.**

**A a = new C(); // 이 관계가 오류가 나지 않으면 A와 C는 조상(A)과 후손(B)관계**

**A <---- 무언가 <---- c  // A는 C의 조상클래스이거나 A는 C의 부모이거나**



**자바는 아무것도 상속받지 않으면 자동으로 Object를 상속 받는다**

Object obj = new 이층버스();  // (0)



```java
public class 만능상자{
    private Object obj;
    
    public void set(Object o){
        // 버스를 넣어줘도 Object가 가지는 메소드만 사용가능.
        obj = o;
    }
    
    public Object get(){
        return obj;
    }
}
```

```java
public class Test2 {
    
    public static void main(String[] args){
        만능상자 box = new 만능상자();
        
        버스 b = new 버스();
        
        box.set(b); // 오류가 안나는 이유? o
        
        // 형변환을 하지 않으면
        // box에서 나온 것은 버스이지만
        // Object가 가지고 있는 메소드만 사용가능.
        Object obj = box.get();
        // 형변환하여 꺼내고 있다.
        // 원래 넣었던 것이 버스라서 가능!
        버스 b2 = (버스) box.get();
    }
}
```



스포츠카 c = new 버스(); // (x)

자동차 c = new 이층버스(); // (o)



# 별100개

## **조상type으로 후손인스턴스를 참조할 수 있다.**

- 자동차 c = new 스포츠카(); // 자동차가 가지는 메소드만 사용가능
- 앞에 참조변수는 사용할 수 있는 메소드를 결정 해줌

## **메소드가 오버라딩 되면 무조건 자식의 메소드가 사용된다**

- c.달리다(); // 달리다가 오버라딩 되어 있다면 자식의 메소드가 사용된다.
- 오버라딩 되어 있다면 자식 메소드가 사용됨

```java
public class Test3 {
    public static void main(String[] args){
        자동차 c  = new 스포츠카();
        
        스포츠카 s = new 스포츠카();
        s.달리다(); // 후륜구동으로 달리다 /(아래 오버라드를 했기 때문에)
        s.터보();
        
        // 눈앞에 스포츠카가 있다.
        // 이 스포츠카를 가리키면서 자동차다.
        자동차 c = new 스포츠카();
        
        // 이어서, 그 자동차는 달린다.
        // 그 자동차는 전륜구동? 후륜구동?
        // 자동차
        c.달리다(); // 후륜구동으로 달리다 --> 사용할 수 있는 메소드는 자동차가 가지고 있는 메소드만 사용 할 수 있지만 메소드가 오버라이딩 되어있으면 실제사용되는 것은 오바라이딩 된 메소드가 사용이 됩니다.
        // c.터보();  --> 사용할 수 없다. 자동차 c이기 떄문에
    }
}
```

```java
public class 스포츠카 extends 자동차 {
    public void 터보() {
        System.out.println("터보!!");
    }
    
    // 메소드 이름이 같고, 파라미터의 수, 파라미터의 타입이 
    // 모두 같다면 오버라이딩. -- 중복되어 구현되다. 대채하는 것이 아니다.
    public void 달리다() {
        System.out.println("후륜구동으로 달리다");
    }
}
```





어떤 기능을 만들건인가? 고민? vs 구현부터 한다?  전자

---> 기능은 메소드를 의미함



어떤 기능을 구현할 것인가? 를 정하는 것이 중요하다 == 요구사항을 파악하는 것
고객이 필요로 하는 기능을 만든다. 기능고민부터 고민

자바에서는 기능을 선언 하는 방법으로 interface라는 문법을 제공한다.
초보자들은 이 interface가 어렵다. -- 기능을 도출하는 것! <-- 힘들다 초보자들은

사칙연산 프로그램
첫번째 : 더하기, 빼기, 곱하기, 나누기 기능이 필요하겠다. - **기능선언**(인터페이스)
두번째: 위의 기능을 구현한다. - 기능구현(클래스)

**인터페이스와 클래스의 관계는 구현의 관계**

엄밀히 말하면 인터페이스가 없다는 것은 생각이 없는 것. - 

- 인터페이스가 없다는 것은 기능구현을 미리 안하겠다는 이야기이기 때문임
- 기능을 미리 구현하겠다는 계획이 없었기 때문에



**인터페이스와 클래스의 관계는 구현의 관계**
**추상클래스와 클래스의 관계는 상속관계 - is a 관계 ( 개념이 틀리다)**

추상클래스는 클래스이긴 하지만 인스턴스가 안되어야 하는 경우에 추상클래스를 정의하는 것이고
인터페이스는 기능을 정의하는 것이다.  완전히 목표가 달라요.



자바라를 만든 사람들은 C++의 어려움 점, 포인터, 다중상속을 없앰
어떤 언어를 공부하시든. 그 언어의 철학에 맞도록 공부.

부모 클래스는 일반화한다. 자식클래스의 공통적을 뽑아서 부모클래스를 만든다.
이렇게 만들어진 부모클래스가 개념적으로 인스턴스가 되면 안된다. 그렇기 떄문에 추상클래스가 된다.
부모클래스가 인스턴스가 되도 된다고 해도 상관없으면 추상클래스가 아닌거죠
그러면서 개념적으로 부모가 가지고 있는 메소드가 있는데 이 메소드가 미리 구현될 필요가 없다.



경험! 많이 프로그래밍하고 설계한다. 개발은 설계의 완성을 위해 간다.
설계 -> 개발> 설계에 반영 -> 개발 반복작업
수정하는 작업을 리펙토링이라고 한다. 기존에 잘 돌아갔었는데 수정하고 나서도 잘 돌어가야 한다. Test와 함께 다닌다.



숙제 : TDD간단 조사 ~~ JUnit 이라는 것도 간단한 예제





## 즐거운 자바 08 - 객체지향이란? 3/3



오늘은 interface에 대한 내용

고객은 어떤 요구사항 말할 수 있음

- 요구사항 --- 기능적 요구사항, 비기능적 요구사항
  - 기능적 요구사항 : 장바구니 담기, 상품보기,  상품목록보기, 배송조회
  - 비기능적 요구사항 : 보통 품질과 관련된 요구사항. - 성능, 확장성, 동시접속자가 몇명일때 속도는 몇?  등
  - 기능적 요구사항은 같을 수 있지만 비기능적 요구사항은 달라질 수 있다. 비기능적 요구사항에 따라서 아키텍처가 달라질 수 있다.  
    - 하루 3,4명 접속하는 사이트랑 11번거처럼 몇 만명 들어오는 사이트
    - 아키텍처 -----> 구조

-------------------------------------------------------------------------------------------------------------------------------------------

요구사항은 구현보다 먼저 정의 되는 것.
기능 정의가 먼저 있고, 그 기능을 구현하는 것은 나중이다.
interface를 제공한다. - 기능을 선언하고 있다.
'class는 인터페이스를 구현한다''라고 말한다.

-----------------------------------------

초보자들은 interface를 어려워한다. 이유는 초보자들은 만들고 싶은 프로그램을 아직 정하지 않았다. 키보드에 손부터 올라가는 구현부터 하려고 한다!!!

현장에서는 기능부터(요구사항부터) 정의한다. 인터페이스가 굉장히 중요하다.
(기능은 메소드를 말하는 것이고 그 메소드를 가지고 있는게 인터페이스다.)

------------

프로그램 개발 순서를 보면 당연하게도 **인터페이스가 먼저나오고 그걸 구현하는 클래스**가 나오는 것이다.

x 어떤 책을 보면 자바는 다중상속을 지원하지 않아서 인터페이스로 그 부분을 해결한다.
자바는 단일 상속.

기능정의가 우선. 당연히 그 인터페이스를 구현하고 있는 클래스가 하나만 있더라도, 인터페이스는 필요하다
하나의 인터페이스가 있고, 그 인터페이스를 구현하는 여러개의 클래스가 있을 수 있다. 이것도 사실인데요 이게 목적이 아니라 인터페이스 자체가 목적이다.  
**그말인즉 선언이 우선된다.**

---------

인터페이스를 안다?
처음에 조카가 내 스마트폰을 가지고 놀았었어요
조카. 처음 보는 장난감 스마트폰을 어떻게 잘 가지고 놀 수 있죠? 받자마자?  // 모양이 같아서

운전면허. 실기시험.
운전석에 있는 것들을 신호에 맞게 잘 조작하는 것
엑센트 자동차로 운전면허취득!
다른 자동차는 운전할 수 없나?
나는 자동차가 움직이는 동작원리를 모르더라도 운전할 수 있다.
<u>내가 자동차 운전석 인터페이스만 알아도 운전할 수 있다.</u>

------

인터페이스 참조변수 = new 객체();
 Action이라는 인터페이스가 있고, ListAction이라는 클래스가 있다.
LIstAction이라는 클래스는 Action이라는 인터페이스를 구현하고 있다면

Action action = new ListAction(); // (0)

Action action = new Action(); // (x) 인터페이스는 선언만 된 껍데기이기 때문에 인스턴스가 될 수 없다

action.exec();

### **조상type으로 후손 인스턴스를 참조할 수(가리킬 수) 있다.**

## **인터페이스type으로 해당 인터페이스를 구현하고 있는 클래스의 인스턴스를 참조할 수(가리킬 수) 있다.**



질문~
인터페이스가 추상클래스가 될 수 없나요?

자동차가 추상클래스고 버스가 자식클래스
버스와 자동차는 무슨 관계? 상속관계. 
상속관계는 -- >is a 관계, kind of
버스는 자동차다. 버스는 자동차의 한 종류다.

자동차는 운전석인터페이스를 구현한다.
자동차는 운전석 인터페이스다. //(x) 말이 안됨

관계 자체가 다르다.(인터페이스와 추상클래스는 목적이 다르다)

**인터페이스는 기능을 정의한 것이다**



추상클래스?
추상클래스는 부모클래스인데, 개념적으로 인스턴스가 될 수 없다는 판단이 들면
추상클래스가 되는 것이다.(1)

**추상클래스가 가지고 있는 메소드 중에서 어떤 특정 메소드는 자식이 항상 오버라이딩 한다.**
**메소드가 오버라이딩되면 무조건 자식의 메소드가 호출된다.**

모든 자식이 항상 오버라이딩 할 경우 그럴경우 부모의 특정 메소드는 구현할 필요가 있는가? (필요없음)
그런 경우 해당 메소드는 추상메소드가 된다.

------------

인터페이스는? (20분부터)

인터페이스는 기능의 선언!!!!! 이것이 목적이다.
구현부터 생각하지 않는다.
인터페이스의 생각의 순서 : 고객이 원하는 기능이 이런건가? ---> 이런 기능 앞으로 만들어야겠네 ----> 나 이거 선언해야지 

클래스는 구현하는 것이다. 클래스는 실체가 있는 것이다. 클래스보다 인터페이스가 항상 먼저 나온다.



인터페이스는 엄밀하게 말하면 분석을 하면 등장한다.!!! 여기에 이런 기능이 필요하구나. 하면 등장하는 것이다.인터페이스는 기술을 모르는 사람도 생각할 수 있따.
클래스는 설계할 때 등장하는 것이다.

-------------------

자바를 만든 사람들이 실수 한 것이있다.

자바1.0!! 실수~~
Vector를 상속받는 Statck <------------ 개념적으로 잘못되었다. 



자바 1.2
개발자들이 자료구조를 열심히 공부!!!

이러이러한 자료구가 있다.
그자료구조는 이러이러한 기능이 필요하다.
개념이 등장

구현?  기능이 도출? // 위의 것은 기능이 도출된 것이다.



자료구조에는 Collection있다. -- 여기에 자료가 있다 라는 것을 정의한다 
애는 순서도 기억못하고 자료를 저장만 한다.
같은 값을 가진 자료가 여러개 저장될 수 있다. 굉장히 단순한 자료구조다
순서도 기억못하고 같은 데이터가 여러개 들어갈 수 있다.

물건이 들어가는 바구니라고 보면 된다. 
바구니에 물건을 집어넣었는데 어떤 물건이 먼저 넣었는지 기억을 못한다.
Collection은 5번쨰 물건을 꺼낸다? (x) 순서를 기억못하기 떄문에
Collection에 물건을 집어넣을 수 있따.



<interface>
Collection

add(E) : void
size() : int



구현이 아니라 자료구조를 공부하여 
여기에는 어떤 자료구조가 있고 이 자료구조는 어떤 기능이 있겠다 필요하다 라는 것을 
정의하고 있는 것이다
아직 어떻게 구현할지는 등장하지 않았다.

Collection은 몇번째 첫번째것 달라 이런것을 할 수 없다.
 그래서 고민했다. 여기에서 모든 것을 꺼낼려면 어떻게 하지? 이런 고민을 했다.
그래서 고민해서 등장한 것이 iterator이 등장했다.
iterator는  상자에서 물건을 꺼낼때 사용하는 인터페이스다

interator은 자료구조에서 물건을 꺼낼때 사용하는 인터페이스
(자료구조에서 물건을 꺼낼때는 이런 기능이 필요해 라는 것을 정의하는 것이다.)

<interface>
iter



숙제
Set인터페이스를 사용하는 예제를 만들기

Map 인터페이스를 사용하는 예제

Map에 값을 저장하고 모든 Key와 value를 꺼내는 예제.



## 즐거운 자바 09 - Exception 처리!

오늘 배울 내용은 Exception 처리에 대한 내요.
오류처리!

인스턴스가 만들어지면 메모리에 올라간다.

인스턴스는 어떤 메모리에 올라가느냐? 인스턴스는 heap이라고 불리는 메모리에 올라가게 됩니다

CalBean 이라는 클래스를 만들었는데.
main메소드가 가장 먼저 실행되었다. main메소드를 프로그램 시작점.
자바에는 Java Stack라고 불리는 메모리 영역이 있다.

메소드가 실행이 되면 현재 실행되는 메소드정보가 Stack Entry라고 불리는 공간에 저장이되고 그 Stack Entry는 Java Stack에 한 건 저장된다.



JavaStack, stackEntry, 지역변수, Stack Trace가 왜 저렇게 출력되는가?



Exception은 크게 2가지 종류가 있다

- RuntimeException - RuntionException을 상속받는 Exception -
- Checked Exception - RuntimeException을 상속받지 않고,
  Exception을 상속받은 클래스. -- 컴파일시에 익셉션 처리해주지 않으면 오류가 발생함 그래서 하기 싫어도 익셉션 처리해줘야 함

```java
public static void main(String[] args){
    int i = 6;
    int k = 0;
    try{
        int value = Cal.divide(i, k);
        System.out.println(value);
    } catch (IllegalArgumentException e){
        System.out.println("0으로 나눌 수 없다.")
    }
}

class Cal{
    /**
    * 파라미터 m을 n으로 나눈 결과를 리턴한다.
    * @param m
    * @param n
    * @return m을 n으로 나눈 결과
    * @throws IllegalArgumentException n이 0일 경우 발생한다.    
    */
    
    // didvide메소드는 IllegalArgumentException 이런 익셉션을 발생할 수 있따.
    public static int divide (int m , int n)
    			throws IllegalArgumentException { // 이메소드는 익셉션을 발생할 수 있따.
        if(n ==0){
            throw new IllegalArgumentException("0으로 나눌 수 없어요.")
        }
        int value = 0;
        value = m / n;
        return value;
    
	}
}



```

- 파라미터가 올바르기 않을 경우
  강제로 Exception을 발생. throw를 사용, 이 메소드가 어떤 Exception을 발생할 수 있다라는 경고는? 
  메소드 뒤에 throws 라고 적어주고 그 뒤에 Exception을 적어준다. 
- 먼저 파라미터가 올바른지 검사하는 습관



```java
public static void main(String[] args){
    int i = 6;
    int k = 0;
    try{
        int value = Cal.divide(i, k);
        System.out.println(value);
    } catch (ArithmeticException e){
        System.out.println("0으로 나눌 수 없다.")
    }
}

class Cal{
  
    
    // didvide메소드는 ArithmeticException 이런 익셉션을 발생할 수 있따.
    public static int divide (int m , int n)
    			throws ArithmeticException { // 이메소드는 익셉션을 발생할 수 있따.
       
        int value = 0;
        value = m / n;
        return value;
    
	}
}
```



```java
// 사용자 정의 Exception. 이름이 중요!!!
// 클래스 이름만 봐도 딱 뭐인지 알아야 한다.
// 파라미터가 뭔가 잘못되었나보다.
class ParameterException extends RuntimeException {
    public ParameterException(String msg){
        super(msg);
    }
    public ParameterException(Exception ex){
        super(ex);
    }
}
```







CalBean 예제가 실행된 후 
Exception이 발생하고 프로그램이 죽고
오류메시지가 출력되는 내용을 설명



잘못된 값을 반환하는 것은 오류가 나서 죽는 것보다 나쁘다!
잘못 실행되었을 경우에는 올바르지 않은 값을 리턴하는 것이 아니라, Exception이 발생하도록한다.

그 발생하는 Exception은 이름이 중요하다.

메소드 뒤에 throws라고 적은 후 되도록 해당 메소드가 발생하는 Exception들을 적어준다.

해당 메소드를 사용할 때는 throws 뒤에 있는 exception이 발생할 수 있구나라고 예상하고 적절히 try, catch, finally를 사용하여 Exception처리를 한다.

(이 메소드를 사용하는 사람들은 아 얘는 이런 메소드가 발생할 수 있겠구나 하고 Exception에 대한 처리를 해줄 수 있습니다.)



throws는 메소드에서만 사용합니다. throws는 익셉션을 발생하는 것이다.



## 즐거운 자바 10편 - 생성자, this, super

접근지정자, 생성자, this와 super



자동차 c = new 자동차();
생성자 - 인스터느를 생성할 때 생성자를 사용.
​		new 생성자();

java.util.Random 클래스

```java
java.util  
Class Random <--

java.lang.Object      // 부보클래스는 Object를 상속받고 있다.
	java.util.Random  // 아무것도 상속받지 않으면 Object를 상속받는다
	
All lmplemented interfaces: // 랜덤이라는 클래스는 Serializable 인터페이스를 구현하고 있음
	Serializable
	
Dircet Known Subclasses:
	SecureRandom, ThreadLocalRandom
	
Constructor Summary  // 중요
Random()
Creates a new random number generator
Random(long seed)
Creates a new random number generator using a single long seed



```

Ranmdom클래스는 생성자가 2개 있다.
Random(), Random(log)  - 생성자 오버로딩 // 생성자가 2개 이상있을 경우

java.lang.Math 클래스는 
생성자에 대한 설명이 없다.

Random r1 = new Random(); // Random은 인스턴스를 만들 수 있다.
Math m1 = new Math(); // 오류!  사실은 생성자가 있지만, 사용못하도록 되어있다. 그래서 api에서도 설명이 안된다. - 접근지정자와 관련된 내용.

Math는 모든 메소드가 static 한 메소드다.
Math.메소드명(); // Math는 인스턴스를 생성하지 않고 메소드를 사용하도록 만들어진 클래스다.

인스턴스를 만들려면 꼭 필요한 것이 무어이냐면 생성자가 꼭 필요하다.
생성자가 하는 일은 은스턴스가만들어질 때 해당 인스턴스를 초기화하는 기능을 가지고 있다.

// Member 라는 class가 있다.
// Member는 반드시 이름을 가지도록 하고 싶다.
// 이름은 인스턴스가 만들어질때 정해주고 싶다.

Member m1 = new Member("홍길동");
Member m2 = new Member("둘리")

// 처음엔 이름이 없는데, 나중에 이름을 정해주고 싶다.

Member m1 = new Member(); / 인스턴스가 만들어질 때 이름을 설정하지 않았다.
m1.setName("홍길동");

// 주소위라는 인스턴스를 만들고 싶은데, 면의 수는 기본으로 
// 6면이 되고 싶다. 사용자가 원한다면 면의 수를 다르게 설정하고 싶다.
// 한번 만들어진 인스턴스는 도중에 면의 수를 바꿀 수 없다.

Dice d1 = new Dice(); // 6면 기본생성자
DIce d2 = new Dice(9) // 9면

기본생성자가 - 생성자가 파라미터로 아무것도 안받아들인다면 이것을 우리는 기본 생성자라고 한다.

```java
public class MemberTest {
    
    public static void main(String[] args) {
        // new Member : Member 1.인스턴스가 만들어진다.
        // Member(String) :    2.생성자가 호출된다.
       
        Member m1 = new Member("홍길동");
        Member m2 = new Member("둘리");
    }
}
```

```java
public class Memeber {
    
}
// 컴파일 되면 Member.class 파일이 만들어진다.
// jad를 이용하여 디컴파일 하였다.
//
// public class Memeber
// {
//		public Member()
// 		{
//		}
// }
```

// http:://varaneckas.com/jad/
// jad : 



생성자를 하나도 만들지 않으면, 컴파일 할 때 아무일도 하지 않은 기본 생성자가 자동으로 만들어진다.

// 생성자 
접근지정자 클래스이름(파라미터){

}



// Member 라는 class가 있다
// Member는 반드시 이름을 가지도록 하고 싶다.
// 이름은 인스턴스가 만들어질때 정해주고 싶다.

```java
public class Member {
    // 이름을 가진다.
    // private - 해당 클래스 안에서만 사용가능.
    // 외부에서는 name을 접근 할 수 없다.
    private String name; // 멤버는 이름을 가지고 있다. private은 외부에서 사용할 수 없다.
    
    // 괄호안에 있는 것은 생성자에게 전달하는 파라미터
	// 괄호안에 선언된 String name --> 파라미터
    // this.name : 해당 인스턴스가 가지는 속성. 필드
    public Member(String name){
        this.name = name;
    }
}
```

​    
```JAVA
public class MemberTest {
	public static void main(String[] args) {
    	// new Member : Member 1.인스턴스가 만들어진다.
    	// Member(String) :    2.생성자가 호출된다.
        // 즉 먼저 인스턴스가 만들어지고 나서 생성자가 호출된다.
        // 인스턴스가 만들어졌다는 것은 멤버가 메모리에 올라가 있고
        // 멤버가 가지고 있는 속성 name도 메모리에 올라가 있다.
        // 그래서 this.name = name이 초기화가 됩니다.
    	Member m1 = new Member("홍길동");
    	Member m2 = new Member("둘리");
        
        // System.out.println(m1.name);
        // System.out.println(m2.name);
        System.out.println(m1.getName());
        System.out.println(m2.getName());
        
	}
}
```


```java

public class Member {
   	// name은 인스턴스 별로 관리가 된다.
    // name: 속성, 필드, 인스턴스변수(용어 알고 있기)
    private String name; // 멤버는 이름을 가지고 있다. private은 외부에서 사용할 수 없다.
    
    // 괄호안에 있는 것은 생성자에게 전달하는 파라미터
	// 괄호안에 선언된 String name --> 파라미터
    // this.name : 해당 인스턴스가 가지는 속성. 필드
    public Member(String name){
        this.name = name;
    }
    
    // public 메소드는 어디에서든 호출할 수 있다.
    public String getName(){
        return this.name;
    }    
}
```

**클래스가 생성자를 하나라도 가지고 있다면 자동으로 기본생성자는 만들어지지 않는다.**



```java
public calss Dice {
    // 속성으로 면의 수를 가지고 싶다.
    
    private int faceCount;
    
    public Dice(){ // 기본생성자
    	this.faceCount = 6;            
    }
    
    public int getFaceCount() {
        return this.faceCount;
    }
    
    public Dice(int faceCount) throw IllegalArgumentException {
        if(faceCount <= 1){
            throw new IllegalArgumentException("면의 수는 2이상이어야 합니다.")
        }
        this.faceCount = faceCount;
    }
}
```

```java
public class DiceTest {
    public static void main(String[] args) {
        Dice d1 = new Dice();
        Dice d2 = new Dice(9);
        System.out.println(d1.getFaceCount()); // 6

        
        try {
            Dice d2 = new DIce(0);
            System.out.println(d2.getFaceCount()); // 9
        } catch (IllegalArgumentException e){
            System.out.println("면이 2개 이상있어야 합니다.");
        }
        
    }
    
}
```







```java
public class Car {
    
    private String name;
    
    
    
    // Car기본생성자를 문자열을 받아들이는 생성자로 수정
    // 생성자가 하나라도 있따면 기본생성자는 만들어지지 않는다.
    // 그래서 Bus b1 = new Bus(); 가 에러가 난다.
    /
    public Car(String name){
        this.name = name;
        System.out.println("Car생성자");
    }
    
}
```

```java
public class Bus extends Car {
    
    
    public Bus() {
        super(); //  super는 부모를 의미한다.
        		 //  super() - 부모의 기본생성자
    }			
    			// Bus생성자에 아무것도 안적어줘도 자바버추얼머신은 가장 먼저 이안에 
    			// 부모생성자를 호출하는 코드를 자동으로 만들어줘서 실행해줍니다.
    			// 부모의(Car)의 기본생성자가 없으면 Bus() 부모의 생성자 호출메소드인
    			// super()을 자동으로 호출해주면 Car() (부모)에 기본생성자가 없어서 에러가 난다.
    
   public Bus() {
      super("b1"); // 부모가 기본생성가 없다면
       			// 반드시 프로그래머가 부모 생성자를 직접 호출.
       			// 해줘야 오류가 나지 않는다.
 
   }
}
```

```java
public class CarTest {
    public static void main(String[] args){
        Bus b1 = new Bus(); // Car생성자
    }
}
// Bus인스턴스가 만들어진다는 것은 
// Bus의 부모인 Car도 초기화가 되어야 한다는 것을 의미한다.
```









```java
public class StudentTest {
    public static void main(String args[]) {
        Student s1 = new Student("홍길동, 90, 90, 100");
        
        //s1.setName("홍길동");
        System.out.println(s1.getName()); // 홍길동
        System.out.println(s1.getKor());
        System.out.println(s1.getEng());
        System.out.println(s1.getMath());

    }
}
```

```java
public class Student {
    private String name;
    private int kor;
    private int math;
    private int eng;
    
    // 코드의 중복은 되도록 막아야 한다.
    public Student(String name) {
       this(name, 0, 0, 0); // public Student(String name, int kor, int math, int eng) 
        					// 이 생성자를 호출함
     						// this는 자기 자신을 가리킨다
        					// 자기 자신의 생성자를 호출하려면 this( ); 해주면 된다.
        					// 보통 파라미터가 적은 쪽에서 파라미터가 많은 쪽으로 호출해줌 
        
        //this.name = name;
        //this.kor = 0;
        //this.math = 0;
        //this.eng= 0;
    }
    
    public Student(String name, int kor, int math, int eng){
        this.name = name;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
    }
    
    ... getter setter만들어짐
    
    // getter - 외부에서 필드를 읽을 수 있도록 도와주는 메소드
    // setter - 외부에서 필드의 값을 수정하도록 도와주는 메소드
    // source - GenerateGetters and Setters
    
    
}
```

자기 자신의 생성자를 호출.
파라미터가 적은쪽의 생성자에서
많은 쪽의 생성자를 부르는 경우가 많다.





**접근 지정자**

```java
public class MathTest {
    
    public static void main(String[] args){
        //MyMath m = new MyMath(); // 이부분에세 에러가 된다. 생성자가 private이여서.
        System.out.println(MyMath.abs(-50)); // 50
    }
}
```

```java
public class MyMath {
    // 생성자가 private하면, 생성자는 있지만
    // 외부에서는 호출할 수가 없다.
    // 외부에서 생성자를 이용하여 인스턴스를 생성 못한다.
    private MyMath() { // private는 이 클래스 안에서만 생성할 수 있다.
        			
    }
    
    //혹은 생성자가 없어도 클래스를 사용할 수 있음
    public static int abs(int value) {
        if(value < 0)
            return value * -1;
        else 
            return value;
    }
}
```



생성자에 private이 붙으면 어떻게 되는가? 
java.lang.Math 는 인스턴스를 만들지 말고 사용하라는 것임 static



인스턴스를 만든다는 것은 메모리에 하나씩 인스턴스가 만들어진다.는 뜻입니다.
인스턴스를 만드다는 것은 인스턴스간에 구별을 하기 위해서임
인스턴스간의 구별은 속성으로 구별됨 -== 인스턴스 변수다

2명의 학생이 있다면.... 그 학생의 이름으로 구별함
2명의 학생이 있다는 그 자체.로 구별이 되는 것이다

이름이 같다라도해도 두명의 학생을 표현하고 싶을때는 인스턴스가 필요하다.
구별되는 사람이 10명이 있다. 그러면 인스턴스를 10개를 만들어준다.

접근지정자에 대한좀더 자세한내용은. package를 배우고 나서 좀더 자세히 설명을 드릴 것ㅇ ㅣㅂ니다.



오늘은 숙제.
싱글턴 패턴에 대하여 조사하고, 예제 코드를 작성하시오.





## 즐거운 자바 11편 - 접근제한자. static 싱글턴 패턴

class가 많아지면 ... 어떻게 관리하느냐?
class는 어떤 특정 폴더에 저장되어 있다.
한 폴더에 파일이 많이지면 관리가 어렵다.
관련된 파일들을 폴더별로 나눠서 관리를 한다.
자바에서도 class를 폴더별로 관리를 한다.
자바에서는 이 폴더 -> package라고 말을 한다.

자바 사용자는 다른 사람들이 만든 클래스를 이용할때가 많다.
한 폴더에는같은 이름의 클래스가 여러개 올수가 없다.

내가 만든 패키지와 상대방이 만든 패키지가 같고,
그안의 파일명도 같다면. 함께 사용할 수 없다.

그래서 클래스를 만드는 사람들은 고유의 패키지를 만들 필요가 있다.
보통패키지 이름은 도메인이름을 거꾸로 적는다.
sunnyvale.co.kr ---> package이름 --> kr.co.sunnvyale

도메인 이름을 거꾸로 적는다 + 프로젝트 이름 + 모듈이름
위의 형식이 많이 사용됩니다.

goclass <-- 프로젝트 이름
kr.co.sunnyvale.goclass
kr.co.sunnyvale.goclass.dao // 데이터 관련이 추가된다 하면 뒤에 dao를 붙인다. <-- 이렇게 package이름을 정했다는 것은 kr 폴더 - co 폴더 - sunnyvale폴더 - goclass폴더 - dao폴더 - 클래스파일들

JVM은 CLASSPATH에 잡혀있는 클래스들을 사용할 수 있다.
CLASSPATH는 kr 폴더가 있는 경로가 설정되어있어야 JVM에서 사용할 수 있다.

```java
package kr.co.sunnyvale.examples;
// MyBean은 kr.co.sunnyvale.examples 패키지에 속해있다.

public class MyBean {
    
}
```

```java
package kr.co.sunnyvale.test;
// package안에 클래스를 만든다면 반드시 첫번째 줄에 
// package 하고 해당클래스가 속해있는 패키지명이 나와야함
// console에서 컴파일할때는 package이 있는 소스는 컴파일할때 -d 옵션을 줘야 지마노딘다.
// javac -d 패키지가 생설될 경로 소스명
// javac -d c:/tmp 소스명.java  <-- temp/kr/co/sunnyvale/test/ 이런식으로 폴더가 생김
// 자동 import : ctrl + shift + 영어o
public class MyBeanTest {
    public static void main(String[] args)
}
```

package를 가지는 소스를 2개 만들었다.
kr.co.sunnyvale.examples : MyBean
kr.co.sunnvyale.test : MyBeanTest

15분 수업하고 질문 받기

이렇게 두가지 패키지에 각각의 클래스를 만들었어요. 패키지를 정해줬다는 것은 어떤 클래스가 어디에 위치하고 있다 이런 뜻이라고 보면되요. MyBeanTest



```java
package kr.co.sunnyvale.examples;
// MyBean은 kr.co.sunnyvale.examples 패키지에 속해있다.

public class MyBean {
    protected int protectedInt;
    public int publicInt;
    private int privateInt;
    int defaultInt;   
    
    
    // 자동으로 만들어지는 생성자는 기본생성자라고 불린다.
    public MyBean() {
        
    }
    
  //  MyBean() {
  //      // public을 빼게 되면 다른 패키지에서 MyBean bean = new MyBean()을 해주면 에러남
  //      // public가 없으면 다른 패키지에서는 MyBean클래스가 보이지 않음
  //  }
    //생성자에서는 
}
```

```java
package kr.co.sunnyvale.test;

public class MyBeanTest {
    
    public static void main(String[] args) {
        MyBean bean = new MyBean();
        bean.publicInt = 100;
    }
}
```

자바 접근제한자 4가지가 있다.

- public : 어디서든 접근 가능.
- protected : 같은 package, 다른 package지만 상속받은 자식에서 접근이 가능
  protected 를 가지고 있는 클래스를 상속받은 다른 패키지의 자식은 접근이 가능
- 아무것도 안붙어 있는 것 (default접근제한자) : 같은 package만 접근 할 수 있음
- private: 해당 클래스 안에서만 접근 할 수 있다.

4가지 접근제한자는 필드나 메소드 등에 붙을 수 있다. ( 4가지 꼭 암기 하기)



```java
package kr.co.sunnyvale.test;

import kr.co.sunnyvale.examples.MyBean;

public class MyBeanChild extends MyBean{
    public MyBeandChild() {
        super.protectedInt = 100; // 자기 자신이 protectedInt를 가지고 있지 않아서 
        					      // protextedInt = 100; 이라고 해도 오류나지 않음
        
        
        // 상속을 받는 다고 하더라도 생성자는 접근지정자가 없으면 생성이 안됨
        // 생성자는 보통 public 로 써줘야만 인스턴스를 만들 수 있음
    }
}
```

```java
package kr.co.sunnyvale.examples;

public class MyBeanTest2 {
    public static void main(String[] args) {
        MyBean bean = new MyBean();
        bean.defaultInt = 600;
        bean.protectedInt = 1000;  
    }
}
```



class가 생성자가 없으면 컴파일 시점에 자동으로 생성자가 만들어진다.
모든 클래스는 반드시 생성자가 있다.

java api에서 Math
Math는 private한 생성자를 가지고있어서 생성자가 api에서 보이지 않음 그래서 Math math = new Matn();를 못만듬





# 한손을 들어서 자기자신을 가리켜본다.

```java
class Human {
    private Human hand; // Human은 참조타입이다. // hand는 Human을 참조할 수 있다.
    					// 사람이 사람을 가리킬 수 있는 손이 있다라는 것이다
    
}	
```







```java
package kr.co.sunnyvale.examples;


public class CalBean {
    public int x;
    // 그때 나오는게 위의 3가지 규칙을 지켜서 만드는 클래스는 싱글턴패턴이 적용되었다.
    
    // 2) private 하지만 static한 필드를 선언 ( 자기 자신을 참조한다 == 자기 자신을 가리킨다)
    // 	  자기 자신의 생성자를 호출하여 초기화한다.
    //    static은 인스턴스가 만들어지기 전에 호출되는 코드. 딱 한번 초기화된다.
    private static CalBean instance = new CalBean();
    // 왼쪽만 보면 CalBean이라는 인스턴스를 가리킬 수 있는 레퍼런스 변수를 선언하겠다.
    // 오른쪽값만 보면 초기화값
    
    // 3) 2번에서 선언한 instance를 반환하는 public static메소드를 만든다.
    public static CalBean getInstance(){
        return instance;
    }
    
    // 1) private한 생성자를 만듬. 외부에서 인스턴스를 못만들게 하겠다.
    private CalBean(){
        
    }
    
    public int puls(int i, int m) {
        return i + m;
    }
}
```

```java
package kr.co.sunnyvale.test;

public class CalBeanTes {
    public static void main(String[] args){
       
        CalBean cal = new CalBean(); // 에러남
        CalBean bean = CalBean.getInstance();
        CalBean bean2 = CalBean.getInstance();
        
        // 참조가 같은가?
        if (beam == bean1) {
            
        }
        
        int value = bean.plus(5, 10);
        System.out.println(value);
        
        bean.x = 500;				// 500  메모리에 하나만 있어서 한쪽을 수정하면 bean2.x도 수정이 됨. 또한 동시에 이용하면 문제가될 수 있음
        System.out.println(bean2.x);  // 500
        SYstem.out.println();
        
    }
}
```

```java
public class MyBeanTest {
    public static void main(String[] args) {
        
        
        
        MyBean bean = new MyBean();
        MyBean bean2 = new MyBean();
        MyBean bean3 = new MyBean();
        MyBean bean4 = new MyBean();
        // 위의 4줄의 코드가 실행되면 인스턴스가 4개 만들어진다.
        // 인스턴스를 4개 만드는 이유는?
        // 각각의 인스턴스가 구별되어야 하기 때문.어떤 의미?
        // 사람에 대한 class가 있다. class는 인스턴스의 틀.
        // 여러분들과 저는 구별이 되나요? 
        // 굉장히 중요함 --> 존재자체로 구별이 된다.
        // 객체지향은 객체가 있다라는 것 자체가 구별이 되는 것임
        // 각각의 인스턴스를 왜 구별하느냐? 구별해서 사용해야하니깐
        // 그런데 나는 인스턴스가하나만 만들고 싶다!!!
        // 그때 나오는게 위의 3가지 규칙을 지켜서 만드는 클래스는 싱글턴패턴이 적용되었다.
        
    }
}
```



싱글턴패턴 
메모리에 하나만 인스턴스가 있다면 어떤 문제가 있을 수 있을까요?
**동시에! 동시라는 말이 나오면 Thread를 생각해야함**

오늘의 숙제
지금 설명한 CalBean 직접 작성하고
싱글턴패턴에 대하여 다시 조사해서 설명하기
(여러분들 나름대로 설명하기)

**이해한다는 것은 설명할 수 있다.**



여기까지 내용중에서 질문!!



스태틱한 메소드를 사용할 수 있따는 것은 스태틱한 필드도 초기화되어있다(private static CalBean instance = new CalBean(); 

## **프로그래머는 무엇인가 프로그램을 만들고나서 강해진다.**





# 즐거운 자바 12편 - 상속, 추상클래스, 템플릿메소드패턴

상속. 
is a 관계 
~는 ~다. 
~는 ~의 한 종류다.
(자식) 부모를 상속받은 후 자식은 확장한다.
버스, 스포츠카, 트럭은 자동차라고 부를 수 있다.(일반화)

## **상속 = 확장 + 일반화**

상속관계를 알아야만 클래스를 이해할 수 있음

아무것도 상속받지 않으면 자동으로 Object클래스를 상속받는다.
**버스가 무엇인지 이해하려면 자동차가 무엇인지 알아야 된다.**(어떤 클래스를 이해하려면 부모클래스를 이해해야한다.)



버스는 자동차다.
버스는 자동차의 한 종류다.
노트북은 컴퓨터다.
노트북은 컴퓨터의 한 종류다.

말이 안되게 상속받으면 안된다.
문법은 맞았지만 말인 안되면 상속받으면 안된다. (침대는 과학이다.)
말이 되게 상속을 받아야 한다.

```java
class 버스 extends 자동차 { // 버스는 자동차를 상속받는다.

}
```



```java
package kr.co.sunnyvale.examples;

public class Car {
    public void run() {
        System.out.printlnt("전륜구동-엔진");
    }
}
```

```java
package kr.co.sunnyvale.examples;

public class CarTest1 {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.run(); // 전륜구동
        
        Bus b1 = new Bus();
        b1.run(); // 부모가 가진 것을 그대로 물려받아서 사용한다.
        b1.bigppangppang(); // 확장한 메소드
    }
}

```

```java
package kr.co.sunnyvale.examples;

public class Bus extends Car {
    publicv void bigppangppang() {
        System.out.println("큰소리로 빵빵한다.");
    }    
}
```

- 공장. ----> 물건을 만드는 단계가 일정하다. -- 공장들은 대부분 이럴거야 하는 추상적인 공장
  ​		 init() // 초기화 과정
  ​		 make(); //만드는 과정
  ​		 clear(); // 청소하는 과정.

  단계는 같지만....  각 단계의 내부적인 그 내부적인 일처리는 달라질 수 있다.

------ 자동차공장, 오토바이 공장, 트럭공장. ----> 공정 3가지 단계는 동일함 -- 진짜 공장





````java
package kr.co.sunnyvale.examples; // 패키지 같은

// 추상클래스.
// 공장은 이런 기능을 가질꺼야.... 라고 생각만 한 것임
// 구체적으로 무엇을 구현한 것은 아님
public abstract class AbstractFactory {
    public abstract void init();
    public abstract void make();
    public abstract void clear();
}
````

```java
package kr.co.sunnyvale.examples;// 패키지 같은

public Class CarFactor extends AbstractFactory {
	
    @Override
    public void init() {
     	
    }
    
     @Override
    public void make() {
        
    }
    
     @Override
    public void clear() {
        
    }
    
    
}
```







```java
package kr.co.sunnyvale.examples; //패키지 다름

public abstract class AbstractFactory {
    protected abstract void init();  //protected는 같은 패키지나 상속받은 클래스에서 사용가능
    protected abstract void make();
    protected abstract void clear();
}
```

```java
package kr.co.sunnyvale.test; //패키지 다름

import kr.co.sunnyvale.examples.AbstractFactory;

public class CarFactory extends AbstractFactory {
        @Override
    protected void init() {
     	System.out.println("자동차 공정 초기화")
    }
    
     @Override
    protected void make() {
        System.out.println("자동차를 만듭니다.");
    }
    
     @Override
    protected void clear() {
        System.out.println("자동차 공장 청소");
    }
}



```

```java
package kr.co.sunnyvale.main // 패키지 다름

public class FactoryTest01 {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        factory.init(); // 오류남 오류이유는? 
        				// protected는 상속받거나 같은 package에서만 사용가능	
    }					// 오류안나게 하려면 추상클래스를 public으로 변경해주고 상속받은 CarFactoy의 상속받은 메소드도 자연스럽게 public로 변경됨 그렇게 해야만 에러가 나지 않음
}
```

```java
package kr.co.sunnyvale.test;

import kr.co.sunnyvale.examples.AbstractFactory;

public class BusFactory extends AbstractFactory {
        @Override
    protected void init() {
     	System.out.println("버스 공정 초기화")
    }
    
     @Override
    protected void make() {
        System.out.println("버스를 만듭니다.");
    }
    
     @Override
    protected void clear() {
        System.out.println("버스 공장 청소");
    }
}



```





- 자동차 공장은 공장입니다.
- 자동차 공장은 공장의 한 종류입니다.
- 카팩토리나 버스팩토리는 앱스트랙트팩토리의 자식이기 때문에 앱스트랙트팩토리타입으로 각각의 인스턴스를 참조할 수 있다.

```java
package kr.co.sunnyvale.main // 패키지 다름

import kr.co.sunnyvale.examples.AbstractFactory;
import kr.co.sunnyvale.test.CarFactory;

public class FactoryTest01 {
    public static void main(String[] args) {
        AbstractFactory factory = new CarFactory(); // 조상타입으로 후손 인스턴스를 참조함
        factory.init();                            // 앱스트랙트팩토리의 추상메소드가 public													// 이라고 가정함
}
```

```java
package kr.co.sunnyvale.main // 패키지 다름

import kr.co.sunnyvale.examples.AbstractFactory;
import kr.co.sunnyvale.test.BusFactory;

public class FactoryTest01 {
    public static void main(String[] args) {
        AbstractFactory factory = new BusFactory(); // 조상타입으로 후손 인스턴스를 참조함
        factory.init(); 
}
```





```java
package kr.co.sunnyvale.examples; //패키지 다름

public abstract class AbstractFactory {
    // 추상클래스는 구현되어 있는 메소드도 가질 수 있다.
    // final 메소드 - 오버라이딩을 금지.  자식이 오버라이딩 하는 것을 금지함
    public final void exec(){   // 자기 자신이 가지고 있는 메소드를 호출해줌 exec();  
        // 왜 이렇게 구현을 했을까요?
        // 책도 보면 서론, 본론, 결론
        // 각단계가 나뉘어져 있으면 코드 분석이 어떻게 될까요? 
        // 쉬워짐 직관
        init();
        make();
        clear();
    }
    
    // 추상메소드
    // 메소드가 오버라이딩 되어 있으면 자식의 메소드가 실행된다.
    protected abstract void init();  //protected는 같은 패키지나 상속받은 클래스에서 사용가능
    protected abstract void make();
    protected abstract void clear();
}
```

```java
package kr.co.sunnyvale.main // 패키지 다름

import kr.co.sunnyvale.examples.AbstractFactory;
import kr.co.sunnyvale.test.BusFactory;

public class FactoryTest01 {
    public static void main(String[] args) {
        AbstractFactory factory = new BusFactory(); // 조상타입으로 후손 인스턴스를 참조함
        // 부모타입
        
        factory.exec(); // 결과 
        				// 버스 공장 초기화
        				// 버스를 만들어요.
        				// 버스공장 청소
}
```





- 공장. ----> 물건을 만드는 단계가 일정하다. -- 공장들은 대부분 이럴거야 하는 추상적인 공장
  3가지 단계를 순서대로 호출해주는 메소드가 exec() 메소드다. 
  아래 메소드들을 순서대로 호출해주는 역할만하죠? -- **순서만 기억하죠 이런 것을 템플릿메소드다**
  **템플릿메소드는 순서를 정한다.**

  ​		 init() // 초기화 과정
  ​		 make(); //만드는 과정
  ​		 clear(); // 청소하는 과정.

  단계는 같지만....  각 단계의 내부적인 그 내부적인 일처리는 달라질 수 있다.

  ------ 자동차공장, 오토바이 공장, 트럭공장. ----> 공정 3가지 단계는 동일함 -- 진짜 공장
  ​	**자식클래스에서는 오버라이딩만해줌**

  공장 f = new 버스공장();
  f.exce(); // 버스공장에서 오버라이딩된 메서드가 호출됨

  공장 f = new 오토바이공장(); 
  f.exec(); // 오토바이공장에서 오버라이딩된 메서드가 호출됨



**왜? exec만 public이고 , 왜 다른 메소드는 protected로 만들었을까?** exec만 사용하려고

**~~공장을 만든다고 생각해보자 ( 공장을 만드는 사람의 입장으로 생각 )**
init();
make();
clear(); 를 만들어줘야한다.

**공장을 실행하는 사람은 어떤 메소드만 사용하면 되나요?**
exec()메소드만 사용하면 됨



접근제한자는 어떻게 쓰는지 알겠죠?
**접근제한자는 신호등을 만드는 것.**
지금 이 상황에서는 이 메소드를 쓰면 안되
지금 이상황에서는  이 메소드를 사용해야 되

**final를 왜 붙였죠? 오버라이딩 못하게 막기 위해서**
오버라이딩 방지하기 위해서
final을 붙이지 않았따면 exce()가 오버라이딩 되고
상속해서 오버라이딩을 구현하게 되면 무조건 자식의 메소드가 사용됨 
그럼 내가 의도한데로 작동하지 않음



템플릿메소드는 순서를 정해주는 것이다.



위에서 설명한 것은 템플릿메소드 패턴이라고 함.
**추상클래스는 보통 이러한 템플릿 메소드 패턴에서 많이 사용한다.**
부모에서 순서를 정해주고
나머지 메소드는 구현을 안해줬다. 자식에서 이것을 구현해주도록 하는 것이다.
이런 개념이다.

오늘의 숙제. 템플릿메소드패턴에 대하여 조사. 예제 만들어오기





```java
package kr.co.sunnyvale.examples;

public class Test01 {
    public static void main(String[] args){
        TestBean01 bean = new TestBean01();
        bean.exec();
    }
}

class TestBean01 {
    public void exec(){
        System.out.println("exec");
        
        System.out.println("1");
        System.out.println("2");  	// 개념적으로 나뉜다.
        System.out.println("3");
        
        System.out.println("a");
        System.out.println("b");	// 개념적으로 나뉜다.
        System.out.println("c");
        
        System.out.prinlnt("가");
       	System.out.println("ㄴ");	// 개념적으로 나뉜다.
        System.out.prinlnt("1");
    }
}
```



```java
class TestBean01 {
    public void exec(){
        System.out.println("exec");
       	init();
        service();
        destory();
    }
    
    private void destory(){
        System.out.println("1");
        System.out.println("2");  	// 개념적으로 나뉜다.
        System.out.println("3");
    }
    
    private void service(){
        System.out.println("a");
        System.out.println("b");	// 개념적으로 나뉜다.
        System.out.println("c");
    }
    
    private void init(){
        System.out.prinlnt("가");
       	System.out.println("ㄴ");	// 개념적으로 나뉜다.
        System.out.prinlnt("1");
    }
```

- private 메소드는 외부에서는 호출할 필요가 없다.

- private 메소드를 만드는 장점은? 

  - 정리가 잘되어서 나중에 유지보수가 쉬워진다.
  -   public void exec(){
      ​        System.out.println("exec");
      ​       	init();
      ​        service();
      ​        destory();
      ​    }

  - 메소드는 되도록이면 한화면에 보이는게 제일 좋다. 
  - 주석문 많이 다는 것 보다는 이런식으로 메소드가 잘 나눠저 있는게 좋은 거다.



**오늘 설명한 내용은 상속,  추상클래**스



- 추상클래스는 언제사용해요?

  - 말그대로 인스턴스가 되면 안된다
  - 인스턴스가 될수가 없다.
  - 개념적인 것만 있지 실제로 구현된 것이 없다. 몇가지 메소드가 개념적인 것만 있다.
  - 현실에 있으면 안되는 거예요. 구체적이 않자나요.
  - 구체적은 것은 뭐예요? 자동차공자장, 오토바이공장 이런것이  구체적인 것이라고 한다.
  - 개념적인 것만 있고 구체적이지 않다면 얘네들은 추상클래스이다.
  - 추상클래스는 뭐가 될수없다? 인스턴스가 될 수 없다.

- abstrackt메서드는 추사메소드라고 하고  자식에서 구현을 해줘야한다.

- final이 붙은 메소드는 자식이 오버라이딩 할 수없다.

- 메소드가 오버라이딩 되면 항상 자식의 메소드가 실행이됨

- 추상클래스는 언제 많이 사용된다? 추상클래스는 템플릿메소드패턴에서 사용이된다.

- 탬플릿메소드 패턴은 부모쪽에서 순서 정해준 것이 템플릿메소다.

- 각각의 단계에 대한 실질적인 구현은 자식에다가 맡기는 것이 탬플릿메소드 패턴이다.

- 사실 프로그램짤때 상속받는 일은 많지 않을수 있다. 초보자들은 상속을 많이 이용하려고 하지 마세요. 되도록이면.  초보자들은 상속을 사용하지 마세요. 상속을 사용하지 않고 프로그램을 짜는게 좋다. 

   

- 필드는 오버라이딩에서 신경쓰지 않아야한다. 필드는 클래스가 가지는 것이다. 

- 필드는 보통 private이기 때문에 상속받는 입장에서는  사용하는 입장에서는 필드는 모르고 신경쓰지 않아도됨



상속받을 때마다 필드는 새로정의 해주나요?

자동차를 상속받는 버스는  돈통이 있다.
버스는 돈통이 있따. 버스는 돈통을 가지는 것이다.
돈통은 기능이 아니라 필드(속성)이 되겠죠.
그럴떄는 돈통을 추가해주는 것이죠.