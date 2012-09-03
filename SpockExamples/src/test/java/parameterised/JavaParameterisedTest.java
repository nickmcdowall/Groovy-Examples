package parameterised;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JavaParameterisedTest {

	
	private String givenString;
	private int expectedLength;

	public JavaParameterisedTest(String givenString, int expectedLength){
		this.givenString = givenString;
		this.expectedLength = expectedLength;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return asList(new Object[][]{
				{"Predators", 9},
				{"Terminators", 11},
				{" ", 1},
		});
	}
	
	@Test
	public void test() {
		assertThat(givenString.length(), is(expectedLength));
	}

}
