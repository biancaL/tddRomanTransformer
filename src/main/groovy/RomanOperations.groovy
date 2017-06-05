/**
 * Created by biancal on 6/5/17.
 */
class RomanOperations {

	def romanNumeralTransformer

	def sum(def firstRoman, def secondRoman) {
		def arabicSum = romanNumeralTransformer.transformToArabic(firstRoman) + romanNumeralTransformer.transformToArabic(secondRoman)
		return romanNumeralTransformer.transform(arabicSum)
	}
}
