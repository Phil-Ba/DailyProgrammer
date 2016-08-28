package at.bayava.rektengular

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

/**
	* Created by philba on 8/28/16.
	*/
@RunWith(classOf[JUnitRunner])
class RektangulatorTest extends FunSpec {

	describe("For the word 'Rekt'") {
		val cut = new Rektangulator("Rekt")
		describe("the method rektangulate") {
			describe("if called with (1,1)") {
				val rektangulate: String = cut.rektangulate(1, 1)

				it("should only return one line") {
					assert(rektangulate.lines.length == 1)
				}
				it("should produce 'Rekt' as first line") {
					assert(rektangulate.lines.next == "Rekt")
				}
			}
		}

		describe("if called with (2,2)") {
			val rektangulate: String = cut.rektangulate(2, 2)

			it("should return seven lines") {
				val expectedHeigth: Int = "Rekt".length * 2 - 1
				assert(rektangulate.lines.length == expectedHeigth)
			}
			it("should produce 'RektkeR' as first line") {
				assert(rektangulate.lines.next == "RektkeR")
			}
			it("should produce 'e  k  e' as second line") {
				assert(rektangulate.lines.drop(1).next == "e  k  e")
			}
			it("should produce 'k  e  k' as third line") {
				assert(rektangulate.lines.drop(2).next == "k  e  k")
			}
			it("should produce 'tkeRekt' as fourth line") {
				assert(rektangulate.lines.drop(3).next == "tkeRekt")
			}
		}

		describe("if called with (2,3)") {
			val rektangulate: String = cut.rektangulate(2, 3)

			it("should return ten lines") {
				val expectedHeigth: Int = "Rekt".length * 3 - 1
				assert(rektangulate.lines.length == expectedHeigth)
			}
		}
	}


}
