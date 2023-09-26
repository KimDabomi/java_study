package doit.java.practice.chap01;

import java.util.Scanner;

public class PrintSquare {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;
        do {
            System.out.println("n값: ");
            n = stdIn.nextInt();
        } while (n <= 0);


        for (int i = 0; i < n ; i++) {
            System.out.println("*".repeat(n));
        }
    }
}
