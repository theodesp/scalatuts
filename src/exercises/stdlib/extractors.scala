object extractors extends App {
  object Twice {
    def apply(x: Int): Int = x * 2
    def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
  }

  val x = Twice(21)
  x match { case Twice(n) => Console.println(n) } // prints 21

  case class Employee(firstName: String, lastName: String)

  val rob = Employee("Robin", "Williams")
  val result = rob match {
    case Employee("Robin", _) ⇒ "Where's Batman?"
    case _ ⇒ "No Batman Joke For You"
  }

  result

  class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)

  object ChopShop {
    def unapply(x: Car) = Some(x.make, x.model, x.year, x.topSpeed)
  }

  val ChopShop(a, b, c, d) = new Car("Chevy", "Camaro", 1978, 120)

  //class Car(val make: String, val model: Str
  //
  //  ing, val year: Short, val topSpeed: Short)

  object ChopShop {
    def unapply(x: Car) = Some(x.make, x.model, x.year, x.topSpeed)
  }

  //val x = new Car("Chevy", "Camaro", 1978, 120) match {
  //  case ChopShop(s, t, u, v) ⇒ (s, t)
  //  case _ ⇒ ("Ford", "Edsel")
  //}
  //
  //x._1
  //x._2

  class Car(val make: String, val model: String, val year: Short, val topSpeed: Short)
  class Employee(val firstName: String, val middleName: Option[String], val lastName: String)

  object Tokenizer {
    def unapply(x: Car) = Some(x.make, x.model, x.year, x.topSpeed)

    def unapply(x: Employee) = Some(x.firstName, x.lastName)
  }

  //val result = new Employee("Kurt", None, "Vonnegut") match {
  //  case Tokenizer(c, d) ⇒ "c: %s, d: %s".format(c, d)
  //  case _ ⇒ "Not found"
  //}
  //
  //result

  class Employee(
                  val firstName: String,
                  val middleName: Option[String],
                  val lastName: String
                )

  object Employee {
    //factory methods, extractors, apply
    //Extractor: Create tokens that represent your object
    def unapply(x: Employee) =
      Some(x.lastName, x.middleName, x.firstName)
  }

  val singri = new Employee("Singri", None, "Keerthi")

  val Employee(a, b, c) = singri

  val result = singri match {
    case Employee("Singri", None, x) ⇒
      "Yay, Singri %s! with no middle name!".format(x)
    case Employee("Singri", Some(x), _) ⇒
      "Yay, Singri with a middle name of %s".format(x)
    case _ ⇒ "I don't care, going on break"
  }

  result

}