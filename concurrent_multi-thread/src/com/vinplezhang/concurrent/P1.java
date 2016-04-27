package com.vinplezhang.concurrent;
/*
 * 
 * 
 * 调用 set1()、set2()、check()，会打印出 Error 么？
 * 
 * 
 * http://88250.b3log.org/java-atomic-conncurrent
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class P1 {
	
	private long b = 0;
	 
    public void set1() {
        b = 0;
    }
 
    public void set2() {
        b = -1;
    }
 
    public void check() {
        System.out.println(b);
 
        if (0 != b && -1 != b) {
            System.err.println("Error");
        }
    }

}
