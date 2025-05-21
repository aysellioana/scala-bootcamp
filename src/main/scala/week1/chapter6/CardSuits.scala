package week1.chapter6

object CardSuits extends Enumeration {
  type CardSuits = Value

  val Spades   = Value("ß") // ♠
  val Hearts   = Value("®") // ♥
  val Diamonds = Value("©") // ♦
  val Clubs    = Value("™") // ♣
}
