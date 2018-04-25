object StringInterpolation {
  def main(args: Array[String]): Unit = {
    val greeting = "Hello"
    println(s"$greeting world")

    val apples = 2
    println(s"I have ${2 * apples} apples")
  }
}