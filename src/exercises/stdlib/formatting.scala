object formatting extends App {
  val s = "Hello World"

  "Application %s".format(s)

  val a = 'a'
  val b = 'B'

  "%c".format(a)
  "%c".format(b)

  val c = 'a' //unicode for a
  val d = '\u0061' //octal for a
  val e = '\"'
  val f = '\\'

  "%c".format(c)
  "%c".format(d)
  "%c".format(e)
  "%c".format(f)
}