package at.bayava.rektengular

/**
	* Created by philba on 8/28/16.
	*/
class Rektangulator(val word: String) {


	def rektangulate(width: Int, heigth: Int): String = {
		val sb = StringBuilder.newBuilder
		for (line <- 0 until heigth) {
			//1 based index => the first line is always 1
			val currentLine: Int = line * (word.length - 1) + 1
			sb ++= writeWholeLine(width, currentLine) ++= "\n"
			for (otherLine <- 1 to (word.length - 2)) {
				sb ++= writeOtherLine(width, calculateLettersForOtherLines(otherLine + currentLine)) ++= "\n"
			}
		}
		sb ++= writeWholeLine(width, heigth+1)
		sb.mkString
	}

	/**
		* Writes a filler line consisting of two characters and spaces. Filler lines are the lines between the lines in
		* which the whole word is written.
		*
		* @param width the number of chars to print in this line
		* @param chars characters to use for this line
		* @return a string containing the filler line
		*/
	private[rektengular] def writeOtherLine(width: Int, chars: (Char, Char)): String = {
		val filler = " " * (word.length - 2)
		Stream.continually(List(chars._1, chars._2)).flatten.take(width + 1).mkString(filler)
	}

	/**
		* Writes a whole line by repeatedly printing the word an reverse word.
		*
		* @param width the number of word to print in this line
		* @param currentLine the line for which the print this line
		* @return a string containing the line
		*/
	private[rektengular] def writeWholeLine(width: Int, currentLine: Int) = {
		val wordForLine = currentLine match {
			case even if even % 2 == 0 => word.reverse
			case odd if odd % 2 == 1 => word
		}

		val sb = new StringBuilder(wordForLine)
		for {
			currentWord <- 0 until width - 1
		} yield {
			val nextPart = currentWord match {
				case even if even % 2 == 1 => wordForLine.drop(1)
				case odd if odd % 2 == 0 => wordForLine.reverse.drop(1)
			}
			sb ++= nextPart
		}
		sb.mkString
	}

	/**
		* Determines which chars should be used for a given filler line. Can throw an exception if the currentLine isnt a
		* filler line(eg. 1, as the first line should always print the whole word).
		* @param currentLine the line for which to determine the chars
		* @return the chars to be used in the given filler line
		*/
	private[rektengular] def calculateLettersForOtherLines(currentLine: Int): (Char, Char) = {
		val possibleCharacters: String = word.drop(1).dropRight(1)

		//both streams contain a "filler" element(-1 and possibleCharacters.length) because we need to account for the
		// normal lines
		def firstLetterStream: Stream[Int] = Stream.continually(
			(-1 until possibleCharacters.length) ++ (0 to possibleCharacters.length).reverse
		).flatten
		def secondLetterStream: Stream[Int] = Stream.continually(
			(0 to possibleCharacters.length).reverse ++ (-1 until possibleCharacters.length)
		).flatten

		//1 because of zero index
		val offset: Int = 1
		(possibleCharacters(firstLetterStream(currentLine - offset)), possibleCharacters(
			secondLetterStream(currentLine - offset)))
	}
}