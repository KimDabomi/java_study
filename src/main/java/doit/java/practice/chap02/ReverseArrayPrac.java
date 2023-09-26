package doit.java.practice.chap02;

import java.util.Arrays;
import java.util.Scanner;

class ReverseArrayPrac {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            System.out.println(Arrays.toString(a));
            swap(a, i, a.length - i - 1);
            System.out.println("a[" + i + "]과 a[" + (a.length - i - 1) + "]을 교환합니다.");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요솟수: ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        reverse(x);
        System.out.println(Arrays.toString(x));
        System.out.println("역순 정렬을 마쳤습니다.");
    }
}
