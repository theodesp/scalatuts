object Implicits {
  def multiply(implicit param1: Int) = param1 * value
  val value = 10
  implicit val anotherValue = 2

  implicit def doubleToInt(d: Double) = d.toInt

  val x : Int = 20.23

  def main(args: Array[String]): Unit = {
    println(multiply)

    println(x)
  }
}