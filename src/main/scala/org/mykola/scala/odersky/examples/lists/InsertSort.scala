package org.mykola.scala.odersky.examples.lists

/**
 * Created by Mykola on 04.07.2015.
 */
object InsertSort {
  def sort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert(x, sort(xs1))
  }


  private def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  def main(args: Array[String]) {
    println(sort(List(9, 7, 11)))
  }
}

