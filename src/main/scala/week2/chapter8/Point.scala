package week2.chapter8
//ex 5: Design a class Point whose x and y coordinate values can be provided in a
//constructor. Provide a subclass LabeledPoint whose constructor takes a label
//value and x and y coordinates, such as
//new LabeledPoint("Black Thursday", 1929, 230.07)
class Point(val x: Double, val y: Double) {
  override def toString: String = s"($x, $y)"
}
