package week3.chapter17

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

//ex5:5. Write a function that receives a sequence of futures and returns a future that
//eventually yields a sequence of all results.

object Ex5 {

  def sequenceFutures[T](futures: Seq[Future[T]])
                        (implicit ec: ExecutionContext): Future[Seq[T]] = {
    Future.sequence(futures)
  }

  def asyncDouble(x: Int): Future[Int] = Future {
    println(s"Doubling $x on thread: ${Thread.currentThread.getName}")
    Thread.sleep(500)
    x * 2
  }

  def main(args: Array[String]): Unit = {
    println("Starting Ex5 (sequence of futures)")

    val inputs = Seq(1, 2, 3, 4)
    val futureList = inputs.map(asyncDouble)

    val allResults: Future[Seq[Int]] = sequenceFutures(futureList)

    val result = Await.result(allResults, 5.seconds)
    println(s"Final result: $result")
  }
}