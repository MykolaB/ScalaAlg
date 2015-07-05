package org.mykola.scala.odersky.examples.generics

/**
 * Created by Mykola on 04.07.2015.
 */
abstract class Stack[+A] {
  def push[B >: A](x: B): Stack[B] = new NonEmptyStack[B](x, this)
  def isEmpty: Boolean
  def top: A
  def pop: Stack[A]

}

object EmptyStack extends Stack[Nothing] {
  override def isEmpty = true
  def top = sys.error("EmptyStack.pop")
  def pop = sys.error("EmptyStack.pop")
}

class NonEmptyStack[+A](elem: A, rest: Stack[A]) extends Stack[A] {
  override def isEmpty = false
  def top = elem
  def pop = rest
}

object Stack {
  def isPrefix[A](p: Stack[A], s: Stack[A]): Boolean = {
    p.isEmpty ||
      p.top == s.top && isPrefix(p.pop, s.pop)
  }
}

object StackTest {
  def main(args: Array[String]) {
    val y = EmptyStack.push("abc").push(new AnyRef())

    println(y.top)
  }
}