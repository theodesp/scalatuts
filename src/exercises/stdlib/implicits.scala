object implicits extends App {
  abstract class SemiGroup[A] {
    def add(x: A, y: A): A
  }
  abstract class Monoid[A] extends SemiGroup[A] {
    def unit: A
  }

  implicit object StringMonoid extends Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }
  implicit object IntMonoid extends Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))
  println(sum(List(1, 2, 3)))
  println(sum(List("a", "b", "c")))

  class KoanIntWrapper(val original: Int) {
    def isOdd = original % 2 != 0
  }

  implicit def thisMethodNameIsIrrelevant(value: Int) =
    new KoanIntWrapper(value)

  19.isOdd
  20.isOdd

  object MyPredef {

    class KoanIntWrapper(val original: Int) {
      def isOdd = original % 2 != 0

      def isEven = !isOdd
    }

    implicit def thisMethodNameIsIrrelevant(value: Int) =
      new KoanIntWrapper(value)
  }


  import java.math.BigInteger
  implicit def Int2BigIntegerConvert(value: Int): BigInteger =
    new BigInteger(value.toString)

  def add(a: BigInteger, b: BigInteger) = a.add(b)

  add(3, 6) == 9
  add(3, 6) == Int2BigIntegerConvert(9)

  add(3, 6) == (9: BigInteger) // true
  add(3, 6).intValue == 9 // true

  def howMuchCanIMake_?(hours: Int)(implicit dollarsPerHour: BigDecimal) =
    dollarsPerHour * hours

  implicit val hourlyRate = BigDecimal(34)

  howMuchCanIMake_?(30) // 1020

  def howMuchCanIMake_?(hours: Int)(implicit amount: BigDecimal, currencyName: String) =
    (amount * hours).toString() + " " + currencyName

  implicit val hourlyRate = BigDecimal(34)
  implicit val currencyName = "Dollars"
  howMuchCanIMake_?(30)


  def howMuchCanIMake_?(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
    (amount * hours).toString() + " " + currencyName

  howMuchCanIMake_?(30)
  howMuchCanIMake_?(30, 95)
}