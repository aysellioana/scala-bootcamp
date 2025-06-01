package week2.chapter8

//ex1:Extend the following BankAccount class to a CheckingAccount class that charges $1
//for every deposit and withdrawal.
//class BankAccount(initialBalance: Double) {
// private var balance = initialBalance
// def currentBalance = balance
// def deposit(amount: Double) = { balance += amount; balance }
// def withdraw(amount: Double) = { balance -= amount; balance }
//}

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance;

  def currentBalance = balance

  def deposit(amount: Double): Double = {
    balance += amount

    balance
  }

  def withdraw(amount:Double) = {
    balance +=amount

    balance
  }

}
