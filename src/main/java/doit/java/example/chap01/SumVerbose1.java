package doit.java.example.chap01;

import java.util.Scanner;

class SumVerbose1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("1부터 n까지의 합을 구합니다.");

        do {
            System.out.println("n값: ");
            n = stdIn.nextInt();
        } while (n <= 0);

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i < n)
                System.out.println(i + " + ");
            else
                System.out.println(i + " = ");
            sum += i;
        }

        System.out.println(sum);
    }
}