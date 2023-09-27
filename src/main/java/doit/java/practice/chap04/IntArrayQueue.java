package doit.java.practice.chap04;

public class IntArrayQueue {
    private int[] que;
    private int capacity;
    private int num;

    // 실행 시 예외: 큐가 비어있음
    public static class EmptyIntArrayQueueException extends RuntimeException {
        public EmptyIntArrayQueueException () {}
    }


    // 실행 시 예외: 큐가 가득 참
    public static class OverflowIntArrayQueueException extends RuntimeException {
        public OverflowIntArrayQueueException() {}
    }


    // 생성자
    public IntArrayQueue(int maxlen) {
        num = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 큐에 x를 인큐
    public int enque(int x) throws IntArrayQueue.OverflowIntArrayQueueException {
        if (num >= capacity)
            throw new IntArrayQueue.OverflowIntArrayQueueException();
        return que[num++] = x;
    }


    // 큐에서 데이터를 디큐
    public int deque() throws IntArrayQueue.EmptyIntArrayQueueException {
        if (num <= 0)
            throw new IntArrayQueue.EmptyIntArrayQueueException();
        int x = que[0];
        for (int i = 0; i < num - 1; i++)
            que[i] = que[i+1];
        num--;
        return x;
    }

    // 큐에서 데이터를 피크(맨앞 데이터를 들여다봄)
    public int peek() throws IntArrayQueue.EmptyIntArrayQueueException {
        if (num <= 0)
            throw new IntArrayQueue.EmptyIntArrayQueueException();
        return que[num - 1];
    }

    // 큐를 비움
    public void clear() {
        num = 0;
    }


    // 큐에서 x를 찾아 인덱스(없으면 -1)을 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
            if (que[i] == x)
                return i;         // 검색 성공
        return -1;                // 검색 실패
    }

    // 큐의 용량을 반환
    public int getCapacity() {
        return capacity;
    }


    // 큐에 쌓여 있는 데이터 개수를 반환
    public int size() {
        return num;
    }


    // 큐가 비어 있는가?
    public boolean isEmpty() {
        return num <= 0;
    }


    // 큐가 가득 찼는가?
    public boolean isFull() {
        return num >= capacity;
    }


    // 큐 안의 모든 데이터를 맨앞 -> 맨끝 순서로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.println(que[i] + " ");
            System.out.println();
        }
    }
}
