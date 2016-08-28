package at.bayava.splurth

/**
	* Created by philba on 8/25/16.
	*/
class SplurthianSymbolValidator(element: String, symbol: String) {

	def validateLengthOfSymbol(length: Int = 2) = symbol.length == length

	def validateThatElementContainsAllSymbolLetters = symbol.forall((symbolChar: Char) => element.contains(symbolChar))

	def validateThatSymbolLettersAreInOrder = symbol.sliding(2)
		.forall(chars => element.indexOf(chars(0)) < element.lastIndexOf(chars(1)))

	val isValid = validateLengthOfSymbol() && validateThatElementContainsAllSymbolLetters &&
		validateThatSymbolLettersAreInOrder

}
