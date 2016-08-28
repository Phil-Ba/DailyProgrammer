package at.bayava.rektengular

/**
	* Created by philba on 8/28/16.
	*/
class Rektangulator(val word: String) {


	def rektangulate(width: Int, heigth: Int):String = {
		val allLines = 0 until (heigth * word.length - 1)
		val sb = StringBuilder.newBuilder
		for {
			currentLine <- allLines
			currentWord <- 0 until width
		} yield {
			sb ++= writeLine(currentLine, currentWord)
		}

		println(sb.mkString)
		sb.mkString
	}

	private def writeLine(currentLine: Int, currentWord: Int):String = {println(currentLine+":"+currentWord)
		currentWord match {
		case even if even % 2 == 0 => word
		case odd if odd % 2 == 1 => word.reverse.drop(1)
	}
	}
}
