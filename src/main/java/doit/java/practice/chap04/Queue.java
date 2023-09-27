package doit.java.practice.chap04;

public class Queue<E> {
    private E[] que;
    private int capacity;
    private int num;
    private int front;
    private int rear;


    // 실행 시 예외: 큐가 비어있음
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException () {}
    }


    // 실행 시 예외: 큐가 가득 참
    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {}
    }

    public Queue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = (E[])new Object[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 큐에 x를 인큐
    public E enque(E x) throws Queue.OverflowQueueException {
        if (num >= capacity)
            throw new Queue.OverflowQueueException();
        return que[num++] = x;
    }

    // 큐에서 데이터를 디큐
    public E deque() throws Queue.EmptyQueueException {
        if (num <= 0)
            throw new Queue.EmptyQueueException();
        return que[--num];
    }

    // 큐에서 데이터를 피크(프론트에 있는 데이터를 들여다봄)
    public E peek() throws Queue.EmptyQueueException {
        if (num <= 0)
            throw new Queue.EmptyQueueException();
        return que[num - 1];
    }

    // 큐를 비움
    public void clear() {
        num = 0;
    }


    // 큐에서 x를 찾아 인덱스(없으면 -1)을 반환
    public int indexOf(E x) {
        for (int i = num - 1; i >= 0; i--)     // 꼭대기 쪽부터 선형 검색
            if (que[i].equals(x))
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


    // 큐 안의 모든 데이터를 프론트 -> 리어 순서로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.println(que[i] + " ");
            System.out.println();
        }
    }


    // 큐에서 x를 검색하여 맨앞에서 몇 번째인가(발견하지 못하면 0)를 반환
    public int search(E x) {
        for (int i = 0; i < num; i++)
            if (que[(i + front) % capacity].equals(x))	// 검색 성공
                return i + 1;
        return -1;									// 검색 실패
    }
}
