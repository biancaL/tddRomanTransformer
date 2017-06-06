import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralTransformerSpec extends Specification {

	def arabicToRoman = [1: "I", 4: "IV", 5: "V", 9: "IX", 10: "X", 40: "XL", 50: "L", 90: "XC", 100: "C", 400: "CD", 500: "D", 900: "CM", 1000: "M"]

	def "it should pass"() {
		expect:
		true
	}

	@Unroll
	def "arabic numeral #arabicNumeral should return roman numeral #expectedRomanNumeral"() {
		when:"Transformer method is applied on arabicNumeral"
		def result = transform(arabicNumeral)

		then:"Result is #expectedRomanNumeral"
		result == expectedRomanNumeral

		where:"Arabic numeral is #arabicNumeral"
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
		14            | "XIV"
		20            | "XX"
		36            | "XXXVI"
		40            | "XL"
		41            | "XLI"
		51            | "LI"
		91            | "XCI"
		100           | "C"
		400           | "CD"
		500           | "D"
		900           | "CM"
		1000          | "M"
		4765          | "MMMMDCCLXV"

	}
	@Unroll
	def "throws IllegalArgumentException when arabicNumeral is #arabicNumeral"() {
		when:
		transform(arabicNumeral)

		then:
		thrown(IllegalArgumentException)

		where:
		arabicNumeral <<[0, -1, 5000]

	}

	def transform(arabicNumeral) {
		if(arabicNumeral < 1 || arabicNumeral > 4999) {
			throw new IllegalArgumentException()
		}
		if (arabicToRoman[arabicNumeral] != null) {
			return arabicToRoman[arabicNumeral]
		}
		for (def key : arabicToRoman.keySet().toList().reverse()) {
			if (arabicNumeral > key) {
				return arabicToRoman[key] + transform(arabicNumeral - key)
			}
		}
	}
}