package org.mykola.scala.odersky.examples.expressions

import math.abs
import math.pow

/**
 * Created by Mykola on 03.07.2015.
 */
object NewtonSquareRoot {

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    }
    def improve(guess: Double): Double = (guess + x / guess) / 2
    def isGoodEnough(guess: Double): Boolean = abs(pow(guess, 2) - x) < 0.001

    sqrtIter(1.0)
  }

}

object Calc {
  def main(args: Array[String]) {
    println(NewtonSquareRoot.sqrt(0.00001))
    println(NewtonSquareRoot.sqrt(1000000000))
  }
}
