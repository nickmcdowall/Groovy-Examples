package parameterised;

import spock.lang.*

/**
 * No need for annotations
 * No need for static method to supply the data
 * No need for a constructor to store the data
 * Multiple parameterised tests within one class
 *
 */
class GroovyParameterisedTest extends Specification {
	
	
	def "should calculate the size of a given String based on the number of characters"() {
		expect:
		    givenString.size() == expectedSize
		where:
		    givenString     | expectedSize
		    "Predators"     | 9
		    "Terminators"   | 11
		    " "             | 1
	}
	
	
	def "should be able to determine whether the string is a number"() {
		expect:
			givenString.isNumber() == aNumber
		where:
		    givenString   | aNumber
		    "15"          | true
		    "a1"          | false
		    "1a"          | false
		    "aa"          | false
		    ""            | false
	}
}