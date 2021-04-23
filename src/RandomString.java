import java.nio.charset.Charset;
import java.util.Random;

public class RandomString {

	public String rand(int charAmount) {
		byte[] array = new byte[charAmount];
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    return generatedString;
	}
}
