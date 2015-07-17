package org.mykola.scala.odersky.examples.inference

/**
 * Created by NBiletskiy on 7/16/2015.
 */
abstract class Term {

}

case class Var(x: String) extends Term {
  override def toString = x
}

case class Lam(x: String, e: Term) extends Term {
  override def toString = "(\\" + x + "." + e + ")"
}

case class App(f: Term, e: Term) extends Term {
  override def toString = "(" + f + " " + e + ")"
}

case class Let(x: String, e: Term, f: Term) extends Term {
  override def toString = "let " + x + " = " + e + " in " + f
}


