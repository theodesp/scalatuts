object infixPostfix extends App {
  val g: Int = 3
  (g + 4) // 7
  g.+(4) // 7

  val gg: String = "Check out the big brains on Brad!"
  gg indexOf 'o'
  gg.indexOf('o', 7)

  val h: Int = 31
  (h toHexString)

  // Prefix operators work if an object has a method name that starts with unary_ :
  (-g) // -31

  class Stereo {
    def unary_+ = "on"

    def unary_- = "off"
  }

  val stereo = new Stereo
  (+stereo) // on
  (-stereo) // off

  case class Person(name: String)
  class Loves[A, B](val a: A, val b: B)

  def announceCouple(couple: Person Loves Person) =
  //Notice our type: Person loves Person!
    couple.a.name + " is in love with " + couple.b.name

  val romeo = new Person("Romeo")
  val juliet = new Person("Juliet")

  announceCouple(new Loves(romeo, juliet))

  case class Person2(name: String) {
    def loves(person: Person2) = new Loves(this, person)
  }

  def announceCouple2(couple: Person2 Loves Person2) =
  //Notice our type: Person loves Person!
    couple.a.name + " is in love with " + couple.b.name

  val romeo2 = new Person2("Romeo")
  val juliet2 = new Person2("Juliet")

  announceCouple2(romeo2 loves juliet2)
}