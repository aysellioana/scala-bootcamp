package week3.chapter17

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.*

//ex3. Repeat the preceding exercise for any sequence of functions of type T =>
//Future[T].

object Ex3 {
  def doInOrderSeq[T](functions: Seq[T => Future[T]])
                     (implicit ec: ExecutionContext): T => Future[T] = {
    (input: T) =>
      functions.foldLeft(Future.successful(input)) { (acc, func) =>
        acc.flatMap(func)
      }
  }

  def f1(x: Int): Future[Int] = Future {
    println(s"f1($x) running on: ${Thread.currentThread.getName}")
    x + 1
  }

  def f2(x: Int): Future[Int] = Future {
    println(s"f2($x) running on: ${Thread.currentThread.getName}")
    x * 2
  }

  def f3(x: Int): Future[Int] = Future {
    println(s"f3($x) running on: ${Thread.currentThread.getName}")
    x - 3
  }

  def main(args: Array[String]): Unit = {
    println("Start ex3")

    val functions = Seq(f1, f2, f3)
    val composed = doInOrderSeq(functions)

    val rezultat = composed(4) // (((4 + 1) * 2) - 3) = 7

    val finalValue = Await.result(rezultat, 5.seconds)
    println(s"Final result: $finalValue")
  }
}
