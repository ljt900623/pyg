package com.qixin;

import java.util.function.Function;

public class LambdaTest {

	public static void main(String[] args) {
		Function<Integer, String[]> fun = x->new String[x];
		String[] str = fun.apply(10);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
}
