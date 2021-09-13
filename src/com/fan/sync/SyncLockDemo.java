package com.fan.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/*
 * @author  fan
 * @date  2021/9/13 8:58
 * @aa  玉树临风美少年,揽镜自顾夜不眠
 */

//可重入锁
public class SyncLockDemo {

    public synchronized void add() {
        add();
    }

    public static void main(String[] args) {
        //Lock演示可重入锁
        Lock lock = new ReentrantLock();
        //创建线程
        new Thread(()->{
            try {
                //上锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" 外层");

                try {
                    //上锁
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+" 内层");
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }finally {
                //释放做
                lock.unlock();
            }
        },"t1").start();

        //创建新线程
        new Thread(()->{
            lock.lock();
            System.out.println("aaaa");
            lock.unlock();
        },"aa").start();

        // new SyncLockDemo().add();
        // synchronized
//        Object o = new Object();
//        new Thread(()->{
//            synchronized(o) {
//                System.out.println(Thread.currentThread().getName()+" 外层");
//
//                synchronized (o) {
//                    System.out.println(Thread.currentThread().getName()+" 中层");
//
//                    synchronized (o) {
//                        System.out.println(Thread.currentThread().getName()+" 内层");
//                    }
//                }
//            }
//
//        },"t1").start();
    }

}
