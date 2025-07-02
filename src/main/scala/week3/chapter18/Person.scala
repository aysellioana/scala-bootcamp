package week3.chapter18

class Person(val name: String) {
  override def toString: String = s"Person($name)"
}
class Student(name: String) extends Person(name)