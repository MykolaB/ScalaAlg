package org.mykola.scala.odersky.examples

/**
 * Created by NBiletskiy on 7/3/2015.
 */
object QuickSort {
  def sort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        sort(xs filter (pivot >)),
            xs filter (pivot ==),
        sort(xs filter(pivot <))
      )
    }
  }
}

object Sorter {
  def main(args: Array[String]) {
    println(QuickSort.sort(Array(4,7,2,89,0,189)).mkString(","));
  }
}
