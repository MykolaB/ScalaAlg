package org.mykola.scala.odersky.examples.for_comprehensions

/**
 * Created by NBiletskiy on 7/9/2015.
 */

case class Book(title: String, authors: List[String])

object Books {
  val books: List[Book] = List(
    Book("Structure and Interpretation of Computer Programs",
      List("Abelson, Harold", "Sussman, Gerald J.")),
    Book("Principles of Compiler Design",
      List("Aho, Alfred", "Ullman, Jeffrey")),
    Book("Programming in Modula2",
      List("Wirth, Niklaus")),
    Book("Introduction to Functional Programming",
    List("Bird, Richard")),
  Book("The Java Language Specification",
    List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")));

  def main(args: Array[String]) {
    println(for (b <- books; if (b.title indexOf "Program") > 0)
      yield b.title)
  }
}
