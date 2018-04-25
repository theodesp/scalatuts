/**
  * Loops in Scala
  */
object Loops {
  def main(args: Array[String]): Unit = {
    val weekDays = List("Mon", "Tue", "Wed", "Thu", "Fri")

    // Statement!
    for (day <- weekDays) {
      day match {
        case "Mon" => println("Monday")
        case otherDay => println(otherDay)
      }
    }

    // Statement!
    for (i <- 0 to weekDays.size - 1) {
      println(weekDays(i))
    }

    // Statement!
    for (i <- 0 until weekDays.size) {
      println(weekDays(i))
    }

    // Statement!
    for (day <- weekDays if day == "Mon") {
      println("Monday")
    }

    // Expression
    val result = for (day <- weekDays) yield {
      day match {
        case "Mon" => "Monday"
        case otherDay => otherDay
      }
    }
    println(result)
  }
}