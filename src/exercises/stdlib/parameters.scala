object parameters extends App {
  def calc(x: ⇒ Int): Either[Throwable, Int] = {
    //x is a call by name parameter
    try {
      Right(x)
    } catch {
      case b: Throwable ⇒ Left(b)
    }
  }

  val y = calc {
    //This looks like a natural block
    println("Here we go!") //Some superfluous call
    val z = List(1, 2, 3, 4) //Another superfluous call
    49 + 20
  }

  y

  object PigLatinizer {
    def apply(x: ⇒ String) = x.tail + x.head + "ay"
  }

  val result = PigLatinizer {
    val x = "pret"
    val z = "zel"
    x ++ z //concatenate the strings
  }

  result // retzelpay
}