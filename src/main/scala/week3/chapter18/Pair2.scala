package week3.chapter18
//2. Define a mutable class Pair[T] with a method swap that swaps the components
//of the pair.
class Pair2[T](var first: T, var second:T) {
  def swap():Unit = {
    val aux = first
    first =second
    second = aux
  }

}
