package LambdaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
	
	private static void method(Predicate<String>pre) {
		boolean b = pre.test("HolloWord");
		System.out.println("字符串很长吗"+(b==true?"是的":"不是"));
	}
	private static void method(Predicate<String>one,Predicate<String>tow) {
		boolean b = one.and(tow).test("HolloWorld");
		System.out.println("字符串符合要求吗"+(b==true?"是的":"不是"));
	}
	private static ArrayList<Object> shaixuan(Predicate<String>one,Predicate<String>tow,String[]arr) {
		ArrayList<Object> list = new ArrayList<>();
		for (String st : arr) {
			if (one.and(tow).test(st)) {
				list.add(st);
			}
		}
		return list;
		
	}
	
	
	private static String getString(Supplier<String> fun) {
		
		return fun.get();
	}
	private static void getMax(Supplier<Integer> fun) {
		
		int max = fun.get();
		System.out.println(max);
	}
	
	private static void consummeString(Consumer<String> fun) {
		fun.accept("Hello");		
	}
	private static void consummeString(Consumer<String>one,Consumer<String>tow) {
		one.andThen(tow).accept("hello");	
	}
	private static void consummetest(Consumer<String>one,Consumer<String>tow,
			String [] arr) {
		for (String st : arr) {
			one.andThen(tow).accept(st);
		}		
	}
	
	private static void log(int level,Message ms) {
		if (level==1) {
			System.out.println(ms.buildMessage());
		}
	}
	public static void main(String[] args) {
		String msga="HELLO";
		String msgb="WORD";
		String msgc="WORD";
		String string = getString(()->msga+msgb);
		System.out.println(string);
	
		int [] arr= {10,20,100,30,40,50};
		getMax(()->{
			int max = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]>max) {
					max=arr[i];
				}
			}
			return max;			
		});
	
		consummeString(System.out::println);
		consummeString(				
				s->System.out.println(s.toUpperCase()),
				s->System.out.println(s.toLowerCase())				
				);
		String [] array = {"迪丽热巴,女","古力娜扎,女","马儿扎哈,男"};
		
		consummetest(s->System.out.println("姓名:"+s.split(",")[0]), 
				s->System.out.println("性别:"+s.split(",")[1]), 
				array);
		method(s->s.length()>5);
		method(s->s.contains("H"), s->s.contains("W"));
		
		String [] array2 = {"迪丽热巴,女","古力娜扎,女","马儿扎哈,男","赵丽颖,女"};
		 ArrayList<Object> list = shaixuan(s->"女".equals(s.split(",")[1]), 
				 t->t.split(",")[0].length()==4, 
				 array2);
		 System.out.println(list);
		
	}
	
}
