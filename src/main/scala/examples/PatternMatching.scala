/**
  * Pattern Matching in Scala
  */
object PatternMatching {
  def main(args: Array[String]): Unit = {
    val day = "Wed"

    var result = day match {
      case "Mon" | "Tue" => "Manic Day"
      case other if other == "Wed" => "Other Day"
      case _ => "Rather another day"
    }

    println(result)

    val radiusList: Any = "Hello"

    var result2 = radiusList match {
      case radiusList: Int => "Integer"
      case radiusList: String => "String"
      case radiusList: Double => "Double"
      case _ => "Any"
    }

    println(result2)
  }
}