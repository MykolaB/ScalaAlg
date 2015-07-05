package org.mykola.scala.odersky.examples.case_classes

/**
 * Created by Mykola on 04.07.2015.
 */
abstract class Expr {
  def eval: Int
  def print
}

case class Number(n: Int) extends Expr {
  def eval: Int = n
  override def print = Console.print(n)
}

case class Sum(e1: Expr, e2: Expr) extends Expr {
  override def eval: Int = e1.eval + e2.eval

  override def print: Unit = {
    Console.print("(")
    e1.print
    Console.print("+")
    e2.print
    Console.print(")")
  }
}

object ExpressionTest {
  def main(args: Array[String]) {
    val sum = Sum(Number(3), Number(8))
    val sum2 = Sum(Number(3), Number(8))
    sum.print
    println()
    println(sum.eval)
    println(sum == sum2)
  }
}