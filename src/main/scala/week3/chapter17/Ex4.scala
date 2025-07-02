package week3.chapter17

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

//ex4: Write a function doTogether that, given two functions f: T => Future[U] and
//g: U => Future[V], produces a function T => Future[(U, V)], running the two
//computations in parallel and, for a given t, eventually yielding (f(t), g(t)).

object Ex4 {

  def doTogether[T, U, V](f: T => Future[U], g: T => Future[V])
                         (implicit ec: ExecutionContext): T => Future[(U, V)] = {
    (t: T) =>
      val futureU = f(t)
      val futureV = g(t)
      for {
        u <- futureU
        v <- futureV
      } yield (u, v)
  }

  def f(x: Int): Future[String] = Future {
    println(s"f($x) running on thread: ${Thread.currentThread.getName}")
    Thread.sleep(1000)
    s"F result: ${x * 2}"
  }

  def g(x: Int): Future[Double] = Future {
    println(s"g($x) running on thread: ${Thread.currentThread.getName}")
    Thread.sleep(1000)
    x * 2.5
  }

  def main(args: Array[String]): Unit = {
    println("Starting Ex4 (doTogether)")

    val composed = doTogether(f, g)

    val resultFuture = composed(4)

    val (u, v) = Await.result(resultFuture, 5.seconds)
    println(s"Final parallel result: ($u, $v)")
  }
}
