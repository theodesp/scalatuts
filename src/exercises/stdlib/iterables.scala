object iterables extends App {
  val list = List(3, 5, 9, 11, 15, 19, 21)
  val it = list.iterator
  if (it.hasNext) {
    it.next // 3
  }

  val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
  val it = list grouped 3

  it.next() // List(3, 5, 9)
  it.next() // List(11, 15, 19)
  it.next() // List(21, 24, 32)

  val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
  val it = list sliding 3

  it.next() // List(3, 5, 9)
  it.next() // List(5, 9, 11)
  it.next() // List(9, 11, 15)

  val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
  val it = list sliding (3, 3)

  it.next()
  it.next()
  it.next()

  val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
  (list takeRight 3) // List(21, 24, 32)

  val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
  (list dropRight 3) // List(3, 5, 9, 11, 15, 19)

  val xs = List(3, 5, 9)
  val ys = List("Bob", "Ann", "Stella")
  (xs zip ys) // List((3,Bob), (5,Ann), (9,Stella))

  val xs = List(3, 5, 9)
  val ys = List("Bob", "Ann")
  (xs zip ys) // List((3,Bob), (5,Ann))

  val xs = List(3, 5, 9)
  val ys = List("Bob", "Ann")
  (xs zipAll (ys, -1, "?")) // List((3,Bob), (5,Ann), (9,?))

  val xt = List(3, 5)
  val yt = List("Bob", "Ann", "Stella")
  (xt zipAll (yt, -1, "?"))

  val xs = List("Manny", "Moe", "Jack")
  xs.zipWithIndex // List((Manny,0), (Moe,1), (Jack,2))

  val xs = List("Manny", "Moe", "Jack")
  val ys = List("Manny", "Moe", "Jack")
  (xs sameElements ys) // true

  val xt = List("Manny", "Moe", "Jack")
  val yt = List("Manny", "Jack", "Moe")
  (xt sameElements yt) // false

  val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
  val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
  (xs1 sameElements ys1) //  true

  val xt1 = Set(1, 2, 3)
  val yt1 = Set(3, 2, 1)
  (xt1 sameElements yt1)
}