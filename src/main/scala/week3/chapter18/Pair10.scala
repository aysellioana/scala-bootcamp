package week3.chapter18
//ex10:Given a mutable Pair[S, T] class, use a type constraint to define a swap method
//that can be called if the type parameters are the same

class Pair10[S,T](var first:S, var second:T) {
  def swap()(implicit ev:S=:=T):Unit = {
    val aux = first
    first = ev.flip(second)
    second=ev(aux)
  }

  override def toString: String = s"Pair($first, $second)"
}
