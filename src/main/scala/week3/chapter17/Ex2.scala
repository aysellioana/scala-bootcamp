package week3.chapter17

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.*

//ex2: Write a function doInOrder that, given two functions f: T => Future[U] and g: U
//=> Future[V], produces a function T => Future[U] that, for a given t, eventually
//  yields g(f(t)).

object Ex2 {
  def doInOrder[T, U, V](f: T => Future[U], g: U => Future[V])
                        (implicit ec: ExecutionContext): T => Future[V] = {
    (t: T) => f(t).flatMap(g)
  }

  def f(x: Int): Future[Double] = Future {
    println(s"f($x) running on: " + Thread.currentThread.getName)
    x * 2.5
  }

  def g(y: Double): Future[String] = Future {
    println(s"g($y) running on: " + Thread.currentThread.getName)
    s"Valoare finală: $y"
  }

  def main(args: Array[String]): Unit = {
    println("Start program")

    val composed = doInOrder(f, g)
    val rezultat = composed(4)

    val finalValue = Await.result(rezultat, 5.seconds)
    println(finalValue)
  }
}
