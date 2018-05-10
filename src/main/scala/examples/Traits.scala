trait Book {

  val id: Int
  val name: String
  val isbn: Long
  val price: Double
  //Concrete variable
  val category = "Uncategorized"

  //Concrete implementation
  def getTaxOnPrice: Double = {
    (price * 14) / 100
  }

}

trait ScienceBook extends Book {
  override val category: String = "Science Book"
}

abstract class ScienceBook2 extends Book {
  override val category: String = "Science Book"
}

class ScienceBook3 extends Book {
  override val id: Int = 1000
  override val name: String = "A Brief History of Time"
  override val isbn: Long = 9783499605550l
  override val price: Double = 7.43

  override def getTaxOnPrice: Double = {
    (price * 10) / 100
  }
}

// Mixins
trait Product {
  val prodID : Int
  val skuID : Int
}

object Traits {
  def main(args: Array[String]) = {
    // Extension with mixin
    val scBook = new ScienceBook3() with Product {
      override val prodID: Int = 1000
      override val skuID: Int = 2000
    }

    //Original class instance
    val scBookWithoutProduct = new ScienceBook3()
  }
}
