object Functions {
  val compareStringsLiteral =
    (s1: String, s2: String) => {
      if (s1 == s2)
        0
      else if (s1 > s2)
        -1
      else
        1
    }: Int

  def main(args: Array[String]): Unit = {
    println(compareStringsLiteral("hello", "jello"))
  }
}