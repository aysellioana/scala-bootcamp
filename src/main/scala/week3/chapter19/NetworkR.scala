package week3.chapter19

package week3.chapter19

import scala.collection.mutable.ArrayBuffer

class NetworkR {
  class Member(val name: String) {
    override def toString: String = s"Member($name)"
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}

def processR[M <: NetworkR#Member](m1: M, m2: M): Unit = {
  println(s"Processing (Restrictive): $m1 and $m2")
}

object TestRestrictive extends App {
  val net1 = new NetworkR
  val net2 = new NetworkR

  val alice = net1.join("Alice")
  val bob   = net1.join("Bob")
  val charlie = net2.join("Charlie")

  processR(alice, bob)
}
