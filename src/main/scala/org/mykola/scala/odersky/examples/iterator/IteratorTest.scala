package org.mykola.scala.odersky.examples.iterator

/**
 * Created by NBiletskiy on 7/13/2015.
 */
object IteratorTest {
  def fromArray[A](xs: Array[A]) = new Iterator[A] {
    private var i = 0;
    def hasNext: Boolean =
      i < xs.length
    def next: A =
      if (i < xs.length) {val x = xs(i); i += 1; x}
      else sys.error("next on empty iterator")
  }

  def main(args: Array[String]) {
    val a = Array(1,2)
    val it = Iterator.range(1,10)

    for (x <- it) println(x)

  }
}
