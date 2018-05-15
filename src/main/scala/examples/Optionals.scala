import scala.io.Source
import java.net.URL

//case class User(id: Int,
//                firstName: String,
//                lastName: String,
//                age: Int,
//                gender: Option[String])
//
//object UserRepository {
//  private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
//                          2 -> User(2, "Johanna", "Doe", 30, None))
//  def findById(id: Int): Option[User] = users.get(id)
//  def findAll = users.values
//}




object Optionals {

  def getContent(url: URL): Either[String, Source] =
    if (url.getHost.contains("google"))
      Left("Requested URL is blocked for the good of the people!")
    else
      Right(Source.fromURL(url))

//  val absentGreeting
//    : Option[String] = Option(null) // absentGreeting will be None
//  val presentGreeting: Option[String] = Option("Hello!") // presentGree
//
  def main(args: Array[String]): Unit = {
//    val user = User(2, "Johanna", "Doe", 30, None)
//    user.gender match {
//      case Some(gender) => println("Gender: " + gender)
//      case None => println("Gender: not specified")
//    }
//
//    val gender1 = UserRepository.findById(1).flatMap(_.gender)
//    val above30 = UserRepository.findById(1).filter(_.age > 30)

    getContent(new URL("http://danielwestheide.com")) match {
      case Left(msg) => println(msg)
      case Right(source) => source.getLines.foreach(println)
    }

    val content: Iterator[String] =
      getContent(new URL("http://danielwestheide.com")).fold(Iterator(_), _.getLines())
    val moreContent: Iterator[String] =
      getContent(new URL("http://google.com")).fold(Iterator(_), _.getLines())
  }
}
