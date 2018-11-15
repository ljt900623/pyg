package com.qixin;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class Lianxi1 {

	/*
	 * 使用java.io.File类的listFiles(FileFilter)和isDirectory方法，
	 * 编写一个返回指定目录下所有子目录的方法。使用lambda表达式来代替FileFilter对象，
	 * 再将它改写为一个方法的引用 
	 */
	
	public static void main(String[] args) {		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}
		
		long t0 = System.nanoTime();		
		//list.parallelStream().forEach((i) ->System.out.println(i));
		list.stream().forEach((i) ->System.out.println(i));
		long t1 = System.nanoTime();
		System.out.println("to: "+t0);
		System.out.println("t1: "+t1);
		long millis  = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println("共有"+Runtime.getRuntime().availableProcessors()+"个CPU");
		System.out.println(String.format("sequential sort took: %d ms", millis));  
		
		
		
		
		
		
		
		
		
		
		
		/*File file = new File("d:\\WorkSpace");		*/
		
		/*
		 * 匿名内部类写法		
		 File[] files=file.listFiles(new FileFilter() {
		
		 @Override
		 public boolean accept(File pathname) {
		 return pathname.isDirectory();
		 }
		 });
		 for(File f : files){
		 System.out.println(f.getAbsolutePath());
		 }*/
		
		/*
		 * lambda写法
		 */
		
		/*File[] fl = file.listFiles((File f) -> {
			return f.isDirectory();
		});
		for (File f : fl) {
			System.out.println(f.getAbsolutePath());
		}*/

	}

}
