object typeSignatures extends App {
  val z: List[String] = "Do" :: "Re" :: "Mi" :: "Fa" :: "So" :: "La" :: "Te" :: "Do" :: Nil

  trait Randomizer[A] {
    def draw(): A
  }

  class IntRandomizer extends Randomizer[Int] {
    def draw() = {
      import util.Random
      Random.nextInt()
    }
  }

  val intRand = new IntRandomizer
  (intRand.draw < Int.MaxValue)

  classOf[String].getCanonicalName // java.lang.String
  classOf[String].getSimpleName // String

  val zoom = "zoom"
  zoom.isInstanceOf[String] // true
  zoom.getClass.getSimpleName // String

  val intRand = new IntRandomizer
  intRand.isInstanceOf[IntRandomizer] // true
  intRand.isInstanceOf[Randomizer[Int]] // true
  intRand.draw.isInstanceOf[Int] // true

  class Test1(val age: Int = 10)
  class Test2(_age: Int) {
    def age: Int = _age
  }

  new Test1(10).age // 10
  new Test2(11).age // 11
}