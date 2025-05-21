package week1

import scala.io.Source
import scala.collection.mutable
import scala.collection.immutable.SortedMap
import java.util.TreeMap
import scala.jdk.CollectionConverters._
import java.util.{Calendar, LinkedHashMap}
//ex2:Write a program that reads words from a file. Use a mutable map to count
//how often each word appears. To read the words, simply use a java.util.Scanner:
//val in = new java.util.Scanner(new java.io.File("myfile.txt"))
//while (in.hasNext()) process in.next()
//Or look at Chapter 9 for a Scalaesque way.
//At the end, print out all words and their counts.


def countWordsInFile(fileName: String): Unit = {
  val source = Source.fromResource(fileName)
  val wordCounts = mutable.Map[String, Int]()

  for (word <- source.getLines().flatMap(_.split("\\W+"))) {
    val lower = word.toLowerCase
    if (lower.nonEmpty) {
      wordCounts(lower) = wordCounts.getOrElse(lower, 0) + 1
    }
  }

  source.close()

  for ((word, count) <- wordCounts) {
    println(s"$word: $count")
  }
}
//ex3:Repeat the preceding exercise with an immutable map.
def countWordsImmutable(fileName: String): Unit = {
  val source = Source.fromResource(fileName)

  val words = source.getLines().flatMap(_.split("\\W+")).map(_.toLowerCase).filter(_.nonEmpty)

  val wordCounts = words.foldLeft(Map[String, Int]()) { (counts, word) =>
    counts.updated(word, counts.getOrElse(word, 0) + 1)
  }

  source.close()

  for ((word, count) <- wordCounts) {
    println(s"$word: $count")
  }
}

//ex4:Repeat the preceding exercise with a sorted map, so that the words are
//printed in sorted order
def countWordsSorted(fileName: String): Unit = {
  val source = Source.fromResource(fileName)

  val words = source.getLines().flatMap(_.split("\\W+")).map(_.toLowerCase).filter(_.nonEmpty)

  val wordCounts = words.foldLeft(SortedMap[String, Int]()) { (counts, word) =>
    counts.updated(word, counts.getOrElse(word, 0) + 1)
  }

  source.close()

  for ((word, count) <- wordCounts) {
    println(s"$word: $count")
  }
}

//ex5: Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
//Scala API.
def countWordsTreeMap(fileName: String): Unit = {
  val source = Source.fromResource(fileName)

  val words = source.getLines().flatMap(_.split("\\W+")).map(_.toLowerCase).filter(_.nonEmpty)

  val treeMap = new TreeMap[String, Int]()

  for (word <- words) {
    val count = if (treeMap.containsKey(word)) treeMap.get(word) + 1 else 1
    treeMap.put(word, count)
  }

  source.close()

  for ((word, count) <- treeMap.asScala) {
    println(s"$word: $count")
  }
}

//ex6:Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
//similarly for the other weekdays. Demonstrate that the elements are visited
//in insertion order.
def showWeekdaysInInsertionOrder(): Unit = {
  val daysMap = new LinkedHashMap[String, Int]()

  daysMap.put("Monday", Calendar.MONDAY)
  daysMap.put("Tuesday", Calendar.TUESDAY)
  daysMap.put("Wednesday", Calendar.WEDNESDAY)
  daysMap.put("Thursday", Calendar.THURSDAY)
  daysMap.put("Friday", Calendar.FRIDAY)
  daysMap.put("Saturday", Calendar.SATURDAY)
  daysMap.put("Sunday", Calendar.SUNDAY)

  println("Days in insertion order:")
  for ((day, value) <- daysMap.asScala) {
    println(s"$day -> $value")
  }
}

//ex7:Print a table of all Java properties reported by the getProperties method of the
//java.lang.System class, like this:
//java.runtime.name | Java(TM) SE Runtime Environment
//sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
//java.vm.version | 17.0-b16
//java.vm.vendor | Sun Microsystems Inc.
//java.vendor.url | http://java.sun.com/
//path.separator | :
//java.vm.name | Java HotSpot(TM) Server VM
//You need to find the length of the longest key before you can print the table.

def printProperties(): Unit = {
  val props = System.getProperties
  val propertyNames = props.stringPropertyNames().asScala

  var maxLen = 0
  for (key <- propertyNames) {
    if (key.length > maxLen) {
      maxLen = key.length
    }
  }

  for (key <- propertyNames) {
    val value = props.getProperty(key)
    val padding = " " * (maxLen - key.length)
    println(key + padding + " | " + value)
  }
}

//ex8:Write a function minmax(values: Array[Int]) that returns a pair containing the
//smallest and the largest values in the array.
def minmax(values: Array[Int]): (Int, Int) = {
  var min = values(0)
  var max = values(0)

  for (v <- values) {
    if (v < min) min = v
    if (v > max) max = v
  }

  (min, max)
}

//ex9:Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
//the counts of values less than v, equal to v, and greater than v
def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
  var less = 0
  var equal = 0
  var greater = 0

  for (x <- values) {
    if (x < v) less += 1
    else if (x == v) equal += 1
    else greater += 1
  }

  (less, equal, greater)
}

object Chapter4 {
  def main(args: Array[String]): Unit = {
    println("ex2")
    countWordsInFile("myfile.txt")

    println()
    println("ex3")
    countWordsImmutable("myfile.txt")

    println()
    println("ex4")
    countWordsSorted("myfile.txt")

    println()
    println("ex5")
    countWordsTreeMap("myfile.txt")


    println()
    println("ex6")
    showWeekdaysInInsertionOrder()

    println()
    println("ex7")
    printProperties()

    println()
    println("ex8")
    val arr = Array(5, 2, 9, 1, 7)
    val (minVal, maxVal) = minmax(arr)
    println("Min: " + minVal + ", Max: " + maxVal)

    println()
    println("ex9")
    val myArr = Array(1, 3, 5, 3, 7, 3, 9)
    val (lt, eq, gt) = lteqgt(myArr, 3)
    println(s"Less: $lt, Equal: $eq, Greater: $gt")
  }
}
