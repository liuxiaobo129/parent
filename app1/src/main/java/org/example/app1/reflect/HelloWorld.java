package org.example.app1.reflect;


import org.example.reflect.InterfaceScanner;

public class HelloWorld {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> interfaceClass = Class.forName("org.example.app1.reflect.MyInterface");
        InterfaceScanner.scanForImplementations(interfaceClass);
    }
}


interface MyInterface {

}

class MyInterfaceImpl implements MyInterface{

}