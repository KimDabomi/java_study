package doit.java.practice.chap02;

import java.util.Scanner;

class CopyArray {
    static void copy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++)
            a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 요솟수는  : ");
        int numA = stdIn.nextInt();		// 요솟수
        int[] a = new int[numA];			// 요솟수가 numa인 배열
        for (int i = 0; i < numA; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("b의 요솟수는  : ");
        int numB = stdIn.nextInt();
        int[] b = new int[numB];
        for (int i = 0; i < numB; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        copy(a, b);

        System.out.println("배열 b의 모든 요소를 배열 a에 copy 하였습니다.");
        for (int i = 0; i < numA; i++)
            System.out.println("a[" + i + "] = " + a[i]);
    }
}
