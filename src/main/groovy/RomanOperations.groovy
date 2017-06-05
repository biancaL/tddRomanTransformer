/**
 * Created by biancal on 6/5/17.
 */
class RomanOperations {

	def numeralTranformer

	def sum(firstRoman, secondRoman) {
		def firstArabic = numeralTranformer.transformToArabic(firstRoman)
		def secondArabic = numeralTranformer.transformToArabic(secondRoman)
 		return numeralTranformer.transform(firstArabic + secondArabic)
	}
}
