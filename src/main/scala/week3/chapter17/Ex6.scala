package week3.chapter17

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.io.StdIn

//ex6:6. Write a method
//Future[T] repeat(action: => T, until: T => Boolean)
//that asynchronously repeats the action until it produces a value that is
//accepted by the until predicate, which should also run asynchronously. Test
//with a function that reads a password from the console, and a function that
//simulates a validity check by sleeping for a second and then checking
//that the password is "secret". Hint: Use recursion.

object Ex6 {

  def repeat[T](action: => T, until: T => Boolean): Future[T] = {
    Future(action).flatMap { result =>
      Future(until(result)).flatMap {
        case true  => Future.successful(result)
        case false => repeat(action, until)
      }
    }
  }

  def readPassword(): String = {
    println("Enter password:")
    StdIn.readLine()
  }

  def checkPassword(pwd: String): Boolean = {
    println(s"Checking password '$pwd'...")
    Thread.sleep(1000)
    pwd == "secret"
  }

  def main(args: Array[String]): Unit = {
    println("Starting Ex6 (repeat password check)")

    val future = repeat(readPassword(), checkPassword)

    val result = Await.result(future, Duration.Inf)
    println(s"Access granted with password: '$result'")
  }
}