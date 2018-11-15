package LambdaTest;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lianxi {

	private static int getAge(String str,
			Function<String, String>one,
			Function<String, Integer>tow,
			Function<Integer, Integer>three) {
		Integer age = one.andThen(tow).andThen(three).apply(str);
		
		return age;
	}
	public static void main(String[] args) {
		String str = "赵丽颖,20";
		int age = getAge(str, 
				s->s.split(",")[1], 
				Integer::parseInt,
				n->n+100);
		System.out.println(age);
	}
}
