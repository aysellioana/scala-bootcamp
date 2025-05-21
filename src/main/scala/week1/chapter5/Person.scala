package week1.chapter5
//ex5:In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
//on page 55, provide a primary constructor that turns negative ages to 0.


class Person(inputAge: Int) {
  val age: Int = if (inputAge < 0) 0
  else inputAge
}
