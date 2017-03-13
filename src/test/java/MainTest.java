import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author kamontat
 * @version 1.0
 * @since Mon 13/Mar/2017 - 7:12 PM
 */
class MainTest {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@BeforeAll
	public static void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@Test
	public void test() {
		Main.main(new String[]{"something"});
		
		Assertions.assertEquals("Hello world!\n", outContent.toString());
	}
	
	@AfterAll
	public static void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}
}