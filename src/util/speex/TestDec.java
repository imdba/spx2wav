package util.speex;

public class TestDec {
	public static void main(String[] args) {
		SpeexUtils.decode(args[0], args[1]);
		System.out.println("complete");
	}
}
