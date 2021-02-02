package com.didiglobal.android.standed;

/**
 * 作者:created by storm
 * 1.外部类可以访问静态内部类的成员属性和方法(包括私有的)，静态内部类因为持有外部类的Class，所以能够访问外部类的静态成员属性和方法
 * 2.外部类可以访问非静态内部类的成员属性和方法(包括私有的)，非静态内部类因为持有外部类的类实例this对象，所以能够访问外部类的所有成员属性和方法(包括私有的)
 * 3.私有的属性和方法为什么可以访问？内部类(为了访问控制的目的)被视为包含类的一部分
 * 4.要想直接创建内部类的对象,必须使用外部类的对象来创建内部类对象 :OuterClass.InnerClass innerClass =new OuterClass().new InnerClass();
 * 可以参考:https://www.jianshu.com/p/5aea8f080952
 */

public class OuterClass {

    private int a;

    float b;

    static String c;


    private void testMethod(){
        InnerClass innerClass=new InnerClass();
        innerClass.d=1;
        innerClass.f=10.0f;

        InnerStaticClass innerStaticClass=new InnerStaticClass();
        innerStaticClass.g=1;
        innerStaticClass.h="hi";
        innerStaticClass.testMethod3();
        InnerStaticClass.testMethod4();
        InnerStaticClass.m="hh";
        innerStaticClass.testMethod4();
        innerStaticClass.m="hh";

        final float m = 1.0f;
        new Thread(new Runnable() {
            @Override
            public void run() {
                c="q";
            }
        });
    }

    private static void testMethod2(){

    }

     class InnerClass{

        private int d;

        float f;
        //Inner classes cannot have static declarations
//        static String e="hello";

        private void testMethod3(){
          a=1;
          b=2;
          testMethod();
          testMethod2();
        }

    }

    static class InnerStaticClass{

        private int g;

       public String h;
       public static String m="hello";

        private void testMethod3(){
          c="hello";
          testMethod2();
        }

        private static void testMethod4(){
            c="hello";
            testMethod2();
        }

    }
}
