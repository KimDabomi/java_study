package doit.java.practice.chap04;

public class IntDeque {
    private int[] que;
    private int capacity;
    private int num;
    private int front;
    private int rear;

    // 실행 시 예외: 큐가 비어 있음
    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() {}
    }

    // 실행 시 예외: 큐가 가득 참
    public class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() {}
    }

    // 생성자
    public IntDeque(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 덱의 맨앞에 데이터를 인큐
    public int enqueFront(int x) throws OverflowIntDequeException {
        if (num >= capacity)
            throw new OverflowIntDequeException();
        num++;
        if (--front < 0)
            front = capacity - 1;
        que[front] = x;
        return x;
    }

    // 덱의 맨끝에 데이터를 인큐
    public int enqueRear(int x) throws OverflowIntDequeException {
        if (num >= capacity)
            throw new OverflowIntDequeException();
        que[rear++] = x;
        num++;
        if (rear == capacity)
            rear = 0;
        return x;
    }

    // 덱의 맨앞 데이터를 디큐
    public int dequeFront() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        int x = que[front++];
        num--;
        if (front == capacity)
            front = 0;
        return x;
    }

    // 덱의 맨끝 데이터를 디큐
    public int dequeRear() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        num--;
        if (--rear < 0)
            rear = capacity - 1;
        return que[rear];
    }

    // 덱의 맨앞 데이터를 피크
    public int peekFront() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        return que[front];
    }

    // 덱의 맨끝에서 데이터를 피크
    public int peekRear() throws EmptyIntDequeException {
        if (num <= 0)
            throw new EmptyIntDequeException();
        return que[rear == 0 ? capacity - 1 : rear - 1];
    }

    // 덱에서 x를 검색하여 인덱스를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    // 덱에서 x를 검색하여 맨앞에서 몇번째인가를 반환(발견하지 못하면 0)
    public int search(int x) {
        for (int i = 0; i < num; i++)
            if (que[(i + front) % capacity] == x)
                return i + 1;
        return 0;
    }

    // 덱을 비움
    public void clear() {
        num = front = rear = 0;
    }

    // 덱의 용량을 반환
    public int getCapacity() {
        return capacity;
    }

    // 덱에 쌓여있는 데이터 수를 반환
    public int size() {
        return num;
    }

    // 덱이 비어있나?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 덱이 가득찼나?
    public boolean isFull() {
        return num >= capacity;
    }

    // 덱 안의 모든 데이터를 맨앞 -> 맨끝의 순서로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("덱이 비어있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.println(que[(i + front) % capacity] + " ");
            System.out.println();
        }
    }
}
