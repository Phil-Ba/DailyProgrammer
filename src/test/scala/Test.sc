import java.util

import org.scalacheck.Gen

"123456".sliding(2).foreach(println(_))
"1234567".sliding(2).foreach(println(_))
"1234567".toCharArray.sliding(2).foreach(s => println(util.Arrays.toString(s)))

val value: Any = for (n <- Gen.alphaChar) yield {
	n
}
"123" (2)
"123" (1)
