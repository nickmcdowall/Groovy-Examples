import spock.lang.*

class GroovyStringTest extends Specification {

	String myString


	def "should reverse the characters correctly on a string"() {
		given:
		    myString = "nick"
		when:
		    def reverseName = myString.reverse()
		then:
		    reverseName == "kcin"
	}

	def "should convert all characters to Uppercase"(){
		given:
		    myString = "abc"
		expect:
		    myString.toUpperCase() == "ABC"
	}

	def "should calculate the string size based on the number of characters"() {
		expect:
		    input.size() == length
		where:
		    input           | length
		    "Predators"     | 9
		    "Terminators"   | 11
		    " "             | 1
	}

	def "should be able to determine whether the string is a number"(){
		expect:
		    input.isNumber() == aNumber
		where:
		    input   | aNumber
		    "15"    | true
		    "a1"    | false
		    "1a"    | false
		    "aa"    | false
		    ""      | false
	}
}

