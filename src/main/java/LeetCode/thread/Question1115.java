package LeetCode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/8/2 14:39
 */
public class Question1115 {
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(10);
        new Thread(()->{
            try {
                fooBar.foo(new RunnableFoo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(()->{
            try {
                fooBar.bar(new RunnableBar());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();


    }
}

class FooBar {
    private int n;
    Lock lock = new ReentrantLock(true);
    private final Condition foo = lock.newCondition();
    volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }



    public void foo(RunnableFoo printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while(!flag) {
                    foo.await();
                }
                printFoo.run();
                flag = false;
                foo.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public void bar(RunnableBar printBar) throws InterruptedException {

        for (int i = 0; i < n;i++) {
            lock.lock();
            try {
                while(flag) {
                    foo.await();
                }
                printBar.run();
                flag = true;
                foo.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}

class RunnableFoo implements Runnable {
    @Override
    public void run() {
       // System.out.println("当前线程：" + Thread.currentThread().getId());
        System.out.print("foo");
    }
}

class RunnableBar implements Runnable{

    @Override
    public void run() {
        //System.out.println("当前线程：" + Thread.currentThread().getId());
        System.out.print("bar");
    }
}
