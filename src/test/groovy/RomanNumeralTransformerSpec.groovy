import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class RomanNumeralTransformerSpec extends Specification {


	private Object result

	def "it should pass"() {
		expect:
		true
	}

	def "arabic 1 should be transformed in roman numeral I"() {
		given:
		def arabicNumeral = 1
		def expected = "I"

		when:
		def actual = tranformToRoman(arabicNumeral);

		then:
		expected == actual;

	}

	Object tranformToRoman(int arabicNumeral) {
		return "I"
	}

	@Unroll
	def "arabic #arabicNumeral should be transformed in roman numeral #expected - TDD as if you meant it"() {
		when:

		def actual = concatenateRomanNumeral(arabicNumeral)

		then:
		expected == actual

		where:
		arabicNumeral | expected
		1             | "I"
		2             | "II"
		3             | "III"
	}

	private concatenateRomanNumeral(int arabicNumeral) {
		def result = ""
		(1..arabicNumeral).each { it -> result += getRomanOne() }
		return result
	}


	private getRomanOne() {
		"I"
	}

}