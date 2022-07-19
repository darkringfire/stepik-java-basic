import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
	private final byte[] chars;

	public static void main(String[] args) {
		AsciiCharSequence a = new AsciiCharSequence(new byte[] { 40, 41, 42, 43 });
		System.out.println(a);
		System.out.println(a.length());
		System.out.println(a.charAt(1));
		System.out.println(a.subSequence(1, 3));
	}

	public AsciiCharSequence(byte[] chars) {
		this.chars = chars;
	}

	@Override
	public int length() {
		return chars.length;
	}

	@Override
	public char charAt(int index) {
		return (char) chars[index];
	}

	@Override
	public AsciiCharSequence subSequence(int start, int end) {
		return new AsciiCharSequence(Arrays.copyOfRange(chars, start, end));
	}

	@Override
	public String toString() {
		return new String(chars);
	}

}
