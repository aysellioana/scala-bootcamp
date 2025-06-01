package week1.chapter7

object HashMapCopyInnermost extends App{
  val javaMap = {
    import java.util.HashMap
    val map = new HashMap[String, Int]()
    map.put("one", 1)
    map.put("two", 2)
    map.put("three", 3)
    map
  }

  val scalaMap = {
    import scala.collection.mutable.HashMap
    new HashMap[String, Int]()
  }

  {
    import java.util.Map

    val entries = javaMap.entrySet().iterator()
    while (entries.hasNext) {
      val entry: Map.Entry[String, Int] = entries.next()
      scalaMap.put(entry.getKey, entry.getValue)
    }
  }


  println("Scala HashMap contents:")
  scalaMap.foreach { case (ky, value) => println(s"$ky -> $value") }
}
