package interactions;

import groovy.sql.Sql
import spock.lang.Specification;

class InteractionsTest extends Specification{

	Sql sql = Mock(Sql)

	def "single return value from a mock using '>>' symbol"(){
		when:
			def result = sql.rows("select * from TABLE")
		then:
			sql.rows(_) >> ["A mock result"]
		and: 
			result == ["A mock result"]
	}
	
	def "multiple return values using '>>>'"(){
		when:
			def resultA = sql.rows "a query"
			def resultB = sql.rows "a query"
			def resultC = sql.rows "a query"
		then:
			sql.rows("a query") >>> [["1"], ["2"]]
		and:
			resultA == ["1"]
			resultB == ["2"]
			resultC == ["2"]
	}
	
	def "verify the number of calls"(){
		when: 
			sql.rows "call 1"
			sql.rows "call 2"
			sql.rows "call 3"
		then:
			3 * sql.rows(_)
	}
	
	def "throwing and expecting an exception"(){
		when: 
			sql.rows "a query"
		then: 
			sql.rows("a query") >> { throw new RuntimeException() }
		and:
			thrown(RuntimeException)
	}
	
	
}
