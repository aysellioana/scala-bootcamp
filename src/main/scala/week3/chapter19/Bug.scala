package week3.chapter19
//ex1: Implement a Bug class modeling a bug that moves along a horizontal line. The
//move method moves in the current direction, the turn method makes the bug
//turn around, and the show method prints the current position. Make these
//methods chainable. For example,
//bugsy.move(4).show().move(6).show().turn().move(5).show()
//should display 4 10 5.
class Bug {
  private var position: Int = 0
  private var direction: Int = 1

  def move(steps: Int): Bug = {
    position += direction * steps
    this
  }
  def turn(): Bug = {
    direction = -direction
    this
  }
  def show(): Bug = {
    println(position)
    this
  }

}
