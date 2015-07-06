package org.mykola.scala.odersky.examples.for_comprehensions

/**
 * Created by Mykola on 06.07.2015.
 */
object Queens {
  def queens(n: Int): List[List[Int]] = {
    def placeQueens(k: Int): List[List[Int]] = {
      if (k == 0) List(List())
      else for {queens <- placeQueens(k - 1)
                column <- List.range(1, n + 1)
        if (isSafe(column, queens, 1))}
        yield column :: queens
    }
    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int], delta: Int): Boolean = {
    def checkDanger(queen: (Int, Int), newQueen: (Int, Int)): Boolean = {
      if (queen._2 == newQueen._2) true
      else (math.abs(queen._1 - newQueen._1) == math.abs(queen._2 - newQueen._2))
    }

    val newQueenRow = queens.size + delta;

    queens.zipWithIndex.map{case (x, y) => (queens.size - y, x)}.forall{case(x, y) => !checkDanger((x, y), (newQueenRow, col))}
  }

  def main(args: Array[String]) {
    val res = List.range(1, 13).map(x => (x, queens(x).size))
    println(res)
  }
}
