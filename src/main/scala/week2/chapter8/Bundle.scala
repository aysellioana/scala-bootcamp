package week2.chapter8

import scala.collection.mutable.ListBuffer

class Bundle(items: List[Item]) extends Item {

  def addItem(item: Item): Bundle = new Bundle(item :: items)

  override def price: Double = {
    items.map(_.price).sum
  }

  override def description: String = {
    items.map(_.description).mkString(", ")
  }
}

// Companion object for easy creation
object Bundle {
  // Create an empty bundle
  def empty: Bundle = new Bundle(Nil)

  // Create a bundle from a variable number of items
  def apply(items: Item*): Bundle = new Bundle(items.toList)
}
