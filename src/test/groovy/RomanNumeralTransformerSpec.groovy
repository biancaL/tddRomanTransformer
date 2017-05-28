import spock.lang.Specification
import spock.lang.Unroll


class RomanNumeralTransformerSpec extends Specification {


	def arabicToRoman = [1: "I", 2: "II", 3: "III", 4: "IV", 5: "V", 9: "IX", 10: "X"]

	def "it should fail"() {
		expect:
		true
	}

	@Unroll
	def "it should return #expectedResult"() {
		when:
		def romanNumeral = transform(arabicNumeral)

		then:
		romanNumeral == expectedResult

		where:
		arabicNumeral || expectedResult
		1             || "I"
		2             || "II"
		3             || "III"
		4             || "IV"
		5             || "V"
		6             || "VI"
		7             || "VII"
		8             || "VIII"
		9             || "IX"
		10            || "X"
		11            || "XI"
		12            || "XII"
		13            || "XIII"
		14            || "XIV"
		15            || "XV"
		16            || "XVI"
		17            || "XVII"
		18            || "XVIII"
		19            || "XIX"
		20            || "XX"
	}

	def transform(def arabicNumeral) {
		def romanCorespondent = arabicToRoman[arabicNumeral]
		if (romanCorespondent) {
			return romanCorespondent
		}  else if (arabicNumeral / 10 >= 1) {
			def remainder = arabicNumeral % 10
			return arabicToRoman[10] + transform(remainder)
		}
		else {
			def remainder = arabicNumeral % 5
			def romanRemainder = arabicToRoman[remainder]
			return arabicToRoman[5] + romanRemainder
		}
	}
}