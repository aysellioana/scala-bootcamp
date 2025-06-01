package week2.chapter11

import java.nio.file.Paths

object Main extends App {
  println("ex3")
  val f1 = new Fraction(1, 2)
  val f2 = new Fraction(3, 4)

  println(f1 + f2)
  println(f1 - f2)
  println(f1 * f2)
  println(f1 / f2)

  val f3 = new Fraction(15, -6)
  println(f3)


  println()
  println("ex4")
  val m1 = new Money(1, 75)
  val m2 = new Money(0, 50)
  val m3 = new Money(2, 25)

  println((m1 + m2).toString)
  println((m1 + m2) == m3)
  println((m3 - m1).toString)
  println(m1 < m3)


  println()
  println("ex9")
  val path = Paths.get("C:\\Users\\a.batcoveanu\\Documents\\scala-bootcamp\\src\\main\\resources\\myfile.txt")

  path match {
    case PathComponents(dir, file) =>
      println(s"Directory: $dir")
      println(s"File: $file")
    case _ =>
      println("Could not extract path components.")
  }


}
