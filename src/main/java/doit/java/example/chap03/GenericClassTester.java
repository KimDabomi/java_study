package doit.java.example.chap03;

class GenericClassTester {
    // 제네릭 클래스의 매개변수를 T라고 작성함
    static class GenericClass<T> {
        private T xyz;

        // 생성자
        GenericClass(T t) {
            this.xyz = t;
        }

        // Getter
        T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args) {
        // 매개변수에 String을 넘길 수도 있고, Integer를 넘길 수도 있슴
        GenericClass<String> s = new GenericClass<>("ABC");
        GenericClass<Integer> n = new GenericClass<>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
