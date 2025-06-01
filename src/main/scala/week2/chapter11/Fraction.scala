package week2.chapter11
//ex3:Implement the Fraction class with operations + - * /. Normalize fractions, for
//example, turning 15/–6 into –5/2. Divide by the greatest common divisor,
//like this:
//class Fraction(n: Int, d: Int) {
// private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
// private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);
// override def toString = s"$num/$den"
// def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
// def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
// ...
//}

class Fraction(n: Int, d: Int) {
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) math.abs(a) else gcd(b, a % b)
  }

  private val sign = if (d < 0) -1 else 1
  private val g = gcd(n, d)
  private val num = sign * n / g
  private val den = sign * d / g


  def +(other: Fraction): Fraction = {
    new Fraction(this.num * other.den + other.num * this.den, this.den * other.den)
  }


  def -(other: Fraction): Fraction = {
    new Fraction(this.num * other.den - other.num * this.den, this.den * other.den)
  }


  def *(other: Fraction): Fraction = {
    new Fraction(this.num * other.num, this.den * other.den)
  }


  def /(other: Fraction): Fraction = {
    new Fraction(this.num * other.den, this.den * other.num)
  }


  override def toString: String = s"$num/$den"
}