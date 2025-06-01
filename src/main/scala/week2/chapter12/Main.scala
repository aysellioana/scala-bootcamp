package week2.chapter12
//ex1:  Write a function values(fun: (Int) => Int, low: Int, high: Int) that yields a collection of function inputs and outputs in a given range. For example, values(x =>
//x * x, -5, 5) should produce a collection of pairs (-5, 25), (-4, 16), (-3, 9), . . . ,
//(5, 25).

def values(f: Int => Int, low: Int, high: Int): List[(Int, Int)] = {
  var result = List[(Int, Int)]()
  for(i <- low to high){
    result = result :+ (i, f(i))
  }
  result
}

//ex2: How do you get the largest element of an array with reduceLeft?
def maxWithReduceLeft(arr: Array[Int]): Int = {
  arr.reduceLeft((a, b) => if (a > b) a else b)
}

//ex3: Implement the factorial function using to and reduceLeft, without a loop or
//recursion.
def factorial(n: Int): Int = {
  if(n < 1){
    1
  }else{
    val numbers = 1 to n
    numbers.reduceLeft((a,b) => a* b)
  }
}

//ex4: 4. The previous implementation needed a special case when n < 1. Show how
//you can avoid this with foldLeft. (Look at the Scaladoc for foldLeft. It’s like
//reduceLeft, except that the first value in the chain of combined values is supplied
//in the call.)

def factorial2(n: Int): Int = {
  val numbers = 1 to n
  val result =numbers.foldLeft(1)((a,b) => a*b)
  result
}

//ex5: Write a function largest(fun: (Int) => Int, inputs: Seq[Int]) that yields the largest
//value of a function within a given sequence of inputs. For example, largest(x
//=> 10 * x - x * x, 1 to 10) should return 25. Don’t use a loop or recursion.
def largest(fun: Int => Int, inputs: Seq[Int]): Int = {
  val results = inputs.map(x => fun(x))
  val maxValue = results.max
  maxValue
}

//ex6:  Modify the previous function to return the input at which the output is largest.
//For example, largestAt(x => 10 * x - x * x, 1 to 10) should return 5. Don’t use
//a loop or recursion.
def largest2(fun: Int => Int, inputs: Seq[Int]): Int = {
  val pairs = inputs.map(x => (x, fun(x)))
  val maxPair = pairs.maxBy(pair => pair._2)
  val input = maxPair._1
  input
}

//ex7: It’s easy to get a sequence of pairs, for example:
//val pairs = (1 to 10) zip (11 to 20)
//Now, suppose you want to do something with such a sequence—say, add
//up the values. But you can’t do
//pairs.map(_ + _)
//The function _ + _ takes two Int parameters, not an (Int, Int) pair. Write a
//function adjustToPair that receives a function of type (Int, Int) => Int and returns
//the equivalent function that operates on a pair. For example, adjustToPair(_ *
//_)((6, 7)) is 42.
//Then use this function in conjunction with map to compute the sums of the
//elements in pairs.


//Ex10: Implement an unless control abstraction that works just like if, but with an
//inverted condition. Does the first parameter need to be a call-by-name
//parameter? Do you need currying?
def unless(condition: => Boolean)(block: => Unit): Unit = {
  if (!condition) block
}


def adjustToPair(f: (Int, Int) => Int): ((Int, Int)) => Int = {
  def newFunc(pair: (Int, Int)): Int = {
    val a = pair._1
    val b = pair._2
    f(a,b)
  }
  newFunc
}

object Main extends App {

  println("ex1")
  val result = values(x => x * x, -3,3)
  println(result)

  println()
  println("ex2")
  val nums = Array(3, 7, 2, 9, 4)
  println(maxWithReduceLeft(nums))

  println()
  println("ex3")
  println(factorial(4))

  println()
  println("ex4")
  println(factorial2(4))

  println()
  println("ex5")
  println(largest(x => 10 * x - x * x, 1 to 10))

  println()
  println("ex6")
  println(largest2(x => 10 * x - x * x, 1 to 10))

  println()
  println("ex7")
  val range1 = 1 to 10
  val range2 = 11 to 20
  val pairs = range1.zip(range2)

  val newFunction = (x: Int, y:Int) => x + y
  val adjustedFunction = adjustToPair(newFunction)

  val results = pairs.map(adjustedFunction)
  println(results)


  //In Section 12.8, “Currying,” on page 164, you saw the corresponds method used
  //with two arrays of strings. Make a call to corresponds that checks whether the
  //elements in an array of strings have the lengths given in an array of integers.
  println()
  println("ex8")
  val strings = Array("Hello", "World", "!")
  val lengths = Array(5, 5, 1)

  val resultEx8 = strings.corresponds(lengths)(_.length == _)
  println(resultEx8)

  println()
  println("ex10")
  val x = 5
  unless(x > 10) {
    println("x is not greater than 10")
  }
}
