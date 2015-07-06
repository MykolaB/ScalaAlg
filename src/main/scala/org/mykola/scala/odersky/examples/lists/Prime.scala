package org.mykola.scala.odersky.examples.lists

/**
 * Created by Mykola on 05.07.2015.
 */
object Prime {
  def isPrime(n: Int) =
    List.range(2, n).forall(x => n % x != 0)

  def main(args: Array[String]) {
    println(isPrime(81))
    println(isPrime(73))
  }
}
