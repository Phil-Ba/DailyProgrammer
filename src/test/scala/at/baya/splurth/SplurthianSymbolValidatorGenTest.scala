package at.baya.splurth

import org.junit.runner.RunWith
import org.scalacheck.{Gen, Shrink}
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

import scala.util.Random

/**
	* Created by philba on 8/25/16.
	*/
@RunWith(classOf[JUnitRunner])
class SplurthianSymbolValidatorGenTest extends FunSpec with PropertyChecks {

	implicit val noShrink: Shrink[String] = Shrink.shrinkAny

	val elementsGenerator = Gen
		.listOfN(Random.nextInt(10) + 2, Gen.alphaChar)
		.map(_.mkString)

	val validElementsSymbolGenerator = elementsGenerator
		.map((element: String) => {
			println(": " + element)
			val length = element.length
			val indexFirst = Random.nextInt(length - 1)
			val indexSecond = randBetween(indexFirst + 1, length)
			(element, element(indexFirst).toString + element(indexSecond))
		})

	val invalidElementsSymbolGenerator = elementsGenerator
		.map((element: String) => {
			println(": " + element)
			val length = element.length
			val indexSecond = Random.nextInt(length - 1)
			val indexFirst = randBetween(indexSecond + 1, length)
			(element, element(indexFirst).toString + element(indexSecond))
		})
		.suchThat(secondLetterAlwaysBeforeFirst)

	def secondLetterAlwaysBeforeFirst(elementAndSymbol: (String, String)) = elementAndSymbol._1.indexOf(elementAndSymbol
		._2(0)) > elementAndSymbol._1.lastIndexOf(elementAndSymbol._2(1))

	def randBetween(min: Int, max: Int) = Random.nextInt(max - min) + min

	describe("For all elements the method isValid") {
		it("should return true for valid symbols") {
			forAll(validElementsSymbolGenerator) { (elementAndSymbol) =>
				println(elementAndSymbol)
				val cut: SplurthianSymbolValidator = new SplurthianSymbolValidator(elementAndSymbol._1,
					elementAndSymbol._2)
				assert(cut.isValid)
			}
		}
		it("should return true for invalid symbols") {
			forAll(invalidElementsSymbolGenerator) { (elementAndSymbol) =>
				println(elementAndSymbol)
				val cut: SplurthianSymbolValidator = new SplurthianSymbolValidator(elementAndSymbol._1,
					elementAndSymbol._2)
				assert(cut.isValid == false)
			}
		}
	}
}
