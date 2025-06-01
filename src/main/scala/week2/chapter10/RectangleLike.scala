package week2.chapter10
//ex1: The java.awt.Rectangle class has useful methods translate and grow that are unfortunately absent from classes such as java.awt.geom.Ellipse2D. In Scala, you
//can fix this problem. Define a trait RectangleLike with concrete methods translate
//and grow. Provide any abstract methods that you need for the implementation,
//so that you can mix in the trait like this:
//val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
//egg.translate(10, -10)
//egg.grow(10, 20)

import java.awt.geom.RectangularShape

trait RectangleLike {
  this: RectangularShape =>

  def translate(dx: Double, dy:Double): Unit = {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }

  def grow(h: Double, v: Double): Unit = {
    setFrame(getX -h, getY - v, getWidth + 2*h, getHeight + 2*v)
  }

}
