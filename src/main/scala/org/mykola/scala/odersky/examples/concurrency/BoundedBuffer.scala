package org.mykola.scala.odersky.examples.concurrency

import scala.reflect.ClassTag

/**
 * Created by NBiletskiy on 7/17/2015.
 */
class BoundedBuffer[A: ClassTag] (N: Int) {
  var in = 0
  var out = 0
  var n = 0
  var elems = new Array[A](N)

  def put(x: A) = synchronized {
    while (n >= N) wait()
    elems(in) = x; in = (in + 1) % N; n = n + 1
    if (n == 1) notifyAll()
  }

  def get: A = synchronized {
    while (n == 0) wait()
    val x = elems(out); out = (out + 1) % N; n = n - 1
    if (n == N - 1) notifyAll()
    x
  }
}

object Test {
  def spawn(p: => Unit) {
    val t = new Thread() {override def run() = p}
    t.start()
  }

  def main(args: Array[String]) {
    val buf = new BoundedBuffer[String](10)
    spawn {while (true) {val s = "New string"; buf.put(s)}}
    spawn {while (true) {val s = buf.get; println(s)}}
  }
}
