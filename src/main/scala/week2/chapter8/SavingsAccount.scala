package week2.chapter8

import week2.chapter8.BankAccount
//ex2:Extend the BankAccount class of the preceding exercise into a class SavingsAccount
//that earns interest every month (when a method earnMonthlyInterest is called)
//and has three free deposits or withdrawals every month. Reset the transaction
//count in the earnMonthlyInterest method.

class SavingsAccount(initialBalance: Double, val interestRate:Double) extends BankAccount(initialBalance){
  private var freeTransactions = 3

  override def deposit(amount: Double): Double = {
    if(freeTransactions >0){
      freeTransactions -=1
      super.deposit(amount)
    }else{
      super.deposit(amount-1)
    }
  }

  override def withdraw(amount: Double): Double = {
    if(freeTransactions >0){
      freeTransactions -=1
      super.deposit(amount)
    }else{
      super.withdraw(amount-1)
    }
  }

  def earnMonthlyInterest(): Unit = {
    val interest = currentBalance * interestRate /100
    super.deposit(interest)
    freeTransactions =3
  }


}
