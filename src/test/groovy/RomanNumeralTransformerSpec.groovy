import spock.lang.Specification
import spock.lang.Unroll


class RomanNumeralTransformerSpec extends Specification {

	def arabicToRoman = [1: "I", 2: "II", 3: "III", 4: "IV", 5: "V", 9: "IX", 10: "X"]

	@Unroll
	def "for given value #arabicNumeral should return #expectedRomanNumeral"() {
		when:
		def romanNumeral = transform(arabicNumeral)

		then:
		romanNumeral == expectedRomanNumeral

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

	}

	def transform(def arabicNumeral) {
		def correspondence = arabicToRoman[arabicNumeral]
		if (correspondence) {
			return correspondence
		}
			else if(arabicNumeral / 10 > 0 ) {
				return arabicToRoman[10] + arabicToRoman[arabicNumeral % 10]
		} else {
			return arabicToRoman[5] + arabicToRoman[arabicNumeral % 5]
		}
	}
}