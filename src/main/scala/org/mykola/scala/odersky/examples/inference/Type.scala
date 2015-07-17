package org.mykola.scala.odersky.examples.inference

/**
 * Created by NBiletskiy on 7/16/2015.
 */
sealed class Type {

}

case class Tyvar(a: String) extends Type {
  override def toString = a
}

case class Arrow(t1: Type, t2: Type) extends Type {
  override def toString = "(" + t1 + "->" + t2 + ")"
}

case class Tycon(k: String, ts: List[Type]) extends Type {
  override def toString =
    k + (if(ts.isEmpty) "" else ts.mkString("[", ",", "]"))
}

object typeInfer {
  private var n: Int = 0
  def newTyvar(): Type = {n += 1; Tyvar("a" + n)}
}
