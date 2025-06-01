package week2.chapter8
//ex9: In the Creature class of Section 8.10, “Construction Order and Early Definitions,”
//on page 98, replace val range with a def. What happens when you also use a def
//in the Ant subclass? What happens when you use a val in the subclass? Why?
class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}