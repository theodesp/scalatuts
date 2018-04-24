/**
  * Some examples with val and var
  */

object ImmutableDataExample {
  // Immutable
  val PI = 3.14

  def main(args: Array[String]): Unit = {
    println(PI)
    // Mutable
    var E = 2.71
    println(E)
    E = 3.71
    println(E)

    val weekDays = List("Mon", "Tue", "Wed", "Thu", "Fri")
    println(weekDays.map(_ == "Tue"))
  }
}