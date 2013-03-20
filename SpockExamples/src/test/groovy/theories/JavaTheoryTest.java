package theories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JavaTheoryTest {

	public static @DataPoints Integer[] integers = {-1, -2, -3, -4, -5, 1, 2, 3, 4, 5};
	public static @DataPoints String[] strings = {"a", "b", "c", "d", "e"}; //etc.

	/**
	 * All combinations of the data points will be applied to prove the theory.
	 */
	@Theory
	public void inTheoryAlphabeticStringsAreLexicographicallyGreaterThanNumericStrings(String alphabeticString, Integer integer) {
		assertThat(alphabeticString, greaterThan(integer.toString()));	
	}
 

}
