package week2.chapter14

//ex2: Using pattern matching, write a function swap that receives a pair of integers
//and returns the pair with the components swapped
def swap(pair: (Int, Int)): (Int, Int) = pair match {
  case (a, b) => (b, a)
}

//ex3:  Using pattern matching, write a function swap that swaps the first two elements
//of an array provided its length is at least two.
def swap2(array: Array[Int]): Array[Int] = array match {
  case Array(first, second, rest @_*) => Array(second, first) ++ rest
  case _ => array
}

//ex5: One can use lists to model trees that store values only in the leaves. For
//example, the list ((3 8) 2 (5)) describes the tree
//•
// /|\
//• 2 •
// / \ |
//3 8 5
//However, some of the list elements are numbers and others are lists. In Scala,
//you cannot have heterogeneous lists, so you have to use a List[Any]. Write a
//leafSum function to compute the sum of all elements in the leaves, using pattern
//matching to differentiate between numbers and lists.
def leafSum(tree: List[Any]):Int = tree.map{
  case i: Int => i
  case l:List[Any] => leafSum(l)
  case _ => 0
}.sum

//ex6
def leafSum2(tree:BinaryTree): Int = tree match{
  case Leaf(value) => value
  case Node(left, right) => leafSum2(left) + leafSum2(right)
}
//ex7
def leafSum3(tree:Tree): Int =  tree match {
  case Leaf2(value) => value
  case Node2(node @_*) => node.map(leafSum3).sum
}

//ex9: 9. Write a function that computes the sum of the non-None values in a
//List[Option[Int]]. Don’t use a match statement.
def sumOption(list: List[Option[Int]]): Int =
  list.flatten.sum

//ex10: Write a function that composes two functions of type Double => Option[Double],
//yielding another function of the same type. The composition should yield
//None if either function does. For example,
//def f(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
//def g(x: Double) = if (x >= 0) Some(sqrt(x)) else None
//val h = compose(g, f) // h(x) should be g(f(x))
//Then h(2) is Some(1), and h(1) and h(0) are None.

def compose(g: Double => Option[Double], f:Double => Option[Double]): Double => Option[Double] = {
  x => f(x).flatMap(g)
}

object Main extends App {
  println("ex2")
  val beforeSwapp = (3,7)
  val swappedNum = swap(beforeSwapp)
  println(swappedNum)

  println()
  println("ex3")
  val arr = Array(3,5,6,7)
  val swappedArr = swap2(arr)
  println(swappedArr.mkString(","))

  val arr2 = Array(5)
  val swappedArr2 = swap2(arr2)
  println(swappedArr2.mkString(","))

  println()
  println("ex4")
  val toaster = Article("Blackwell Toaster", 29.95)
  val mug = Article("Mug", 5.0)
  val tenToasters = Multiple(10, toaster)

  val bundle = Bundle("Kitchen Bundle", 10.0,
    tenToasters,
    Multiple(2, mug))


  println(s"Price of one toaster: ${toaster.price}")
  println(s"Price of ten toasters: ${tenToasters.price}")
  println(s"Price of kitchen bundle: ${bundle.price}")

  println()
  println("ex5")
  val leaf = List(List(2,5), 6, List(7))
  println(leafSum(leaf))

  println()
  println("ex6")
  val myTree = Node(
    Leaf(3),
    Node(
      Leaf(8),
      Node(Leaf(2), Leaf(5))
    )
  )
  println(leafSum2(myTree))

  println()
  println("ex7")
  val tree = Node2(
    Node2(Leaf2(3), Leaf2(8)),
    Leaf2(2),
    Node2(Leaf2(5))
  )
  println(leafSum3(tree))

  println()
  println("ex9")
  val listSum = List(Some(1), None, Some(4), Some(2), None)
  println(sumOption(listSum))

  println()
  println("ex10")

  def f(x: Double): Option[Double] =
    if (x != 1) Some(1 / (x - 1)) else None

  def g(x: Double): Option[Double] =
    if (x >= 0) Some(math.sqrt(x)) else None

  val h = compose(g, f)
  println(h(2))
  println(h(1))
  println(h(0))
}
