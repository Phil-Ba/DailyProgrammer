import java.util

import org.scalacheck.Gen

2 / 3
"123456".sliding(2).foreach(println(_))
"1234567".sliding(2).foreach(println(_))
"1234567".toCharArray.sliding(2).foreach(s => println(util.Arrays.toString(s)))

val value: Any = for (n <- Gen.alphaChar) yield {
	n
}

val word = "AbcdE"
val possibleCharacters: String = word.drop(1).dropRight(1)
def x(i: Int) = {

	val modifier = i <  word.length match{
		case true => 2
		case false => i / word.length
	}
	val charPosition: Int = (i - (modifier)) % (possibleCharacters.length)
	println(charPosition+"|"+modifier)
	println(charPosition + ":" + (possibleCharacters.length - charPosition - 1))
	(word(charPosition), possibleCharacters(possibleCharacters.length -
		charPosition-1))
}
def doIndx(idx: Int, chars: Int) = idx - 1 match {
	case neg if neg < 0 => neg + chars
	case i: Int => i
}

x(2)
"???"
x(3)
"???"
x(4)
"???"
x(6)
"???"
x(7)
"fini"

def x2(i: Int) = {

	val modifier = i <  word.length match{
		case true => 2
		case false => i / word.length
	}
	//	val modifier = i / word.length
	val charPosition: Int = (i - (modifier)) % (possibleCharacters.length)
	println(charPosition+"|"+modifier)
	println(charPosition + ":" + (possibleCharacters.length - charPosition - 1))
	//	println(doIndx(charPosition,possibleCharacters.length) + ":" + (possibleCharacters.length - charPosition - 1))
	(possibleCharacters(charPosition), possibleCharacters(possibleCharacters.length -
		charPosition - 1))
	//	(possibleCharacters(doIndx(charPosition,possibleCharacters.length)), possibleCharacters(possibleCharacters
	// .length -
}