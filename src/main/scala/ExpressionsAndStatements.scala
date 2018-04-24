object ExpressionsAndStatements {
  def main(args: Array[String]): Unit = {
    // Statement
    val x = 1
    println(x)

    // Expression
    println("Hello " ++ "World")

    // Expression block
    var result = {
      val PI = 3.14
      PI * 2 * 3
    }

    println(s"Result is $result")

  }
}