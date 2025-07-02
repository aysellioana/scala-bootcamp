package week3.chapter18
//ex8: In Section 18.10, “Co- and Contravariant Positions,” on page 272, the
//replaceFirst method has a type bound. Why can’t you define an equivalent
//method on a mutable Pair[T]?
//def replaceFirst[R >: T](newFirst: R) { first = newFirst } // Error

class Pair8[+T](val first:T, val second: T) {
  def replaceFirst[R>:T](newFirst:R):Pair8[R] = {
    new Pair8[R](newFirst,second)
  }

  override def toString: String = s"Pair($first, $second)"
}
