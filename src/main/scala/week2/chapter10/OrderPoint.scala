package week2.chapter10

import java.awt.Point
//ex2: Define a class OrderedPoint by mixing scala.math.Ordered[Point] into java.awt.Point.
//Use lexicographic ordering, i.e. (x, y) < (x’, y’) if x < x’ or x = x’ and y < y’.

class OrderedPoint(x: Int, y: Int)
  extends Point(x, y)
    with Ordered[Point] {

  override def compare(that: Point): Int = {
    if (this.x != that.x) this.x - that.x
    else this.y - that.y
  }
}
