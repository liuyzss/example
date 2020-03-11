package com.bk.base.thread;

/**
 * User: liuyang
 * Date: 2020/3/10
 * Description:
 */
public class JoinDemo {
    public static void main(String[] args) {
        try {
            ThreadA t1 = new ThreadA("t1"); // 新建“线程t1”
            // 启动“线程t1”
            t1.start();
            // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            t1.join();
            // 等待t1 1000L 子线程未执行完，主线程继续执行；子线程提前结束，唤醒主线程
            //t1.join(1000L);
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.printf("%s start\n", this.getName());
            // 延时操作
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.printf("%s count:" + i + "\n", this.getName());
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("%s finish\n", this.getName());
        }
    }
}
