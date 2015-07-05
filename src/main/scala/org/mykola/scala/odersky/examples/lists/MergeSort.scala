package org.mykola.scala.odersky.examples.lists

/**
 * Created by Mykola on 04.07.2015.
 */
object MergeSort {
  def sort[A](less: (A, A) => Boolean )(xs: List[A]): List[A] = {
    def merge(xs1: List[A], xs2: List[A]): List[A] = {
      if (xs1.isEmpty) xs2
      else if (xs2.isEmpty) xs1
      else if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2)
      else xs2.head :: merge(xs1, xs2.tail)
    }

    val n = xs.length / 2
    if (n == 0) xs
    else merge(sort (less)(xs take n), sort (less)(xs drop n))
  }

  def main(args: Array[String]) {
    println(sort((x: Int, y: Int) => x > y)(List(9,7,10,1)))
  }
}
