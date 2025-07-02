package week3.chapter21

//ex 10. Generalize the average method in Section 21.8, “Type Classes,” on page 331 to
//a Seq[T].
trait NumberLike[T] {
  def plus(x: T, y: T): T
  def divideBy(x: T, n: Int): T
}

object NumberLike {
  implicit object NumberLikeDouble extends NumberLike[Double] {
    def plus(x: Double, y: Double) = x + y
    def divideBy(x: Double, n: Int) = x / n
  }

  implicit object NumberLikeBigDecimal extends NumberLike[BigDecimal] {
    def plus(x: BigDecimal, y: BigDecimal) = x + y
    def divideBy(x: BigDecimal, n: Int) = x / n
  }
}
