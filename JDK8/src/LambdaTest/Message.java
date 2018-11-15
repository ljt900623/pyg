package LambdaTest;

@FunctionalInterface
public interface Message {
	String buildMessage(String...msg);
}
