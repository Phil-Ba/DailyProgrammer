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
			it("should produce 'RektkeR' as final line") {
				assert(rektangulate.lines.toList.last == "RektkeR")
			}
		}

		describe("if called with (2,3)") {
			val rektangulate: String = cut.rektangulate(2, 3)

			it("should return ten lines") {
				val expectedHeigth: Int = "Rekt".length * 3 - 1
				assert(rektangulate.lines.length == expectedHeigth)
			}
		}

		describe("the method calculateLettersForOtherLines") {
			it("should return (e,k) for the second line") {
				assert(cut.calculateLettersForOtherLines(2) == ('e', 'k'))
			}
			it("should return (k,e) for the third line") {
				assert(cut.calculateLettersForOtherLines(3) == ('k', 'e'))
			}
			it("should return (k,e) for the fifth line") {
				assert(cut.calculateLettersForOtherLines(5) == ('k', 'e'))
			}
		}
	}

	describe("For the word 'AbcdE'") {
		val cut = new Rektangulator("AbcdE")
		describe("the method calculateLettersForOtherLines") {
			it("should return (b,d) for the second line") {
				assert(cut.calculateLettersForOtherLines(2) == ('b', 'd'))
			}
			it("should return (c,c) for the third line") {
				assert(cut.calculateLettersForOtherLines(3) == ('c', 'c'))
			}
			it("should return (d,b) for the fourth line") {
				assert(cut.calculateLettersForOtherLines(4) == ('d', 'b'))
			}
			it("should return (d,b) for the sixth line") {
				assert(cut.calculateLettersForOtherLines(6) == ('d', 'b'))
			}
			it("should return (c,c) for the seventh line") {
				assert(cut.calculateLettersForOtherLines(7) == ('c', 'c'))
			}
			it("should return (b,d) for the eighth line") {
				assert(cut.calculateLettersForOtherLines(8) == ('b', 'd'))
			}
		}
	}

	describe("For the word 'AbcdeF'") {
		val cut = new Rektangulator("AbcdeF")
		describe("the method calculateLettersForOtherLines") {
			it("should return (b,e) for the second line") {
				assert(cut.calculateLettersForOtherLines(2) == ('b', 'e'))
			}
			it("should return (c,d) for the third line") {
				assert(cut.calculateLettersForOtherLines(3) == ('c', 'd'))
			}
			it("should return (d,c) for the fourth line") {
				assert(cut.calculateLettersForOtherLines(4) == ('d', 'c'))
			}
			it("should return (e,b) for the fifth line") {
				assert(cut.calculateLettersForOtherLines(5) == ('e', 'b'))
			}
			it("should return (e,b) for the seventh line") {
				assert(cut.calculateLettersForOtherLines(7) == ('e', 'b'))
			}
		}
	}
}
