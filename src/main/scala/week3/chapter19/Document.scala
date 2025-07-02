package week3.chapter19
//ex3:. Complete the fluent interface in Section 19.1, “Singleton Types,” on page 280
//so that one can call
//book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
object Title

object Author

class Document {
  private var title = ""
  private var author = ""
  private var useNextArgAs: Any = null

  def set(obj: Title.type): this.type = {
    useNextArgAs = Title
    this
  }

  def set(obj: Author.type): this.type = {
    useNextArgAs = Author
    this
  }

  def to(arg: String): this.type = {
    useNextArgAs match {
      case Title => title = arg
      case Author => author = arg
      case _ => throw new IllegalArgumentException("Invalid target")
    }
    useNextArgAs = null
    this
  }

  def print(): Unit = {
    println(s"Title: $title, Author: $author")
  }
}
