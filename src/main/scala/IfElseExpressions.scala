object IfElseExpressions {
  def main(args: Array[String]): Unit = {
    val numer: Double = 22
    val denom: Double = 7
    val PI =
      if (denom != 0) {
        numer / denom
      }
      else {
        None
      }

    println(PI)
  }
}