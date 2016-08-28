package at.bayava.rektengular

/**
	* Created by philba on 8/28/16.
	*/
class Rektangulator(val word: String) {


	def rektangulate(width: Int, heigth: Int): String = {

		def calculateHeigth(heigth: Int): Range = heigth match {
			case 1 => 1 to 1
			case n => 1 until heigth * word.length
		}

		val allLines: Range = calculateHeigth(heigth)
		val sb = StringBuilder.newBuilder
		for {
			currentLine <- allLines
		} yield {
			sb ++= writeLine(currentLine, width) ++= "\r\n"
		}

		println(sb.mkString)
		sb.mkString
	}


	private def writeLine(currentLine: Int, width: Int): String = {
		val sb = StringBuilder.newBuilder
		println(currentLine + ":")
		for {
			currentWord <- 0 until width
		} yield {
			val nextPart = currentWord match {
				case even if even % 2 == 0 => word
				case odd if odd % 2 == 1 => word.reverse.drop(1)
			}
			sb ++= nextPart
		}
		sb.mkString
	}
}
