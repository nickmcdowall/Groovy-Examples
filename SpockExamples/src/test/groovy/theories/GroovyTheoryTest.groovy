package theories;

import org.hamcrest.Matchers;

import spock.lang.Specification;

/**
 * No annotations required (combinations can be created to mimic data point combinations).
 * Can have multiple 'theories' per class since each spec (test) can define its own data.
 * Using ranges it is easy to create large data sets (e.g. a to z etc.).
 * 
 */
class GroovyTheoryTest extends Specification {
	
	def "In theory alphabetic characters (by extension strings) are lexicographically larger than numeric strings i.e. 'a' > '1' "() {
		expect:
			givenString > givenInteger.toString()
		where:
			[givenString, givenInteger] << [("a".."z"), (-5..5)].combinations()
	}
}