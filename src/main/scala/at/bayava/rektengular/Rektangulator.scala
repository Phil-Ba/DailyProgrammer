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
			sb ++= writeLine(currentLine, width, allLines.last) ++= "\r\n"
		}

		println(sb.mkString)
		sb.mkString
	}


	private def writeLine(currentLine: Int, width: Int, lastLine:Int): String = {
		println(currentLine + ":")
		currentLine match {
			case wholeLine if wholeLine == 1 => writeWholeLine(width, wholeLine)
			case wholeLine if wholeLine == lastLine => writeWholeLine(width, wholeLine)
			case wholeLine if wholeLine % word.length == 0 => writeWholeLine(width, wholeLine)
			case rest => "rest:" + currentLine
		}
	}

	private def writeWholeLine(width: Int, currentLine: Int) = {
		val wordForLine = currentLine match {
			case even if even % 2 == 0 => word.reverse
			case odd if odd % 2 == 1 => word
		}

		val sb = StringBuilder.newBuilder
		for {
			currentWord <- 0 until width
		} yield {
			val nextPart = currentWord match {
				case even if even % 2 == 0 => wordForLine
				case odd if odd % 2 == 1 => wordForLine.reverse.drop(1)
			}
			sb ++= nextPart
		}
		sb.mkString
	}
}
