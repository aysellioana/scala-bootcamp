package week3.chapter21
//ex4: 4. Some people are fond of “fluent APIs” that read vaguely like English sentences. Create such an API for reading integers, floating-point numbers, and
//strings from the console. For example: Read in aString askingFor "Your name" and
//anInt askingFor "Your age" and aDouble askingFor "Your weight".

object FluentReader {
  sealed trait ReadType[A] {
    def read(prompt: String): A
  }

  case object aString extends ReadType[String] {
    def read(prompt: String): String = {
      println(prompt)
      scala.io.StdIn.readLine()
    }
  }

  case object anInt extends ReadType[Int] {
    def read(prompt: String): Int = {
      println(prompt)
      scala.io.StdIn.readLine().toInt
    }
  }

  case object aDouble extends ReadType[Double] {
    def read(prompt: String): Double = {
      println(prompt)
      scala.io.StdIn.readLine().toDouble
    }
  }

  object Read {
    def in[A](reader: ReadType[A]): PromptBuilder[A] = new PromptBuilder(reader)
  }

  class PromptBuilder[A](reader: ReadType[A]) {
    def askingFor(prompt: String): A = reader.read(prompt)
  }
}
