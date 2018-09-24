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
  - import java.langm.Math; // <----  삽입할 필요가 없다.
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





숙제 

Scanner를 이용한 값의 입력 - 조사하여 사용하자.
재미삼아 만드는 프로그램

이름과 태여난 생년월일을 입력 받아 인디언식 이름을 다음과 같이 출력하시오.



이름입력하세요.
홍길동

생년을 입려갛세요
1990

생월을 입력하세요
1

생일을 입력하세요
29

1990년 1월 29일에 태어난 홍길동님의 인디억 식 이름은 시끄러운 늑대의 심판자입니다.

```java
<태어난 뒷자리 년도>
xxx0 년생 : 시끄러운 or 말많은
xxx1 년생 : 푸른
xxx2 년생 : 어두운 -> 적색
xxx3 년생 : 조용한
xxx4 년생 : 웅크린
xxx5 년생 : 백색
xxx6 년생 : 지혜로운
xxx7 년생 : 용감한
xxx8 년생 : 날카로운
```





