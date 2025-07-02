package week2.chapter13

import java.util.TimeZone
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

//ex1: . Write a function that, given a string, produces a map of the indexes of all
//characters. For example, indexes("Mississippi") should return a map associating
//'M' with the set {0}, 'i' with the set {1, 4, 7, 10}, and so on. Use a mutable map
//of characters to mutable sets. How can you ensure that the set is sorted?
def indexes(s: String): mutable.Map[Char, mutable.SortedSet[Int]] = {
  val charMap = mutable.Map[Char, mutable.SortedSet[Int]]()

  for ((char, idx) <- s.zipWithIndex) {
    if (charMap.contains(char)) {
      charMap(char) += idx
    } else {
      charMap(char) = mutable.SortedSet(idx)
    }
  }

  charMap
}

//ex2: Repeat the preceding exercise, using an immutable map of characters to lists.
def indexes2(s: String): Map[Char, List[Int]] = {
  var charMap = Map[Char, List[Int]]()

  for ((char, idx) <- s.zipWithIndex) {
    if (charMap.contains(char)) {
      val updatedList = charMap(char) :+ idx
      charMap = charMap + (char -> updatedList)
    } else {
      charMap = charMap + (char -> List(idx))
    }
  }

  charMap
}

//ex3: Write a function that removes every second element from a ListBuffer. Try it
//two ways. Call remove(i) for all even i starting at the end of the list. Copy every
//second element to a new list. Compare the performance.
def removeEveryElement(arr: ListBuffer[Int]): Unit = {
  for (i <- arr.length - 1 to 0 by -1 if i % 2 == 1) {
    arr.remove(i)
  }
}

def removeEveryElement2(arr: ListBuffer[Int]): ListBuffer[Int] = {
  val newArr = ListBuffer[Int]()
  for ((elem, i) <- arr.zipWithIndex if i % 2 == 0) {
    newArr += elem
  }
  newArr
}

//ex4: Write a function that receives a collection of strings and a map from strings
//to integers. Return a collection of integers that are values of the map corresponding to one of the strings in the collection. For example, given Array("Tom",
//"Fred", "Harry") and Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5), return Array(3, 5).
//Hint: Use flatMap to combine the Option values returned by get
def lookupValues(names: Seq[String], map: Map[String, Int]): Seq[Int] = {
  names.flatMap(name => map.get(name))
}

//ex5:  Implement a function that works just like mkString, using reduceLeft.
def myMkString(list: List[String], sep: String): String = {
  if (list.isEmpty) ""
  else list.reduceLeft((a, b) => a + sep + b)
}

//ex8: Write a function that turns an array of Double values into a two-dimensional
//array. Pass the number of columns as a parameter. For example, with Array(1,
//2, 3, 4, 5, 6) and three columns, return Array(Array(1, 2, 3), Array(4, 5, 6)).
//Use the grouped method.

def to2DArray(arr: Array[Double], columns: Int): Array[Array[Double]] = {
  // Split into groups of 'columns', convert each to Array, and return the result
  arr.grouped(columns).map(group => group.toArray).toArray
}

//ex10: The method java.util.TimeZone.getAvailableIDs yields time zones such as Africa/
//Cairo and Asia/Chungking. Which continent has the most time zones? Hint: groupBy.

def continentWithMostTimeZones(): String = {
  val allZones = TimeZone.getAvailableIDs.toList

  // Keep only the IDs that contain "/"
  val validZones = allZones.filter(_.contains("/"))
  // Extract the continent (the part before the "/")
  val continents = validZones.map(id => id.split("/")(0))
  val grouped = continents.groupBy(identity)
  val continentCounts = grouped.mapValues(_.size)
  //Find the continent with the most time zones
  val (topContinent, count) = continentCounts.maxBy(_._2)
  s"$topContinent ($count time zones)"
}

object Main extends App{
  println("ex1")

  val input = "Mississippi"
  val resultEx1 = indexes(input)
  println(resultEx1)
  for ((char, indices) <- resultEx1) {
    println(s"'$char' -> ${indices.mkString("{", ", ", "}")}")
  }

  println()
  println("ex2")

  val resultEx2 = indexes2(input)
  println(resultEx2)
  for ((char, indices) <- resultEx2) {
    println(s"'$char' -> ${indices.mkString("{", ", ", "}")}")
  }

  println()
  println("ex3")
  val arr = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8)
  val arr2 = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8)
  val afterRemove = removeEveryElement(arr)
  println(arr)
  val afterRemove2 = removeEveryElement2(arr2)
  println(afterRemove2)

  println()
  println("ex4")
  val names = Array("Tom", "Fred", "Harry")
  val scores = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

  val result = lookupValues(names, scores)
  println(result)

  println()
  println("ex5")
  val res = myMkString(List("a", "b", "c"), "-")
  println(res)

  println()
  println("ex8")
  val myArr = Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
  val myResult = to2DArray(myArr, 3)
  for (row <- myResult) {
    println(row.mkString(", "))
  }
  println()
  println("Ex10")
  println(continentWithMostTimeZones())



}
