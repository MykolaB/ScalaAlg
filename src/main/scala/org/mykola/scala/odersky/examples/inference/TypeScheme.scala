package org.mykola.scala.odersky.examples.inference

/**
 * Created by NBiletskiy on 7/17/2015.
 */
case class TypeScheme(tyvars: List[Tyvar], tpe: Type) {

  val emptySubst = new Subst {
    override def lookup(t: Tyvar): Type = t
  }

  def newInstance: Type = {
    (emptySubst /: tyvars) ((s, tv) => s.extend(tv, new Tyvar("hi"))) (tpe)
  }
}
