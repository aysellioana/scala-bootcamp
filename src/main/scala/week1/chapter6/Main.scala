package week1.chapter6

import CardSuits._

object Main {
  def main(args: Array[String]): Unit = {
    println("ex1")
    println("10 inches = " + Conversions.inchesToCentimeters(10) + " cm")
    println("5 gallons = " + Conversions.gallonsToLiters(5) + " liters")
    println("3 miles = " + Conversions.milesToKilometers(3) + " km")


    println()
    println("ex2")
    println("10 inches = " + InchesToCentimeters.convert(10) + " cm")
    println("5 gallons = " + GallonsToLiters.convert(5) + " liters")
    println("3 miles = " + MilesToKilometers.convert(3) + " km")

    println()
    println("ex4")
    val point = Point(3, 4)
    println(s"Point coordinates: (${point.x}, ${point.y})")

    println()
    println("ex6")
    for (suit <- CardSuits.values) {
      println(suit)
    }

    val mySuit = Hearts

    println("My suit is: " + mySuit)
  }
}
