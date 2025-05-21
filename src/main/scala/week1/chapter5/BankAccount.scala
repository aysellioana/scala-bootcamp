package week1.chapter5
//ex2:Write a class BankAccount with methods deposit and withdraw, and a read-only
//property balance.
class BankAccount {
  private var _balance: Double = 0.0

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      _balance += amount
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= _balance) {
      _balance -= amount
    } else {
      println("Insufficient funds or invalid amount.")
    }
  }

  def balance: Double = _balance // read-only
}
