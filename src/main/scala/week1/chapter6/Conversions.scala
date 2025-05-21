package week1.chapter6
//ex1:Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
//milesToKilometers

object Conversions {
  def inchesToCentimeters(inches: Double): Double = inches * 2.54

  def gallonsToLiters(gallons: Double): Double = gallons * 3.78541

  def milesToKilometers(miles: Double): Double = miles * 1.60934
}
