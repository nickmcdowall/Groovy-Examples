package interactions;

import groovy.sql.Sql
import spock.lang.Specification;

/**
 * The mocking framework is built into Spock but you can use EasyMock, Mockito etc. if you want.
 * No need to record/replay the mocks
 * Mocked objects will return default values when no return value is enforced (e.g. false, 0, null).
 * You can verify the order of mock calls by using multiple 'then' blocks
 * You can use the wild card '_' for methods or arguments or even mock objects.
 *
 */
class InteractionsTest extends Specification {

	Sql sql = Mock(Sql)

	def "single return value from a mock using '>>' symbol"(){
		when:
			List result = sql.rows("select * from TABLE")
		then:
			sql.rows("select * from TABLE") >> ["A mock result"]
		and:
			result == ["A mock result"]
	}

	def "You can specify multiple return values using '>>>'"(){
		when:
			def resultA = sql.rows "a query"
			def resultB = sql.rows "a query"
			def resultC = sql.rows "a query"
		then:
			sql.rows("a query") >>> [["1"], ["2"]]
		then:
			resultA == ["1"]
			resultB == ["2"]
			resultC == ["2"]
	}

	def "default values are returned when no return values are specified"(){
		when: List defaultResult = sql.rows("query")
		then: defaultResult == null
		when: List mockedResult = sql.rows("query")
		then: 1 * sql.rows("query") >> ["mocked result"]
		then: mockedResult == ["mocked result"]
	}

	def "You can verify the number of calls and the order by using multiple 'then' blocks"(){
		when:
			sql.rows "call 1"
			sql.rows "call 2"
			sql.close()
		then:
			2 * sql.rows(_)
		then:
			1 * sql.close()
	}

	def "You can specify upper and lower bounds on the calls by using ranges"(){
		when:
			sql.close()
		then:
			(0..5) * sql.rows(_)
		then:
			1 * sql.close()
		then: "make sure no more calls after closed() is called"
			0 * sql._
	}

	def "You can force an exception to be thrown and then also verify that exceptions were thrown or not thrown"(){
		when:
			sql.rows("a query")
		then:
			sql.rows("a query") >> { throw new IllegalStateException() }
		and:
			thrown(IllegalStateException)
		and:
			notThrown(IllegalArgumentException)
	}


}
