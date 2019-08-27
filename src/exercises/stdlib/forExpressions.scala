object forExpressions extends App {
  val xValues = 1 to 4
  val yValues = 1 to 2
  val coordinates = for {
    x ← xValues
    y ← yValues
  } yield (x, y)
  coordinates(4) // (3, 1)

  val nums = List(List(1), List(2), List(3), List(4), List(5))

  val result = for {
    numList ← nums
    num ← numList
    if (num % 2 == 0)
  } yield (num)

  result

  nums.flatMap(numList ⇒ numList).filter(_ % 2 == 0)
  nums.flatten.filter(_ % 2 == 0)
}