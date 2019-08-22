object patternMatching extends App {
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many" // case _ will trigger if all other cases fail.
  }
  println(matchTest(3)) // prints "many"

  val stuff = "blue"

  val myStuff = stuff match {
    case "red" ⇒ (255, 0, 0)
    case "green" ⇒ (0, 255, 0)
    case "blue" ⇒ (0, 0, 255)
    case _ ⇒ println(stuff); 0
  }


  def goldilocks(expr: Any) = expr match {
    case ("porridge", "Papa") ⇒ "Papa eating porridge"
    case ("porridge", "Mama") ⇒ "Mama eating porridge"
    case ("porridge", "Baby") ⇒ "Baby eating porridge"
    case _ ⇒ "what?"
  }

  goldilocks(("porridge", "Mama"))

  def goldilocks2(expr: Any) = expr match {
    case ("porridge", bear) ⇒
      bear + " said someone's been eating my porridge"
    case ("chair", bear) ⇒ bear + " said someone's been sitting in my chair"
    case ("bed", bear) ⇒ bear + " said someone's been sleeping in my bed"
    case _ ⇒ "what?"
  }
  goldilocks2(("porridge", "Papa"))
  goldilocks2(("chair", "Mama"))

  val foodItem = "porridge"

  def goldilock3(expr: Any) = expr match {
    case (`foodItem`, _) ⇒ "eating"
    case ("chair", "Mama") ⇒ "sitting"
    case ("bed", "Baby") ⇒ "sleeping"
    case _ ⇒ "what?"
  }

  def patternEquals(i: Int, j: Int) = j match {
    case `i` ⇒ true
    case _ ⇒ false
  }

  patternEquals(3, 3)

  val secondElement = List(1, 2, 3) match {
    case x :: xs ⇒ xs.head
    case _ ⇒ 0
  }

  secondElement

  val r = List(1, 2, 3) match {
    case x :: y :: z :: tail ⇒ tail
    case _ ⇒ 0
  }

  r == Nil
}