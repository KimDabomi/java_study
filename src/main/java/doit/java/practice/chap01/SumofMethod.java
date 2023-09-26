package doit.java.practice.chap01;

class SumofMethod {
    static int sumof(int a, int b) {
        int sum = 0;
        if (a > b) {
            for (int i = b; i <= a; i++) {
                sum += i;
            }
        }
        else if (b > a) {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        }
        else {
            sum = a + b;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("a > b 인 경우. ex) " + sumof(5,2));
        System.out.println("a < b 인 경우. ex) " + sumof(1,2));
        System.out.println("a = b 인 경우. ex) " + sumof(4,4));
    }
}
