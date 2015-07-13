package org.mykola.scala.odersky.examples.parameters

/**
 * Created by NBiletskiy on 7/13/2015.
 */
abstract class SemiGroup[A] {
  def add(x: A, y: A): A
}

abstract class Monoid[A] extends SemiGroup[A] {
  def unit: A
}

object stringMonoid extends Monoid[String] {
  def add(x: String, y: String): String = x.concat(y)
  def unit: String = ""
}

object intMonoid extends Monoid[Int] {
  def add(x: Int, y: Int): Int = x + y
  def unit: Int = 0
}