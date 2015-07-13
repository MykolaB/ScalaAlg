package org.mykola.scala.odersky.examples.streams

import org.mykola.scala.odersky.examples.lists.Prime

/**
 * Created by NBiletskiy on 7/10/2015.
 */
object Test {

  def range(start: Int, end: Int): Stream[Int] = {
    if (start >= end) Stream.empty
    else Stream.cons(start, range(start + 1, end))
  }

  def main(args: Array[String]) {
    println((Stream.range(1000, 10000) filter Prime.isPrime) (2))
  }
}
