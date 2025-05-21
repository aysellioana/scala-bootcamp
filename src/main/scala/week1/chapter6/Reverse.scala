package week1.chapter6
//ex5:. Write a Scala application, using the App trait, that prints its command-line
//arguments in reverse order, separated by spaces. For example, scala Reverse
//Hello World should print World Hello.

object Reverse  {
  // args: Array[String] is provided by App
  def main(args: Array[String]): Unit = {
    println(args.reverse.mkString(" "))
  }
}
