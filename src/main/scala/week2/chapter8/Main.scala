package week2.chapter8

import week2.chapter8.{CheckingAccount, SavingsAccount}

object Main extends App{
  val account = new CheckingAccount(100)

  account.deposit(50)
  account.withdraw(30)

  println(account.currentBalance)

  val savings = new SavingsAccount(1000, 1.0)
  savings.deposit(100)
  savings.deposit(350)
  savings.withdraw(40)
  savings.withdraw(170)
  println(savings.currentBalance)
  savings.earnMonthlyInterest()
  println((savings.currentBalance))

  println()
  println("Ex 4")
  val book =SimpleItem(25.9, "Scala Bootcamp")
  val pen = SimpleItem(6.0, "Pen")

  val bundle = Bundle.empty
    .addItem(book)
    .addItem(pen)

  println(s"Total price :${bundle.price}")
  println(s"Description :${bundle.description}")

  println()
  println("Ex 5")
  val event = new LabelPoint("Black Thursday", 1939, 173.08)

  println(s"Label: ${event.label}")
  println(s"X: ${event.x}")
  println(s"Y: ${event.y}")


  println()
  println("Ex 6")
  val circle = new Circle(new Point(0, 0), 5)
  val rect = new Rectangle(new Point(0, 10), 10, 4)

  println(s"Circle center: ${circle.centerPoint}")
  println(s"Rectangle center: ${rect.centerPoint}")

}
