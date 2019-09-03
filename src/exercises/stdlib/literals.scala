object literals extends App {
  val a = true
  val b = false
  val c = 1 > 2
  val d = 1 < 2
  val e = a == c
  val f = b == d

  val a = 2
  val b = 31
  val c = 0x30F // 783
  val e = 0
  val f = -2
  val g = -31
  val h = -0x30F // -783

  // Long literals are 64-bit.
  val a = 2L
  val b = 31L
  val c = 0x30FL
  val e = 0L
  val f = -2l
  val g = -31L
  val h = -0x30FL

  val a = 3.0
  val b = 3.00
  val c = 2.73
  val d = 3f
  val e = 3.22d
  val f = 93e-9 // 9.3E-8
  val g = 93E-9 // 9.3E-8
  val h = 0.0
  val i = 9.23E-9D // 9.23E-9

  val a = 'a'
  val b = 'B'

  a.toString // "a"
  b.toString // 'B"

  val c = 'a' //unicode for a

  c.toString // "a"

  val d = '\141' //octal for a
  d.toString

  val e = '\"'
  val f = '\\'

  e.toString
}