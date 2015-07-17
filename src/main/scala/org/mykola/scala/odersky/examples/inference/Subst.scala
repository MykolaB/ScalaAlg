package org.mykola.scala.odersky.examples.inference

/**
 * Created by NBiletskiy on 7/17/2015.
 */

abstract class Subst extends Function1[Type, Type] {
  def lookup(x: Tyvar): Type

  def apply(t: Type): Type = t match {
    case tv @ Tyvar(a) => val u = lookup(tv); if (t == u) t else apply(u)
    case Arrow(t1, t2) => Arrow(apply(t1), apply(t2))
    case Tycon(k, ts) => Tycon(k, ts map apply)
  }

  def extend(x: Tyvar, t: Type) = new Subst {
    def lookup(y: Tyvar): Type = if (x == y) t else Subst.this.lookup(y)
  }
}

//val emptySubst = new Subst{ def lookup(t: Tyva)}