package week3.chapter21

object FactorialOps {
  implicit class FactorialInt(val n: Int) extends AnyVal {
    def ! : Int = {
      require(n >= 0, "Factorial is not defined for negative numbers.")
      if (n == 0 || n == 1) 1
      else (2 to n).product
    }
  }
}
