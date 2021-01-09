package com.didiglobal.android.standed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 作者:created by storm
 * 参考:https://blog.csdn.net/weixin_37598682/article/details/81285176
 * 1.CAS是一种乐观锁，它假定线程在操作读写数据的时候没有其他线程对该数据进行修改，因为是无锁实现，所以会造成读数据时脏数据的出现，
 * 更新数据因为有失败重试机制从而保证了多线程安全，乐观锁使用于频繁进行数据读操作，写操作较少的情况。CAS是依赖cpu指令实现的。
 * CAS(U,E,N)的实现思想是比较交换
 * U:内存地址中的值
 * E:期望的值
 * N:要更新设置的值
 * 首先比较内存地址中存储的值U是否与期望的值E相同，如果相同就更新内存地址中的值为N并返回当前的值N
 * 如果不相同就不要更改内存中的值，直接返回当前的值U。
 *
 * 第一个参数o为给定对象，offset为对象内存的偏移量，通过这个偏移量迅速定位字段并设置或获取该字段的值，
 * expected表示期望值，x表示要设置的值，下面3个方法都通过CAS原子指令执行操作。
 * public final native boolean compareAndSwapObject(Object o, long offset,Object expected, Object x);
 *
 * public final native boolean compareAndSwapInt(Object o, long offset,int expected,int x);
 *
 * public final native boolean compareAndSwapLong(Object o, long offset,long expected,long x);
 *
 * CAS存在的问题
 * CAS虽然很高效的解决原子操作，但是CAS仍然存在三大问题：
 *  ABA:一个线程取出变量的值是A,另一个线程首先修改了变量的值为B,然后又修改回变量的值为A,这时候变量的值没有发生变化，之前的线程就会更新成功，但是实际上数据是发生了变化
 * 1.  ABA问题。因为CAS需要在操作值的时候检查下值有没有发生变化，
 * 如果没有发生变化则更新，但是如果一个值原来是A，变成了B，又变成了A，
 * 那么使用CAS进行检查时会发现它的值没有发生变化，但是实际上却变化了。
 * ABA问题的解决思路就是使用版本号。在变量前面追加上版本号，每次变量更新的时候把版本号加一，那么A－B－A 就会变成1A-2B-3A。
 *从Java1.5开始JDK的atomic包里提供了一个类AtomicStampedReference来解决ABA问题。
 * 这个类的compareAndSet方法作用是首先检查当前引用是否等于预期引用，
 * 并且当前标志是否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设置为给定的更新值。
 *
 *2. 循环时间长开销大。自旋CAS如果长时间不成功，会给CPU带来非常大的执行开销。
 */

public class CasClass {

    public static void main(String[] args){
        AtomicInteger integer=new AtomicInteger();
        integer.set(10);
        boolean flag=integer.compareAndSet(10,10);
        System.out.println("flag="+flag);

        HashMap<String,String> srcMap=new HashMap<>();
        srcMap.put("a","1");
        srcMap.put("b","2");

        HashMap<String,String> modifyMap=srcMap;
        modifyMap.put("c","3");

        for (Map.Entry<String, String> e : srcMap.entrySet()) {
            String key=e.getKey();
            String value=e.getValue();
            System.out.println("key = " + key+" value= "+value);
        }
    }
}
