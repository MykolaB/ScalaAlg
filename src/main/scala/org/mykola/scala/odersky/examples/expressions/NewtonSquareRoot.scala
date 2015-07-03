package org.mykola.scala.odersky.examples.expressions

import math.abs
import math.pow

/**
 * Created by Mykola on 03.07.2015.
 */
object NewtonSquareRoot {

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  private def improve(guess: Double, x: Double): Double = (guess + x / guess) / 2
  private def isGoodEnough(guess: Double, x: Double): Boolean = abs(pow(guess, 2) - x) < 0.001
}

object Calc {
  def main(args: Array[String]) {
    println(NewtonSquareRoot.sqrtIter(3, 0.00001))
    println(NewtonSquareRoot.sqrtIter(0.0000001, 0.00001))
  }
}
