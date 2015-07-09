package org.mykola.scala.odersky.examples.for_comprehensions

import org.mykola.scala.odersky.examples.lists.Prime

/**
 * Created by Mykola on 09.07.2015.
 */
object Misc {

  def flatten[A](xss: List[List[A]]): List[A] =
    (xss :\ (Nil: List[A])) ((xs,ys) => xs ::: ys)

  def flatten1[A](xss: List[List[A]]): List[A] =
    for (x <- xss; y <- x) yield y

  def main(args: Array[String]) {
    val l = List(List(1,2), List(4,3))
    println(flatten1(l))
  }
}
