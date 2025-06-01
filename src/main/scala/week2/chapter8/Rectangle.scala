package week2.chapter8

class Rectangle(val topLeft: Point, val width: Double, val height: Double) extends Shape {

  override def centerPoint: Point = {
    new Point(topLeft.x + width / 2, topLeft.y - height / 2)
  }
}
