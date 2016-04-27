package com.vinplezhang.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * 
 * http://blog.csdn.net/luohuacanyue/article/details/8307617
 * 
 * 
 */
public class TestMultiThread2 implements Runnable {

	 private static Object o = new Object();  
     
	    private static Integer si = 0;  
	      
	    private static AtomicInteger flag = new AtomicInteger();  
	     
	    /*@Override  
	    public void run() {  
	        for(int k=0;k<2000000;k++){  
	            synchronized(si){  
	                si++;  
	            }  
	        }  
	        flag.incrementAndGet();  
	    }*/
	    
	    /*
	     * @Override
	 public void run() {    
    for(int k=0;k<2000000;k++){    
        synchronized(o){    
            si++;    
        }    
    }    
    flag.incrementAndGet();    
} 
	     */
	    
	    
	    
	    @Override 
	    public void run() {    
	        for(int k=0;k<2000000;k++){    
	            synchronized(o){    
	                si++;    
	                Object temp = o;    
	                o = new Object();    
	                o = temp;    
	            }    
	        }    
	        flag.incrementAndGet();    
	    }   
	    
	    /*
	     @Override
	     public void run() {    
	        for(int k=0;k<2000000;k++){    
	            synchronized(o){    
	                si++;    
	                Object temp = o;    
	                o = new Object();    
	                o = temp;    
	            }    
	        }    
	        flag.incrementAndGet();    
	    }*/
	    public static void main(String[] args) throws InterruptedException{  
	        TestMultiThread2 t1 = new TestMultiThread2();  
	        TestMultiThread2 t2 = new TestMultiThread2();  
	        ExecutorService exec1 = Executors.newCachedThreadPool();  
	        ExecutorService exec2 = Executors.newCachedThreadPool();  
	        exec1.execute(t1);  
	        exec2.execute(t2);  
	        while(true){  
	            if(flag.intValue()==2){  
	                System.out.println("si>>>>>"+si);      
	                break;  
	            }  
	            Thread.sleep(50);  
	        }  
	  
	          
	    }     
	      
	}  
