object arguments extends App {
  def printName(first: String, last: String) = {
    println(first + " " + last)
  }

  printName("John", "Smith") // Prints "John Smith"
  printName(first = "John", last = "Smith") // Prints "John Smith"
  printName(last = "Smith", first = "John") // Prints "John Smith"

  def printName(first: String = "John", last: String = "Smith") = {
    println(first + " " + last)
  }
  printName(last = "Jones") // Prints "John Jones"

  class WithoutClassParameters() {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red, green, blue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red, green, blue)
    }
  }

  class WithClassParameters(val defaultRed: Int, val defaultGreen: Int, val defaultBlue: Int) {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }
  }

  class WithClassParametersInClassDefinition(val defaultRed: Int = 0, val defaultGreen: Int = 255, val defaultBlue: Int = 100) {
    def addColors(red: Int, green: Int, blue: Int) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }

    def addColorsWithDefaults(red: Int = 0, green: Int = 0, blue: Int = 0) = {
      (red + defaultRed, green + defaultGreen, blue + defaultBlue)
    }
  }

  val me = new WithoutClassParameters()

  // what happens if you change the order of these parameters (nothing)
  val myColor = me.addColors(green = 0, red = 255, blue = 0)

  // for koan, remove the values in the should equal
  myColor

  val me = new WithoutClassParameters()
  val myColor = me.addColorsWithDefaults(green = 255)

  myColor

  val me = new WithClassParameters(40, 50, 60)
  val myColor = me.addColors(green = 50, red = 60, blue = 40)

  myColor

  val me = new WithClassParameters(10, 20, 30)
  val myColor = me.addColorsWithDefaults(green = 70)

  myColor

  val me = new WithClassParametersInClassDefinition()
  val myColor = me.addColorsWithDefaults(green = 70)

  myColor

  def reduce(a: Int, f: (Int, Int) ⇒ Int = _ + _): Int = f(a, a)

  reduce(5)

  reduce(5, _ * _)
}