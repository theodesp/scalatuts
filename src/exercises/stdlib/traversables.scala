object traversables extends App {
  val set = Set(1, 9, 10, 22)
  val list = List(3, 4, 5, 10)
  val result = set ++ list
  result.size //7

  val result2 = list ++ set
  result2.size

  val set = Set(1, 3, 4, 6)
  val result = set.map(_ * 4)
  result.lastOption // Some(24)

  val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
  list.flatten // List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
  val result = list.flatMap(_.map(_ * 4))
  result //List(4, 8, 12, 16, 20, 24, 28, 32, 36, 40)

  val list = List(1, 2, 3, 4, 5)
  val result = list.flatMap(it ⇒ if (it % 2 == 0) Some(it) else None)
  result //List(12, 18, 24, 42)

  val list = List(4, 6, 7, 8, 9, 13, 14)
  val result = list.collect {
    case x: Int if (x % 2 == 0) ⇒ x * 3
  }
  result //

  val list = List(4, 6, 7, 8, 9, 13, 14)
  val partialFunction1: PartialFunction[Int, Int] = {
    case x: Int if x % 2 == 0 ⇒ x * 3
  }
  val partialFunction2: PartialFunction[Int, Int] = {
    case y: Int if y % 2 != 0 ⇒ y * 4
  }
  val result = list.collect(partialFunction1 orElse partialFunction2)
  result //List(12, 18, 28, 24, 36, 52, 42)

  val list = List(4, 6, 7, 8, 9, 13, 14)
  list.foreach(num ⇒ println(num * 4))
  list // List(4, 6, 7, 8, 9, 13, 14)

  val set = Set(4, 6, 7, 8, 9, 13, 14)
  val result = set.toArray
  result.isInstanceOf[Array[Int]] // true

  val set = Set(4, 6, 7, 8, 9, 13, 14)
  val result = set.toList

  result.isInstanceOf[List[_]] // true

  val list = List(5, 6, 7, 8, 9)
  val result = list.toList
  result eq list // true

  val set = Set(4, 6, 7, 8, 9, 13, 14)
  val result = set.toIterable
  result.isInstanceOf[Iterable[_]] // true

  val set = Set(4, 6, 7, 8, 9, 13, 14)
  val result = set.toSeq
  result.isInstanceOf[Seq[_]] // true

  val set = Set(4, 6, 7, 8, 9, 13, 14)
  val result = set.toIndexedSeq
  result.isInstanceOf[IndexedSeq[_]] // true

  val list = List(4, 6, 7, 8, 9, 13, 14)
  val result = list.toStream
  result.isInstanceOf[Stream[_]] // true
  (result take 3)


  val list = List(4, 6, 7, 8, 9, 13, 14)
  val result = list.toSet
  result.isInstanceOf[Set[_]] // true

  val list = List("Phoenix" → "Arizona", "Austin" → "Texas")
  val result = list.toMap
  result.isInstanceOf[Map[_, _]]

  val map = Map("Phoenix" → "Arizona", "Austin" → "Texas")
  map.hasDefiniteSize // true

  val list = List(10, 19, 45, 1, 22)
  list.find(_ % 2 != 0)

  val list2 = List(4, 8, 16)
  list2.find(_ % 2 != 0)

  val list = List(10, 19, 45, 1, 22)
  list.tail // List(19, 45, 1, 22)

  val list = List(10, 19, 45, 1, 22)
  list.init // List(10, 19, 45, 1)

  val list = List(10, 19, 45, 1, 22)
  list.slice(1, 3)

  val list = List(10, 19, 45, 1, 22)
  list.take(3) // List(10, 19, 45)

  def streamer(v: Int): Stream[Int] = Stream.cons(v, streamer(v + 1))
  val a = streamer(2)
  ((a drop 6) take 3).toList // List(8, 9, 10)

  val list = List(87, 44, 5, 4, 200, 10, 39, 100)
  list.takeWhile(_ < 100)

  val list = List(87, 44, 5, 4, 200, 10, 39, 100)
  list.dropWhile(_ < 100)

  val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
  array.filter(_ < 100) // Array(87, 44, 5, 4, 10, 39)

  val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
  array.filterNot(_ < 100) // Array(200, 100)

  val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
  val result = array splitAt 3
  result._1 // Array(87, 44, 5)
  result._2 // Array(4, 200, 10, 39, 100)

  val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
  val result = array span (_ < 100)
  result._1 // Array(87, 44, 5, 4)
  result._2 // Array(200, 10, 39, 100)

  val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
  val result = array partition (_ < 100)
  result._1
  result._2

  val list = List(1, 2, 3, 4, 5)
  list.mkString(",") // 1,2,3,4,5

  val list = List(1, 2, 3, 4, 5)
  list.mkString(">", ",", "<") // >1,2,3,4,5<

  val stringBuilder = new StringBuilder()
  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
  stringBuilder.append("I want all numbers 6-12: ")
  list.filter(it ⇒ it > 5 && it < 13).addString(stringBuilder, ",")
  stringBuilder.mkString // I want all numbers 6-12: 6,7,8,9,10,11,12

  val array = Array(87, 44, 5, 4, 200, 10, 39, 100)

  val oddAndSmallPartial: PartialFunction[Int, String] = {
    case x: Int if x % 2 != 0 && x < 100 ⇒ "Odd and less than 100"
  }

  val evenAndSmallPartial: PartialFunction[Int, String] = {
    case x: Int if x != 0 && x % 2 == 0 && x < 100 ⇒ "Even and less than 100"
  }

  val negativePartial: PartialFunction[Int, String] = {
    case x: Int if x < 0 ⇒ "Negative Number"
  }

  val largePartial: PartialFunction[Int, String] = {
    case x: Int if x > 99 ⇒ "Large Number"
  }

  val zeroPartial: PartialFunction[Int, String] = {
    case x: Int if x == 0 ⇒ "Zero"
  }

  val result = array groupBy {
    oddAndSmallPartial orElse
      evenAndSmallPartial orElse
      negativePartial orElse
      largePartial orElse
      zeroPartial
  }

  (result("Even and less than 100") size) // 3
  (result("Large Number") size) // 2

  val list = List(87, 44, 5, 4, 200, 10, 39, 100)
  val result = list forall (_ < 100)
  result // false

  val list = List(87, 44, 5, 4, 200, 10, 39, 100)
  val result = list exists (_ < 100)
  result // true

  val list = List(87, 44, 5, 4, 200, 10, 39, 100)
  val result = list count (_ < 100)
  result // 6

  val list = List(5, 4, 3, 2, 1)
  val result = (0 /: list) { (`running total`, `next element`) ⇒
    `running total` - `next element`
  }
  result // -15

  val result2 = list.foldLeft(0) { (`running total`, `next element`) ⇒
    `running total` - `next element`
  }
  result2 // -15

  val result3 = (0 /: list)(_ - _) //Short hand
  result3

  val result4 = list.foldLeft(0)(_ - _)
  result4

  (((((0 - 5) - 4) - 3) - 2) - 1)

  val list = List(5, 4, 3, 2, 1)
  val result = (list :\ 0) { (`next element`, `running total`) ⇒
    `next element` - `running total`
  }
  result // 3

  // reduceLeft is similar to foldLeft, except that the seed is the head value:
  val intList = List(5, 4, 3, 2, 1)
  intList.reduceLeft {
    _ + _
  } // 15

  val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
  stringList.reduceLeft {
    _ + _}

  val intList = List(5, 4, 3, 2, 1)
  intList.reduceRight {
    _ + _
  }

  val stringList = List("Do", "Re", "Me", "Fa", "So", "La", "Te", "Do")
  stringList.reduceRight {
    _ + _
  }

  val intList = List(5, 4, 3, 2, 1)
  intList.sum // 15
  intList.product // 120
  intList.max // 5
  intList.min // 1

  val intList = List(5, 4, 3, 2, 1)
  intList.reduceRight((x, y) => x - y)

  intList.reverse.reduceLeft((x, y) => y - x)

  intList.reverse.reduce((x, y) => y - x)

  val list = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
  list.transpose // List(List(1, 4, 7), List(2, 5, 8), List(3, 6, 9))

  val list2 = List(List(1), List(4))
  list2.transpose
}