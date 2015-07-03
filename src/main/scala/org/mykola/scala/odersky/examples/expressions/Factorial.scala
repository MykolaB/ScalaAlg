package org.mykola.scala.odersky.examples.expressions

/**
 * Created by Mykola on 03.07.2015.
 */
object Factorial {
  def factorial(n: Int): Int = {
    def factorialWithAcc(acc: Int, n: Int): Int = {
      if (n == 1) return acc
      else factorialWithAcc(acc * n, n - 1)
    }

    factorialWithAcc(1, n)
  }

  def main(args: Array[String]) {
    println(factorial(10))
  }
}

