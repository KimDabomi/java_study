package doit.java.practice.chap04;
import java.util.Scanner;

class StackPrac {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Stack<String> s = new Stack<String>(64);

        while (true) {
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 삭제 (6) 검색 (7) 용량 (8) 크기 (9) 비어있나? (10) 가득찼나? : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.next();
                    try {
                        s.push(x);
                    } catch (Stack.OverflowStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (Stack.EmptyStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (Stack.EmptyStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("검색할 데이터 : ");
                    x = stdIn.next();
                    int n = s.indexOf(x);
                    if (n >= 0)
                        System.out.println("꼭대기에서 " + (s.size() - n) +"번째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;

                case 7:
                    System.out.println("용량 : " + s.getCapacity());
                    break;

                case 8:
                    System.out.println("크기 : " + s.size());
                    break;

                case 9:
                    System.out.println("비어" + (!(s.isEmpty()) ? "있지 않습니다." : "있습니다."));
                    break;

                case 10:
                    System.out.println("가득 차" + (!(s.isFull()) ? "있지 않습니다." : "있습니다."));
                    break;
            }
        }
    }
}
