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

}

