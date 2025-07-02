package week3.chapter19
//ex5: Consider the type alias
// type NetworkMember = n.Member forSome { val n: Network }
//and the function
//def process(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
//How does this differ from the process function in Section 19.8, “Existential
//Types,” on page 286?
import scala.collection.mutable.ArrayBuffer

class NetworkP {
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

type NetworkMember = NetworkP#Member

def processP(m1: NetworkMember, m2: NetworkMember): (NetworkMember, NetworkMember) = {
  println(s"Processing (Permissive): $m1 and $m2")
  (m1, m2)
}

object TestPermissive extends App {
  val net1 = new NetworkP
  val net2 = new NetworkP

  val alice = net1.join("Alice")
  val bob = net2.join("Bob")

  processP(alice, bob)
}
