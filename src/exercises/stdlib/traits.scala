object traits extends App {
  trait Similarity {
    def isSimilar(x: Any): Boolean
    def isNotSimilar(x: Any): Boolean = !isSimilar(x)
  }

  case class Event(name: String)

  trait EventListener {
    def listen(event: Event): String
  }

  class MyListener extends EventListener {
    def listen(event: Event): String = {
      event match {
        case Event("Moose Stampede") ⇒
          "An unfortunate moose stampede occurred"
        case _ ⇒ "Nothing of importance occurred"
      }
    }
  }

  val evt = Event("Moose Stampede")
  val myListener = new MyListener

  myListener.listen(evt) // An unfortunate moose stampede occurred

  myListener.isInstanceOf[MyListener]
  myListener.isInstanceOf[EventListener]
  myListener.isInstanceOf[Any]
  myListener.isInstanceOf[AnyRef]

  trait B {
    def bId = 2
  }

  trait A { self: B =>

    def aId = 1
  }

  //val a = new A  //***does not compile!!!***

  val obj = new A with B
  (obj.aId + obj.bId)
}