/**
 * Created by biancal on 6/5/17.
 */
class NumeralTransformer {

	def arabicToRoman = [1: "I", 4: "IV", 5: "V", 9: "IX", 10: "X", 40: "LC", 50:"L", 90:"XC", 100:"C", 400:"CD", 500:"D", 900:"CM", 1000:"M"]

	def transform(def arabicNumeral) {
		if(arabicNumeral < 1 || arabicNumeral > 4999) {
			throw new IllegalArgumentException()
		}
		if(arabicToRoman[arabicNumeral]) {
			return arabicToRoman[arabicNumeral]
		}
		for(def key: arabicToRoman.keySet().toList().reverse()) {
			if(arabicNumeral > key) {
				return arabicToRoman[key] + transform(arabicNumeral - key)
			}
		}
	}

	def transformToArabic(romanNumeral) {

	}
}
