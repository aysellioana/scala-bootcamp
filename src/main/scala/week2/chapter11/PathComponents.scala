package week2.chapter11

import java.nio.file.Path
//ex 9: Define an object PathComponents with an unapply operation class that extracts
//the directory path and file name from an java.nio.file.Path. For example, the
//file /home/cay/readme.txt has directory path /home/cay and file name readme.txt.

object PathComponents {
  def unapply(path: Path): Option[(Path, Path)] = {
    val parent = path.getParent
    val file = path.getFileName
    if (parent != null && file != null)
      Some((parent, file))
    else
      None
  }
}