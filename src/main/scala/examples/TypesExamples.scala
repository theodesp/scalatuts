object TypesExamples {
  def main(args: Array[String]): Unit = {
    val radius = 10.0
    println(radius.getClass()) // double
    val radius2: Float = 10.0f
    println(radius2.getClass()) // double

    println(AnyRef.getClass())

    printAny(5)
    printAny(List(1, 2))

    printAnyVal(5)
    // printAnyVal(List(1,2)) will fail

    // printAnyRef(5) will fail
    printAnyRef(List(1, 2))
  }

  // Will print anything
  def printAny(x: Any): Unit = println(x)

  // Will print only values
  def printAnyVal(x: AnyVal): Unit = println(x)

  // Will print only references
  def printAnyRef(x: AnyRef): Unit = println(x)
}