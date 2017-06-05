import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class RomanNumeralTransformerSpec extends Specification {


	def "it should pass"() {
		expect:
		true
	}

	@Unroll
	def "arabic numeral #arabicNumeral should return roman numeral #expectedRomanNumeral"() {
		given:
		def transformer = new RomanNumeralTransformer()

		when:
		def result = transformer.transform(arabicNumeral)

		then:
		result == expectedRomanNumeral

		where:
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
		12            | "XII"
		12            | "XII"
		13            | "XIII"
		14            | "XIV"
		15            | "XV"
		16            | "XVI"
		17            | "XVII"
		18            | "XVIII"
		19            | "XIX"
		20            | "XX"
		21            | "XXI"
		37            | "XXXVII"
		40            | "XL"
		41            | "XLI"
		59            | "LIX"
		100           | "C"
		4984          | "MMMMCMLXXXIV"
	}

	def "returns the sum of two roman numerals"() {
		given:
		def romanOperations = new RomanOperations()
		romanOperations.romanNumeralTransformer = Mock(RomanNumeralTransformer)

		when:
		def sum = romanOperations.sum(firstRoman, secondRoman)

		then:
		1 * romanOperations.romanNumeralTransformer.transformToArabic(firstRoman) >> 1
		1 * romanOperations.romanNumeralTransformer.transformToArabic(secondRoman) >> 1
		1 * romanOperations.romanNumeralTransformer.transform(2) >> "II"
		sum == expectedSum

		where:
		firstRoman | secondRoman || expectedSum
		"I"        | "I"          | "II"

	}
	@Unroll
	def "throws IllegalArgumentException when arabicNumeral is #arabicNumeral"() {
		given:"Roman numeral transformer class"
		def romanNumeralTransformer = new RomanNumeralTransformer()

		when:"Transform method is called on arabicNumeral"
		romanNumeralTransformer.transform(arabicNumeral)

		then:"IllegalArgumentException is thrown"
		thrown(IllegalArgumentException)

		where:"Arabic numeral is #arabicNumeral"
		arabicNumeral << [0, -1, 4000, 4001]
	}
}