package doit.java.practice.chap04;

import doit.java.practice.chap04.IntArrayQueue;

import java.util.Scanner;

class IntArrayQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntArrayQueue s = new IntArrayQueue(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (5) 삭제 (6) 검색 (7) 용량 (8) 크기 (9) 비어있나? (10) 가득찼나? : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.println("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntArrayQueue.OverflowIntArrayQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntArrayQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntArrayQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("검색할 데이터 : ");
                    x = stdIn.nextInt();
                    int n = s.indexOf(x);
                    if (n >= 0)
                        System.out.println("맨뒤에서 " + (s.size() - n) +"번째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;

                case 7:
                    System.out.println("용량 : " + s.getCapacity());
                    break;

                case 8:
                    System.out.println("크기 : " + s.size());
                    break;

                case 9:
                    System.out.println("비어" + (!(s.isEmpty()) ? "있지 않습니다." : "있습니다."));
                    break;

                case 10:
                    System.out.println("가득 차" + (!(s.isFull()) ? "있지 않습니다." : "있습니다."));
                    break;
            }
        }
    }
}
