object HigherOrderFunctions {
  def main(args: Array[String]): Unit = {
    val weekDays2 = "Mon" :: "Tue" :: "Wed" :: "Thu" :: "Fri" :: Nil

    // foreach
    weekDays2.foreach(println(_))

    // map
    println(weekDays2.map(_ == "Mon"))

    // filter
    println(weekDays2.filter(_ == "Mon"))

    // filterNot
    println(weekDays2.filterNot(_ == "Mon"))

    // Partition
    println(weekDays2.partition(_ == "Mon"))

    // SortBy
    println(weekDays2.sortBy(_(0)))

    val someNumbers = List(10, 20, 30, 40, 50)

    // ScanRight
    println(someNumbers.scanRight(0)(_ - _))

    // ScanLeft
    println(someNumbers.scanLeft(0)(_ - _))

    // FoldRight
    println(someNumbers.foldRight(0)(_ - _))

    // FoldLeft
    println(someNumbers.foldLeft(0)(_ - _))

    // ReduceRight
    println(someNumbers.reduceRight(_ - _))

    // ReduceLeft
    println(someNumbers.reduceLeft(_ - _))
  }
}