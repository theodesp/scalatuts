object functions extends App {

  def sum(a: Int, b: Int, c: Int) = a + b + c
  val sum3 = sum _
  sum3(1, 9, 7)
  sum(4, 5, 6)

  val sumC = sum(1, 10, _: Int)
  sumC(4)

  def multiply(x: Int, y: Int) = x * y
  (multiply _).isInstanceOf[Function2[_, _, _]]

  val multiplyCurried = (multiply _).curried
  multiply(4, 5)
  multiplyCurried(3)(2)

  val multiplyCurriedFour = multiplyCurried(4)

  def customFilter(f: Int ⇒ Boolean)(xs: List[Int]) =
    xs filter f
  def onlyEven(x: Int) = x % 2 == 0
  val xs = List(12, 11, 5, 20, 3, 13, 2)
  customFilter(onlyEven)(xs)

  val onlyEvenFilter = customFilter(onlyEven) _
  onlyEvenFilter(xs)

  val doubleEvens: PartialFunction[Int, Int] =
    new PartialFunction[Int, Int] {
      //States that this partial function will take on the task
      def isDefinedAt(x: Int) = x % 2 == 0

      //What we do if this partial function matches
      def apply(v1: Int) = v1 * 2
    }

  val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
    def isDefinedAt(x: Int) = x % 2 != 0

    def apply(v1: Int) = v1 * 3
  }

  //val whatToDo = doubleEvens orElse tripleOdds
  //
  //whatToDo(3)
  //whatToDo(4)

  val doubleEvens2: PartialFunction[Int, Int] = {
    case x if (x % 2) == 0 ⇒ x * 2
  }
  val tripleOdds2: PartialFunction[Int, Int] = {
    case x if (x % 2) != 0 ⇒ x * 3
  }

  val doubleEvens3: PartialFunction[Int, Int] = {
    case x if (x % 2) == 0 ⇒ x * 2
  }
  val tripleOdds3: PartialFunction[Int, Int] = {
    case x if (x % 2) != 0 ⇒ x * 3
  }

  val printEven: PartialFunction[Int, String] = {
    case x if (x % 2) == 0 ⇒ "Even"
  }
  val printOdd: PartialFunction[Int, String] = {
    case x if (x % 2) != 0 ⇒ "Odd"
  }

  val whatToDo2 = doubleEvens3 orElse tripleOdds3 andThen (printEven orElse printOdd)

  whatToDo2(3)
  whatToDo2(4)
}