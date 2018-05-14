object ContractProgramming {

  def grantLicense(age: Int): Unit = {
    assume(age > 18)
  }

  def squareEvenNumbersWithLimit(num: Int, limit: Int): Int = {
    require(num % 2 == 0)

    num * num

  } ensuring (num * num < limit)

  def main(args: Array[String]): Unit = {}
}
