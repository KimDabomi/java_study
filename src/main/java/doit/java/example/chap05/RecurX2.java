package doit.java.example.chap05;

import java.util.Scanner;

class RecurX1 {
    // 재귀함수
    static void recurx1(int n) {
        while (n > 0) {
            recurx1(n - 1);
            System.out.println(n);
            n = n - 2;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("정수를 입력하세요.: ");
        int x = stdIn.nextInt();

        recurx1(x);
    }
}
