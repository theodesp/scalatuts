object lists extends App {
  val a = List(1, 2, 3)
  val b = List(1, 2, 3)


  val l: List[String] = Nil
  val m: List[Int] = Nil

  (a == Nil) // true
  (a eq Nil) // true

  a.headOption // Some(1)
  a.tail // List(2,3)

  val c = List(1, 3, 5, 7, 9).filterNot(v ⇒ v == 5) // remove where value is 5

  // get the length of the list
  a.length
  // reverse the list
  a.reverse

  // map a function to double the numbers over the list
  a.map { v ⇒
    v * 2
  }

  // filter any values divisible by 3 in the list
  a.filter { v ⇒
    v % 3 == 0
  }

  a.map {
    _ * 2
  }

  a.filter {
    _ % 2 == 0
  }

  a.map(_ * 2)

  a.filter(_ % 2 != 0)

  a.reduceLeft(_ + _)

  a.reduceLeft(_ * _)

  a.foldLeft(0)(_ + _)

  a.foldLeft(10)(_ + _)

  a.foldLeft(1)(_ * _)

  a.foldLeft(0)(_ * _)

  (1 to 5).toList // List(1,2,3,4,5)

  0 :: a

  val head = List(1, 3)
  val tail = List(5, 7)

  head ::: tail // List(1,3,5,7)

  head ::: Nil // List(1,3)
}