package week2.chapter11
//ex4:  Implement a class Money with fields for dollars and cents. Supply +, - operators
//as well as comparison operators == and <. For example, Money(1, 75) + Money(0,
//50) == Money(2, 25) should be true. Should you also supply * and / operators?
//Why or why not?

class Money(val dollars: Int, val cents: Int) {
  private val totalCents = dollars * 100 +cents

  def +(that: Money):Money = {
    val sum = this.totalCents + that.totalCents
    new Money(sum/100, sum%100)
  }

  def -(that:Money):Money = {
    val dif = this.totalCents - that.totalCents
    new Money(dif/100, dif%100)
  }

  def ==(that: Money):Boolean = {
    this.totalCents == that.totalCents
  }

  def <(that:Money):Boolean = {
    this.totalCents < that.totalCents
  }

  override def toString: String = {
    f"$$${dollars}.${math.abs(cents)}%02d"
  }
}
