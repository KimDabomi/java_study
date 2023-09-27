package doit.java.example.chap03;

class Id {
    // 아이디를 몇개 부여했는지 저장
    private static int counter = 0;
    private int id;

    // 생성자
    public Id() { id = ++counter; }

    // counter를 반환하는 클래스 메서드
    public static int getCounter() { return counter; }

    // 아이디를 반환하는 인스턴스 메서드
    public int getId() { return id; }
}

public class IdTester {
    public static void main(String[] args) {
        Id a = new Id();
        Id b = new Id();

        System.out.println("a의 아이디: " + a.getId());
        System.out.println("b의 아이디: " + b.getId()); // 클래스형 변수 이름.메서드이름()
        System.out.println("부여한 아이디의 개수: " + Id.getCounter()); // 클래스 이름.메서드이름()
    }
}

