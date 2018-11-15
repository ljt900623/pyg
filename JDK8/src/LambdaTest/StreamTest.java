package LambdaTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		int [] array = {10,20,30,40,50,60};
		List<int[]> list = Stream.of(array).collect(Collectors.toList());
		
	}
}
