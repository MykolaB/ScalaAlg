package org.mykola.scala.odersky.examples.functions

/**
 * Created by Mykola on 04.07.2015.
 */

import math.abs

object FixedPoints {
  val tolerance = 0.0000001

  private def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => scala.Double)(x: Double) = (x + f(x)) / 2

  def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y)) (1.0)

  def cubeRoot(x: Double) = fixedPoint(averageDamp(y => x / (y * y) )) (1.0)

  def main(args: Array[String]) {
    println(cubeRoot(1000))
  }

}

