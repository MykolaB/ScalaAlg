package org.mykola.scala.odersky.examples.lists

/**
 * Created by Mykola on 05.07.2015.
 */
object PrimePairs {
  def produce(n: Int): List[(Int, Int)] = {
    List.range(1, n)
      .flatMap(i => List.range(1, i).map(x => (i, x)))
      .filter(pair => Prime.isPrime(pair._1 + pair._2))
  }

  def main(args: Array[String]) {
    println(produce(23))
  }
}
