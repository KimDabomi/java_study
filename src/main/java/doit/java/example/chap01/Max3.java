
package doit.java.example.chap01;
import java.util.Scanner;

class Max3 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값: "); int a = stdIn.nextInt();
        System.out.println("b의 값: "); int b = stdIn.nextInt();
        System.out.println("c의 값: "); int c = stdIn.nextInt(); // 키보드로 입력한 값 중 정숫값을 읽어들임

        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("최댓값은 " + max + "입니다.");
    }
}
