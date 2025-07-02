package week3.chapter19
//ex8:8. Write a function printValues with three parameters f, from, to that prints all
//values of f with inputs from the given range. Here, f should be any object
//with an apply method that consumes and yields an Int. For example,
//printValues((x: Int) => x * x, 3, 6) // Prints 9 16 25 36
//printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6) // Prints 3 5 8 13

import scala.reflect.Selectable.reflectiveSelectable

def printValues(f: {def apply(x: Int): Int}, from: Int, to: Int): Unit = {
  for (i <- from to to) {
    print(f(i) + " ")
  }
  println()
}

object Main extends App {
  println("ex1")
  val bug = new Bug
  bug.move(4).show().move(6).show().turn().move(5).show()

  println()
  println("ex3")
  val book = new Document
  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
  book.print()

  println()
  println("ex4")
  val net1 = new Network
  val net2 = new Network

  val a = net1.join("Alice")
  val b = net1.join("Alice")
  val c = net2.join("Alice")

  println(a == b)
  println(a == c)

  println()
  println("ex8")
  printValues(new {
    def apply(x: Int): Int = x * x
  }, 3, 6)

}
