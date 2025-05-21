package week1

import scala.collection.mutable.ArrayBuffer

//ex1:Write a code snippet that sets a to an array of n random integers between 0
//(inclusive) and n (exclusive)

def randomArray(n: Int): Array[Int] = {
  Array.fill(n)(scala.util.Random.nextInt(n))
}

//ex2:Write a loop that swaps adjacent elements of an array of integers. For example,
//Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
def swapAdjacent(a: Array[Int]): Unit = {
  for (i <- 0 until a.length - 1 by 2) {
    val temp = a(i)
    a(i) = a(i + 1)
    a(i + 1) = temp
  }
}

//ex3: . Repeat the preceding assignment, but produce a new array with the swapped
//values. Use for/yield.
def swappedArrayVar2(a: Array[Int]): Array[Int] = {
  for (i <- a.indices.toArray) yield {
    if (i % 2 == 0 && i + 1 < a.length) a(i + 1)
    else if (i % 2 == 1) a(i - 1)
    else a(i)
  }
}

//ex4:Given an array of integers, produce a new array that contains all positive
//values of the original array, in their original order, followed by all values that
//are zero or negative, in their original order
def reorderPosNeg(a: Array[Int]): Array[Int] = {
  val positives = a.filter(_ > 0)
  val nonPositives = a.filter(_ <= 0)
  positives ++ nonPositives
}

//ex5:  How do you compute the average of an Array[Double]?
def average(arr: Array[Double]): Double = {
  if (arr.isEmpty) 0.0
  else arr.sum / arr.length
}

//ex8:Suppose you are given an array buffer of integers and want to remove all but
//the first negative number. Here is a sequential solution that sets a flag
//when the first negative number is called, then removes all elements beyond.
//Chapter 3 Working with Arrays 44
//
//ptg20087099
//var first = true
//var n = a.length
//var i = 0
//while (i < n) {
// if (a(i) >= 0) i += 1
// else {
// if (first) { first = false; i += 1 }
// else { a.remove(i); n -= 1 }
// }
//}
//This is a complex and inefficient solution. Rewrite it in Scala by collecting
//positions of the negative elements, dropping the first element, reversing the
//sequence, and calling a.remove(i) for each index.
def removeAllButFirstNegative(a: ArrayBuffer[Int]): Unit = {
  val negativeIndices = a.indices.filter(i => a(i) < 0)
  val toRemove = negativeIndices.drop(1).reverse
  toRemove.foreach(a.remove)
}

//ex9:Improve the solution of the preceding exercise by collecting the positions
//that should be moved and their target positions. Make those moves and
//truncate the buffer. Don’t copy any elements before the first unwanted
//element.

def removeAllButFirstNegativeVar2(a: ArrayBuffer[Int]): Unit = {
  val keepIndices = collection.mutable.ArrayBuffer[Int]()
  var firstNegativeSeen = false

  for (i <- a.indices) {
    if (a(i) >= 0) keepIndices += i
    else if (!firstNegativeSeen) {
      keepIndices += i
      firstNegativeSeen = true
    }
  }

  for (j <- keepIndices.indices) {
    a(j) = a(keepIndices(j))
  }

  a.trimEnd(a.length - keepIndices.length)
}

//ex10. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
//that are in America. Strip off the "America/" prefix and sort the result.
def americanTimeZones(): Seq[String] = {
  import java.util.TimeZone

  TimeZone.getAvailableIDs
    .filter(_.startsWith("America/"))
    .map(_.stripPrefix("America/"))
    .sorted
}

object Chapter3 {
  def main(args: Array[String]): Unit = {

    println("ex1")
    val randomArrayEx = randomArray(10)
    println(randomArrayEx.mkString(", "))

    println()
    println("ex2")
    val swapAdjacentEx = Array(1, 2, 3, 4, 5)
    swapAdjacent(swapAdjacentEx)
    println(swapAdjacentEx.mkString(", "))

    println()
    println("ex3")
    val original = Array(1, 2, 3, 4, 5)
    val swapped = swappedArrayVar2(original)

    println("First: " + original.mkString(", "))
    println("Swapped:  " + swapped.mkString(", "))


    println()
    println("ex4")
    val originalPosNeg = Array(1, -2, 3, 0, -5, 6, 0)
    val reordered = reorderPosNeg(originalPosNeg)

    println("Initial:  " + originalPosNeg.mkString(", "))
    println("Reordered: " + reordered.mkString(", "))


    println()
    println("ex5")
    val valuesAverage = Array(4.0, 6.0, 8.0)
    println("Average: " + average(valuesAverage))

    //ex6:How do you rearrange the elements of an Array[Int] so that they appear in
    //reverse sorted order? How do you do the same with an ArrayBuffer[Int]?
    println()
    println("ex6.1")
    val arr = Array(5, 1, 9, 3)
    val sortedArray = arr.sorted(Ordering[Int].reverse)
    println("Sorted Array:       " + sortedArray.mkString(", "))

    println()
    println("ex6.2")
    val buf = ArrayBuffer(5, 1, 9, 3)
    buf.sortInPlace()(Ordering[Int].reverse)
    println("Sorted ArrayBuffer: " + buf.mkString(", "))


    //ex7:Write a code snippet that produces all values from an array with duplicates
    //removed. (Hint: Look at Scaladoc.)
    println()
    println("ex7")
    val valuesNoDuplicates = Array(1, 2, 2, 3, 1, 4)
    val noDuplicates = valuesNoDuplicates.distinct
    println("Initial:      " + valuesNoDuplicates.mkString(", "))
    println("No duplicates: " + noDuplicates.mkString(", "))

    println()
    println("ex8")
    val valuesBuffer = ArrayBuffer(1, -1, 2, -3, -4, 5, -6)
    println("First: " + valuesBuffer.mkString(", "))
    removeAllButFirstNegative(valuesBuffer)
    println("Result:  " + valuesBuffer.mkString(", "))

    println()
    println("ex9")
    val myArray = ArrayBuffer(1, -1, 2, -3, -4, 5, -6)
    println("First: " + myArray.mkString(", "))
    removeAllButFirstNegativeVar2(myArray)
    println("Result:  " + myArray.mkString(", "))

    println()
    println("ex10")
    val zones = americanTimeZones()
    println(zones.mkString(", "))
  }
}
