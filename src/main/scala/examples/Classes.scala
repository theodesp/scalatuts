// class Fields
class Person(name: String, age: Int) {

  // Multiple Constructors
  def this() {
    this("", -1)
  }

  // When name is provided, but age is not
  def this(name: String) {
    this(name, -1)
  }

  // When age is provided, but name is not
  def this(age: Int) {
    this("", age)
  }

  def getName(): String = {
    name
  }

  def getAge(): Int = {
    age
  }
}

// class parameter
class Person2(val name: String, val age: Int) {}

// Abstract classes
abstract class Parent(val name: String = "Noname") {
  def getAge: Int
}

class Child extends Parent {
 override def getAge(): Int = {
    10
 }
}

object Person {
  val p = new Person("Alex", 30)
  val p2 = new Person2("Alex", 30)

  def main(args: Array[String]): Unit = {
    println(p.getName())
    println(p2.name)
    println(new Child().getAge())
  }
}
