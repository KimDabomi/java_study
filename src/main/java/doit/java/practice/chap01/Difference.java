package doit.java.practice.chap01;

import java.util.Scanner;

class Difference {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("a의 값: ");
        int a = stdIn.nextInt();

        System.out.println("b의 값: ");
        int b = stdIn.nextInt();

        while (true) {
            System.out.print("b의 값 : ");
            b = stdIn.nextInt();
            if (b > a) break;
            System.out.println("a보다 큰 값을 입력하세요!");
        }


        int result = b - a;

        System.out.println("b - a는" + result + "입니다.");
    }
}
