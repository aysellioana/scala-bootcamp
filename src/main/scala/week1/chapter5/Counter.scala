package week1.chapter5
//ex1:Improve the Counter class in Section 5.1, “Simple Classes and Parameterless
//Methods,” on page 55 so that it doesn’t turn negative at Int.MaxValue.
class Counter {
  private var value = 0

  def increment(): Unit = {
    if (value < Int.MaxValue) {
      value += 1
    } else {
      println("Maximum value reached.")
    }
  }

  def current: Int = value
}