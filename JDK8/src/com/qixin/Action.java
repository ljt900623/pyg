package com.qixin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;



public class Action {

	
	public static void main(String[] args) {
		
			
	
	System.out.println((int)Math.pow(2, 31));		
	method2(System.out::println,"hello");
	
		List<Apple> list = Arrays.asList(new Apple("green", 100), new Apple("abc", 150), new Apple("red", 200));
		System.out.println(list);
		list.sort((a1, a2) -> {return a1.getColor().compareTo(a2.getColor());});
		System.out.println(list);
        System.out.println("==========================");
        list.stream().forEach(System.out::print);
        
        Apple app=getApp(Apple::new);
        
        Function<String, Integer> toInteger = Integer::valueOf;
       System.out.println(toInteger.apply("123"));
        
		
     
        
	}
	
	 //predicate<T> 断言型接口:
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello","Lambda","Go","java");
        list = filterStr(list, s->s.contains("o"));
        list.forEach(System.out::println);
    }
  //需求:将满足条件的字符串添加到集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> stringList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str))
                stringList.add(str);
        }
		return stringList;
    }
        
    //Function<T,R>函数型接口
    @Test
    public void test3() {
        String str = strHandler("huangyichun", s -> s.toUpperCase());
        System.out.println(str);
    }
    //需求用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }  
      
	
	
	public static Apple getApp(Supplier<Apple> a) {
		Apple ap = a.get();
		return ap;		
	}


	public static <T> void  method2(Consumer<T> consumer, T t) {
		consumer.accept(t);			
	}

}
