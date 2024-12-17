package org.example.app1.thread;

import java.time.temporal.Temporal;
import javax.swing.*;
public class ThreadLocalMaptest {


    private static ThreadLocal<String> instance = new ThreadLocal();



    public static void main(String[] args) {


        instance.set("1");

        instance.get();

        instance.remove();




        new Thread(){
            public void run() {
                instance.set("2");

                instance.get();

                instance.remove();
            }
        }.start();

    }



}
