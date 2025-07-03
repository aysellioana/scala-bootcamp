package week3.chapter9

import java.net.URL
import scala.io.Source
//ex3: Write a Scala code snippet that reads a file and prints all words with more
//than 12 characters to the console. Extra credit if you can do this in a single line

def printLongWords(fileName: String): Unit = {
  Source.fromResource(fileName)
    .getLines()
    .flatMap(_.split("\\W+"))
    .filter(_.length > 12)
    .foreach(println)
}

//ex4: . Write a Scala program that reads a text file containing only floating-point
//numbers. Print the sum, average, maximum, and minimum of the numbers
//in the file.

def readNumbers(fileName: String):List[Double] = {
  val source = Source.fromResource(fileName)
  val numbers = source.getLines().toList.map(_.toDouble)
  source.close()
  numbers
}

//ex7: Write a Scala program that reads a text file and prints all tokens in the file
//that are not floating-point numbers. Use a regular expression.
def printNonFloatingTokens(fileName: String): Unit = {
  val floatRegex = """^-?\d+\.\d+$""".r

  val source = Source.fromResource(fileName)
  val tokens = source.getLines().flatMap(_.split("\\s+"))
  val nonFloating = tokens.filterNot(token => floatRegex.matches(token))
  nonFloating.foreach(println)
  source.close()
}

//ex8: 8. Write a Scala program that prints the src attributes of all img tags of a web
//page. Use regular expressions and groups
def printImageSourcesFromUrl(pageUrl: String): Unit = {
  val html = Source.fromURL(new URL(pageUrl)).mkString

  val imgTagRegex = """<img[^>]*?src=["']([^"']+)["']""".r

  println(s"Image sources found in: $pageUrl")
  for (imgTagRegex(src) <- imgTagRegex.findAllIn(html)) {
    println(src)
  }
}

object Main extends App {
  println("Ex3")
  printLongWords("fileTest.txt")

  println()
  println("Ex4")

  val numbers = readNumbers("fileNumbers.txt")
  if(numbers.nonEmpty){
    println(f"Sum: ${numbers.sum}%.2f")
    println(f"Average: ${numbers.sum / numbers.length}%.2f")
    println(f"Min: ${numbers.min}%.2f")
    println(f"Max: ${numbers.max}%.2f")
  }else{
    println("The file is empty or contains no valid numbers.")
  }

  println()
  println("Ex7")
  printNonFloatingTokens("fileTokens.txt")

  println()
  println("ex8")
  val url = "https://en.wikipedia.org/wiki/Tailor_Swif"
  printImageSourcesFromUrl(url)

}
