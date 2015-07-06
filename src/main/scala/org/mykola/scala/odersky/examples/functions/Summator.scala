package org.mykola.scala.odersky.examples.functions

/**
 * Created by Mykola on 03.07.2015.
 */
object Summator {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
      if (a > b) 0 else f(a) + sum(f)(a + 1, b)
  }

  def sumT(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if (a > b) result
      else iter(a + 1, result + f(a))
    }
    iter(a, 0)
  }

  def sumInts = sumT(x => x)(_, _)
  def sumSquares = sumT(x => x * x)(_, _)

  def main(args: Array[String]) {
    println(sumSquares(1, 3))
  }
}
