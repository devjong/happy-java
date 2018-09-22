## 즐거운 자바 04 -  new 연산자와 인스턴스, static 키워드와 Hello 실행순서

- int 초기값은 0
- boolean 초기값은 false
- 객체가 메모리에 올라간 것을 인스턴스라고 한다.
- 클래스는 하나지만, 해당 클래스 때문에 메모리가 부족하여 죽을 수 있다.
  - for문으로 객체생성



#### Hello class가 실행되기까지의 과정

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



오늘 배운 내용을 이해하기 위해서

Math class 와 Random class 를 사용하는 예제를 만들어서 카페에 올려서 자랑