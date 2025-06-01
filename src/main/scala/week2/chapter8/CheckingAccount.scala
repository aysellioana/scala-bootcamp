package week2.chapter8

import week2.chapter8.BankAccount

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  override def deposit(amount: Double): Double = {
    super.deposit(amount - 1)
  }

  override def withdraw(amount: Double): Double ={
    super.withdraw(amount - 1)
  } 
}
