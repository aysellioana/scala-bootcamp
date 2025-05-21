package week1

//ex2: The signum of a number is 1 if the number is positive, –1 if it is negative, and
//0 if it is zero. Write a function that computes this value

def signum(x: Int): Int = {
  if (x > 0) 1
  else if (x < 0) -1
  else 0
}

//ex5: Write a procedure countdown(n: Int) that prints the numbers from n to 0
def countdown(n: Int): Unit = {
  for (i <- n to 0 by -1) {
    println(i)
  }
}

//ex6: Write a for loop for computing the product of the Unicode codes of all letters
//in a string. For example, the product of the characters in "Hello" is 9415087488L.
def unicodeProduct(s: String): Long = {
  var product: Long = 1L
  for (ch <- s) {
    product *= ch.toLong
  }
  product
}

//ex7: Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
//Scaladoc.
def unicodeProductVar2(s: String): Long = {
  s.foldLeft(1L)((prod, ch) => prod * ch.toLong)
}

//ex8: Write a function product(s : String) that computes the product, as described
//in the preceding exercises.
def product(s: String): Long = {
  var result = 1L
  for (c <- s) {
    result *= c.toLong
  }
  result
}

//ex9:  Make the function of the preceding exercise a recursive function.
def productRec(s: String): Long = {
  if (s.isEmpty) 1L
  else s.head.toLong * product(s.tail)
}

//ex10: 10. Write a function that computes xn
//, where n is an integer. Use the following
//recursive definition:
//• xn
// = y · y if n is even and positive, where y = xn / 2.
//• xn
// = x · xn – 1 if n is odd and positive.
//• x0
// = 1.
//• xn
// = 1 / x–n
// if n is negative.
//Don’t use a return statement.

def power(x: Double, n: Int): Double = {
  if (n == 0) 1.0
  else if (n > 0) {
    if (n % 2 == 0) {
      val y = power(x, n / 2)
      y * y
    } else {
      x * power(x, n - 1)
    }
  } else {
    1 / power(x, -n)
  }
}

object Chapter2 {
  def main(args: Array[String]): Unit = {
    println("ex 2")
    println(signum(5))
    println(signum(-3))
    println(signum(0))


    //ex3: Come up with one situation where the assignment x = y = 1 is valid in Scala.
    //(Hint: Pick a suitable type for x.)
    var y = 0
    val x: Int = {
      y = 1;
      y
    }
    println()
    println("ex3")
    println(s"x = $x")
    println(s"y = $y")

    //ex4:  Write a Scala equivalent for the Java loop
    //for (int i = 10; i >= 0; i--) System.out.println(i);
    println()
    println("ex4")
    for (i <- 10 to 0 by -1) {
      println(i)
    }

    println()
    println("ex5")
    countdown(10)

    println()
    println("ex6")
    val result = unicodeProduct("Hello")
    println(result)

    println()
    println("ex7")
    val result2 = unicodeProductVar2("Hello")
    println(result2)

    println()
    println("ex8")
    val resultProduct = product("Product")
    println(resultProduct)

    println()
    println("ex9")
    val resultProductRec = productRec("Product")
    println(resultProductRec)

    println()
    println("ex10")
    println(power(2, 3))
    println(power(2, -2))
    println(power(5, 0))
    println(power(3, 4))
  }
}