package week3.chapter19

import scala.collection.mutable.ArrayBuffer

class Network {
  outer =>

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member]

    override def equals(other: Any): Boolean = other match {
      case that: outer.Member =>
        this.name == that.name
      case _ => false
    }

    override def hashCode(): Int = {
      31 * outer.hashCode() + name.hashCode
    }

    override def toString: String = s"Member($name)"
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}
