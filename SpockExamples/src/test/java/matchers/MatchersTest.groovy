package matchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import spock.lang.Specification;


class MatchersTest extends Specification {

	def """Hamcrest matchers can be used.  Note that you don't need to use 'assertThat'"""() {
		given: 
			String input = "hello"
		expect: 
			assertThat(input, equalTo("hello"))
		and: 
			assertThat input, equalTo("hello")
		and:
			input equalTo("hello")
	}

}
