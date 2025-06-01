package week1.chapter7
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.{HashMap => ScalaHashMap}

//ex6: . Write a program that copies all elements from a Java hash map into a Scala
//hash map. Use imports to rename both classes

object HashMapCopy extends App {
  // Java HashMap with some data
  val javaMap = new JavaHashMap[String, Int]()
  javaMap.put("one", 1)
  javaMap.put("two", 2)
  javaMap.put("three", 3)

  // Scala HashMap to copy into
  val scalaMap = new ScalaHashMap[String, Int]()

  // Copying all elements from Java HashMap to Scala HashMap
  val entries = javaMap.entrySet().iterator()    // to access entries -> Map.Entry[String, Int]
  while (entries.hasNext) {
    val entry = entries.next()
    scalaMap.put(entry.getKey, entry.getValue)
  }

  println("Scala HashMap contents:")
  scalaMap.foreach { case (ky, value) => println(s"$ky -> $value") }
}
