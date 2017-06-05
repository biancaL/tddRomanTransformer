import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class RomanNumeralTransformerSpec extends Specification {

	@Unroll
	def "arabic numeral #arabicNumeral should return roman numeral #expectedRomanNumeral"() {
		when: "Arabic numeral is transformed to roman numeral"
		def result = new NumeralTransformer().transform(arabicNumeral)

		then: "Result is #expectedRomanNumeral"
		result == expectedRomanNumeral

		where: "Arabic numeral #arabicNumeral"
		arabicNumeral | expectedRomanNumeral
		1             | "I"
		2             | "II"
		3             | "III"
		4             | "IV"
		5             | "V"
		6             | "VI"
		7             | "VII"
		8             | "VIII"
		9             | "IX"
		10            | "X"
		11            | "XI"
		15            | "XV"
		20            | "XX"
		30            | "XXX"
		40            | "LC"
		41            | "LCI"
		3789          | "MMMDCCLXXXIX"
	}

	def "throws exception for arabicNumeral #arabicNumeral"() {
		when: "Arabic numeral is transformed"
		new NumeralTransformer().transform(arabicNumeral)

		then: "IllegalArgumentException is thrown"
		thrown(IllegalArgumentException)

		where: "Arabic numeral is"
		arabicNumeral << [0, -1, 5000]
	}

	def "returns sum between #firstRoman and #secondRoman"() {
		given:
		def operations = new RomanOperations()
		operations.numeralTranformer = Mock(NumeralTransformer)


		when:
		def result = operations.sum(firstRoman, secondRoman)

		then:
		1 * operations.numeralTranformer.transformToArabic(firstRoman) >> 1
		1 * operations.numeralTranformer.transformToArabic(secondRoman) >> 2
		1 * operations.numeralTranformer.transform(3) >> "III"
		result == expectedSum

		where:
		firstRoman | secondRoman || expectedSum
		"I"        | "II"         | "III"
	}
}