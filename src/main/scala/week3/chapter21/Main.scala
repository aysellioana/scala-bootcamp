package week3.chapter21

import PercentageOps._
import FactorialOps._
import FluentReader._



def average[T](seq: Seq[T])(implicit ev: NumberLike[T]): T = {
  val sum = seq.reduce(ev.plus)
  ev.divideBy(sum, seq.length)
}

object Main extends App {
  //ex1: 1. How does -> work? That is, how can "Hello" -> 42 and 42 -> "Hello" be pairs
  //("Hello", 42) and (42, "Hello")? Hint: Predef.ArrowAssoc.
  println("ex1")
  val a = "Hello" -> 42
  val b = 42 -> "Hello"

  println(a)
  println(b)

  println()
  println("ex2")
  val original = 120.0
  val result = original +% 10
  println(result)

  println()
  println("ex3")
  println(5.!)
  println(0.!)
  println(3.!)

  println()
  println("ex4")
  val name = Read in aString askingFor "Your name:"
  val age = Read in anInt askingFor "Your age:"
  val weight = Read in aDouble askingFor "Your weight:"

  println(s"Hello $name, you are $age years old and weigh $weight kg.")

  println()
  println("ex10")
  val doubles = Seq(1.0, 2.0, 3.0, 4.0)
  val avgDouble = average(doubles)
  println(avgDouble)

  val bigDecimals = Seq(BigDecimal(10), BigDecimal(20), BigDecimal(30))
  val avgBigDecimal = average(bigDecimals)
  println(avgBigDecimal)

  println()
  println("Ex13")
  val s = "abc"
  val upper: String = s.map(_.toUpper)
  println(upper)
  val codes: Vector[Int] = "abc".map(_.toInt).toVector
  println(codes)



}
