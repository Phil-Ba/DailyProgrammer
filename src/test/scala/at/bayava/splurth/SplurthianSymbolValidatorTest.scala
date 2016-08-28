package at.bayava.splurth

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

/**
	* Created by philba on 8/25/16.
	*/
@RunWith(classOf[JUnitRunner])
class SplurthianSymbolValidatorTest extends FunSpec {

	describe("For the element 'Mercury'") {
		var cut: SplurthianSymbolValidator = null
		def initCutWithSymbol(symbol: String) = cut = new SplurthianSymbolValidator("Mercury", symbol)

		describe("the method validateLengthOfSymbol") {
			it("should return 'true' for 'Mc'") {
				initCutWithSymbol("Mc")
				assert(cut.validateLengthOfSymbol())
			}
			it("should return false for 'Mcd'") {
				initCutWithSymbol("Mcd")
				assert(cut.validateLengthOfSymbol() == false)
			}
			it("should return false for 'M'") {
				initCutWithSymbol("M")
				assert(cut.validateLengthOfSymbol() == false)
			}
		}

		describe("the method validateThatElementContainsAllSymbolLetters") {
			it("should return true for 'Mc'") {
				initCutWithSymbol("Mc")
				assert(cut.validateThatElementContainsAllSymbolLetters)
			}
			it("should return false for 'Md'") {
				initCutWithSymbol("Md")
				assert(cut.validateThatElementContainsAllSymbolLetters == false)
			}
		}

		describe("the method validateThatSymbolLettersAreInOrder") {
			it("should return true for 'Mc'") {
				initCutWithSymbol("Mc")
				assert(cut.validateThatSymbolLettersAreInOrder)
			}
			it("should return true for 'cr'") {
				initCutWithSymbol("cr")
				assert(cut.validateThatSymbolLettersAreInOrder)
			}
			it("should return false for 'cM'") {
				initCutWithSymbol("cM")
				assert(cut.validateThatSymbolLettersAreInOrder == false)
			}
			it("should return false for 'yr'") {
				initCutWithSymbol("yr")
				assert(cut.validateThatSymbolLettersAreInOrder == false)
			}
			it("should return true for 'Mry'") {
				initCutWithSymbol("Mry")
				assert(cut.validateThatSymbolLettersAreInOrder)
			}
			it("should return false for 'cer'") {
				initCutWithSymbol("cer")
				assert(cut.validateThatSymbolLettersAreInOrder == false)
			}
		}

		describe("isValid") {
			it("should be true for 'ey'") {
				initCutWithSymbol("ey")
				assert(cut.isValid)
			}
			it("should be true for 'ye'") {
				initCutWithSymbol("ye")
				assert(cut.isValid == false)
			}
		}
	}

}
