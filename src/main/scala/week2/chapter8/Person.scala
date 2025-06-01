package week2.chapter8
//ex8: Compile the Person and SecretAgent classes in Section 8.6, “Overriding Fields,”
//on page 95 and analyze the class files with javap. How many name fields are
//there? How many name getter methods are there? What do they get? (Hint:
//Use the -c and -private options.)

class Person(val name: String) {
  override def toString = s"${getClass.getName}[name=$name]"
}