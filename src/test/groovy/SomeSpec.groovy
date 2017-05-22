import spock.lang.Specification


class SomeSpec extends Specification {
	def "it fails"(){
		expect:
		true == false
	}

	def "it passes"(){
		expect:
		true == true
	}
}