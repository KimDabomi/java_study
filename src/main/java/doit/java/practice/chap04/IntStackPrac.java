package doit.java.practice.chap04;

public class IntStackPrac {
    private int[] stk;
    private int capacity;
    private int ptr;

    // 실행 시 예외: 스택이 비어있음
    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException () {}
    }


    // 실행 시 예외: 스택이 가득 참
    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }


    // 생성자
    public IntStackPrac(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 스택에 x를 푸시
    public int push(int x) throws IntStackPrac.OverflowIntStackException {
        if (ptr >= capacity)
            throw new IntStackPrac.OverflowIntStackException();
        return stk[ptr++] = x;
    }


    // 스택에서 데이터를 팝(꼭대기에 있는 데이터를 꺼냄)
    public int pop() throws IntStackPrac.EmptyIntStackException {
        if (ptr <= 0)
            throw new IntStackPrac.EmptyIntStackException();
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크(꼭대기에 있는 데이터를 들여다봄)
    public int peek() throws IntStackPrac.EmptyIntStackException {
        if (ptr <= 0)
            throw new IntStackPrac.EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 스택을 비움
    public void clear() {
        ptr = 0;
    }


    // 스택에서 x를 찾아 인덱스(없으면 -1)을 반환
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--)     // 꼭대기 쪽부터 선형 검색
            if (stk[i] == x)
                return i;         // 검색 성공
        return -1;                // 검색 실패
    }

    // 스택의 용량을 반환
    public int getCapacity() {
        return capacity;
    }


    // 스택에 쌓여 있는 데이터 개수를 반환
    public int size() {
        return ptr;
    }


    // 스택이 비어 있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }


    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= capacity;
    }


    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.println(stk[i] + " ");
            System.out.println();
        }
    }
}
