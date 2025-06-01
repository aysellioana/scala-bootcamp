package week2.chapter10

object Main extends App {
  println("ex1")
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike

  println(s"Initial: (${egg.getX}, ${egg.getY}, ${egg.getWidth}, ${egg.getHeight})")

  egg.translate(10, -10)
  println(s"After translate: (${egg.getX}, ${egg.getY}, ${egg.getWidth}, ${egg.getHeight})")

  egg.grow(10, 20)
  println(s"After grow: (${egg.getX}, ${egg.getY}, ${egg.getWidth}, ${egg.getHeight})")

  println("ex2")
  val p1 = new OrderedPoint(1,2)
  val p2 = new OrderedPoint(1,3)
  val p3 = new OrderedPoint(0,5)

  println(p1 < p2)
  println(p1 > p3)

}
