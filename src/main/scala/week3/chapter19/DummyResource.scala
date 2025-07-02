package week3.chapter19
//ex7: Implement a method that receives an object of any class that has a method
//def close(): Unit
//together with a function that processes that object. Call the function and invoke
//the close method upon completion, or when any exception occurs.
def using[A <: AutoCloseable, B](resource: A)(block: A => B): B = {
  try {
    block(resource)
  } finally {
    resource.close()
  }
}

class DummyResource extends AutoCloseable {
  def doWork(): Unit = println("Working (Java-style resource)...")
  override def close(): Unit = println("Closed (Java-style resource).")
}

object TestUsing extends App {
  val result = using(new DummyResource) { r =>
    r.doWork()
    "Finished"
  }
  println(s"Result: $result")
}
