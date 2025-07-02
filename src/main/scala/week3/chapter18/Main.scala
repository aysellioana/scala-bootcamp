package week3.chapter18
//ex6:Write a generic method middle that returns the middle element from any
//Iterable[T]. For example, middle("World") is 'r'.
def middle[T](iter:Iterable[T]):T = {
  val idx = iter.size/2
  iter.drop(idx).head
}
object Main extends App {
  println("ex1")
  val pair = Pair(1, "Hello")
  val swapped = pair.swap
  println(pair)
  println(swapped)

  println()
  println("ex2")
  val pair2 = new Pair2(2, 4)
  println(s"${pair2.first}, ${pair2.second}")
  pair2.swap()
  println(s"${pair2.first}, ${pair2.second}")

  println()
  println("ex3")
  val p = Pair3(42, "Scala")
  val swapped3 = swap(p)
  println(swapped3)

  println()
  println("ex6")
  val elem = "testt"
  println(middle(elem))
  val list = List(10,20,30,40,50)
  println(middle(list))

  println()
  println("ex8")
  val studentPair = new Pair8(new Student("Stud1"), new Student("Stud2"))
  println(studentPair)

  val replaced = studentPair.replaceFirst(new Person("Stud3"))
  println(replaced)

  println()
  println("ex10")
  val pair10 = new Pair10[Int, Int](1, 2)
  pair10.swap()
  println(pair10)

}
