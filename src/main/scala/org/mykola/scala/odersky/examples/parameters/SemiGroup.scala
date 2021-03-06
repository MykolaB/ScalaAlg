package org.mykola.scala.odersky.examples.parameters

/**
 * Created by NBiletskiy on 7/13/2015.
 */
abstract class SemiGroup[A] {
  def add(x: A, y: A): A
}

abstract class Monoid[A] extends SemiGroup[A] {
  def unit: A

  implicit object stringMonoid extends Monoid[String] {
    def add(x: String, y: String): String = x.concat(y)

    def unit: String = ""
  }

  implicit object intMonoid extends Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y

    def unit: Int = 0
  }

}

object Test {

  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail)(m))

  def main(args: Array[String]) {
    //println (sum(List("a", "bc", "def")))
  }
}