package com.fan;

/*
 * @author  fan
 * @date  2021/9/13 8:40
 * @aa  玉树临风美少年,揽镜自顾夜不眠
 */
public class Main {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        //设置守护线程
        aa.setDaemon(true);
        aa.start();

        System.out.println(Thread.currentThread().getName()+" over");
    }
}
