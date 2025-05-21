package week1.chapter5

object Chapter5 {
  def main(args: Array[String]): Unit = {
    println("ex1")
    val myCounter = new Counter
    myCounter.increment()
    myCounter.increment()
    myCounter.increment()

    println("Current counter value: " + myCounter.current)

    println()
    println("Ex2")
    val myAccount = new BankAccount
    myAccount.deposit(1000)
    myAccount.withdraw(200)

    println("Balance: " + myAccount.balance)

    println()
    println("Ex3")
    val time1 = new Time(9, 30)
    val time2 = new Time(14, 15)

    println("time1 is before time2: " + time1.before(time2))
    println("time2 is before time1: " + time2.before(time1))

    println()
    println("Ex4")
    val t1 = new TimeReimplement(9, 30)
    val t2 = new TimeReimplement(14, 15)
    val t3 = new TimeReimplement(9, 30)

    println(s"t1: ${t1.hours}:${t1.minutes}")
    println(s"t2: ${t2.hours}:${t2.minutes}")
    println(s"t3: ${t3.hours}:${t3.minutes}")
    println(s"t1 before t2? ${t1.before(t2)}")
    println(s"t2 before t1? ${t2.before(t1)}")
    println(s"t1 before t3? ${t1.before(t3)}")

    println()
    println("ex6")
    val person1 = new Person(25)
    val person2 = new Person(-10)

    println("p1 age: " + person1.age)
    println("p2 age: " + person2.age)

    println()
    println("ex7")
    val personV = new PersonV("Anna Popescu")
    println("First name: " + personV.firstName)
    println("Last name: " + personV.lastName)
  }
}
