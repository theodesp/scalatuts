object sequences extends App {
  val l = List(1, 2, 3)
  val a = l.toArray

  val a = Array(1, 2, 3)
  val s = a.toSeq
  val l = s.toList

  val s = for (v ← 1 to 4) yield v
  s.toList

  val s = for (v ← 1 to 10 if v % 3 == 0) yield v
  s.toList

  val s = Seq("hello", "to", "you")
  val filtered = s.filter(_.length > 2)
  filtered // Seq("hello", "you")

  val a = Array("hello", "to", "you", "again")
  val filtered = a.filter(_.length > 3)
  filtered

  val s = Seq("hello", "world")
  val r = s map {
    _.reverse
  }

  r // List(olleh, dlrow)
}