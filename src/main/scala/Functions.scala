
object Functions {
  val PI = 3.14
  // Function
  val compareStringsLiteral =
    (s1: String, s2: String) => {
      if (s1 == s2)
        0
      else if (s1 > s2)
        -1
      else
        1
    }: Int

  def getCircleArea(r: Double):Double = PI * r * r

  // Method needs to exist inside a class
  def main(args: Array[String]): Unit = {
    println(compareStringsLiteral("hello", "jello"))

    // Convert method to function - 1st way using types
    val calcCircleArea: (Double) => Double = getCircleArea

    // Convert method to function - 2nd way Does not work all the time
    val calcCircleArea2 = getCircleArea _

    println(calcCircleArea(5))
    println(calcCircleArea2(5))

    // Default parameter values
    def getTuple(PI: Double = 3.14, r: Double) = {
      (PI, r * 2)
    }
    println(getTuple(r=5))

    // Generics
    def printType[K](k: K) = {
      println(s"$k has type ${k.getClass()}")
    }

    printType(12.2)

    // Partial functions
    val defaultTuple = getTuple(3.14, _: Double)

    println(defaultTuple(3))

    // By name parameters will be re-evaluated every time they are referenced
    def sayHello(name: => String) = {
      println(name)
      name
    }

    def addGreeting(s: String): String = {
      println(s)
      s"Called $s"
    }

    sayHello(addGreeting("World"))
  }
}