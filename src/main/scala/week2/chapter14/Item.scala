package week2.chapter14
//ex4: Add a case class Multiple that is a subclass of the Item class. For example,
//Multiple(10, Article("Blackwell Toaster", 29.95)) describes ten toasters. Of course,
//you should be able to handle any items, such as bundles or multiples, in
//the second argument. Extend the price function to handle this new case.

abstract class Item {
  def price: Double
}

case class Article(description: String, price: Double) extends Item

case class Bundle(description: String, discount: Double, items: Item*) extends Item{
  def price: Double = items.map(_.price).sum - discount
}

case class Multiple(quantity: Int, item: Item) extends Item{
  def price = quantity * item.price
}
