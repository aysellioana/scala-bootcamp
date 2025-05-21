package week1.chapter6

abstract class UnitConversion {
  def convert(value: Double): Double
}

object InchesToCentimeters extends UnitConversion {
  def convert(value: Double): Double = value * 2.54
}

object GallonsToLiters extends UnitConversion {
  def convert(value: Double): Double = value * 3.78541
}

object MilesToKilometers extends UnitConversion {
  def convert(value: Double): Double = value * 1.60934
}