package doit.java.practice.chap01;

import java.util.Scanner;

class Gauss {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.println("n값: ");
        int n = stdIn.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++)
            if (n % 2 == 0)
                sum = (1 + n) * (n / 2);
            else
                sum = (1 + n) * (n / 2) + (n / 2 + 1);

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}
