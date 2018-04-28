object Collections {
  def main(args: Array[String]): Unit = {
    // Tuples
    val personInfo = ("Alex", "Gambin", 36, "M")
    val genderPair = "Alex" -> "M"

    personInfo.productIterator.foreach(i => println(s"Value = $i"))

    // Desctructuring
    val (first, last, age, gender) = personInfo

    println(first)

    // Dot notation
    println(personInfo._1)
    println(personInfo._2)

    def printPersonGender(name: String, gender: String) = println(s"Name:$name M/F:$gender")

    // Syndax to apply tuple to function
    (printPersonGender _).tupled(genderPair)

    // Lists are immutable
    val weekDays2 = "Mon" :: "Tue" :: "Wed" :: "Thu" :: "Fri" :: Nil
    println(weekDays2)
    val weekDays3 = List("Sat", "Sun")

    // Concat 2 lists
    println(weekDays2 ::: weekDays3)
    println(weekDays2 ++ weekDays3)

    // Flattening lists
    println(List(weekDays2, weekDays3).flatten)

    // Zipping lists
    println(weekDays2 zip weekDays2)

    // Head
    println(weekDays2.head)

    // Tail
    println(weekDays2.tail)

    // Size
    println(weekDays2.size)

    // Reverse
    println(weekDays2.reverse)

    // Index
    println(weekDays2(1))

    // Containers
    println(weekDays2.contains("Sat"))

    // Check all conditions are true in the list
    println(weekDays2.forall(_ != "Monday"))

    // End with another list
    println(weekDays2 endsWith weekDays3)

    // Start with another list
    println(weekDays2 startsWith weekDays2)

    // Maps
    val stateCodes = Map(
      "California" -> "CA",
      "New York" -> "NY",
      ("Vermond", "VT")
    )
    println(stateCodes)

    // Get by key
    println(stateCodes("Vermond"))

    // Check key exists
    println(stateCodes.contains("Georgia"))

    // Foreach
    stateCodes.foreach((p: (String, String)) => println(s"Key is ${p._1}, Value is ${p._2}"))

    val states = List("California", "New York", "Vermond")
    val codes = List("CA", "NY", "VT")

    // List to map
    println((states zip codes).toMap)

    // Map keys
    println(stateCodes.keySet.toList)

    // Map values
    println(stateCodes.values.toList)

    // Optionals
    def fraction(numer: Double, denom: Double): Option[Double] = {
      if (denom == 0)
        None
      else
        Option(numer / denom)
    }

    println(fraction(22, 7))
    println(fraction(22, 0) getOrElse "Ooops")

    // Try method
    val stateCode = util.Try(stateCodes("NoSuchState"))

    println(stateCode match {
      case util.Success(code) => code
      case util.Failure(error) => "Oo0ps"
    })

    // Mutable collections
    val someNumbers = collection.mutable.Buffer(10, 20, 30, 40, 50)
    val someStates = collection.mutable.Map(("California", "CA"))

    // List builder
    val listBuilder = List.newBuilder[Int]

    // From mutable to immutable list
    someNumbers.foreach(listBuilder+=_)

    println(listBuilder.result)
  }
}