package week3.chapter21

object PercentageOps {
  implicit class PercentageAdder(val value: Double) extends AnyVal {
    def +%(percent: Double): Double = {
      value + (value * percent / 100)
    }
  }
}
