trait User {
  def name: String
  def score: Int
}
class FreeUser(val name: String, val score: Int, val upgradeProbability: Double)
  extends User
class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] =
    Some((user.name, user.score, user.upgradeProbability))
}
object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
}

object premiumCandidate {
  def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
}

case class Player(name: String, score: Int)



object Extractors {
  def message(player: Player) = player match {
    case Player(_, score) if score > 100000 => "Get a job, dude!"
    case Player(name, _) => "Hey " + name + ", nice to see you again!"
  }
  def printMessage(player: Player) = println(message(player))

  def main(args: Array[String]): Unit = {
    val user: User = new FreeUser("Daniel", 2500, 0.8d)
    val result = user match {
      case freeUser @ premiumCandidate() => "Free"
      case _ => "Normal"
    }

    println(result)

    val xs = 3 :: 6 :: 12 :: 24 :: Nil
    xs match {
      case List(a, b, _*) => a * b
      case _ => 0
    }

    printMessage(Player("Alex", 1000))

    val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

    for {
      list @ head :: _ <- lists
    } yield list.size

    implicit val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
      ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

    def wordsWithoutOutliers(implicit wordFrequencies: Seq[(String, Int)]): Seq[String] =
      wordFrequencies.filter { case (_, f) =>
        f > 3 && f < 25 } map { case (w, _) => w
      }

    println(wordFrequencies)

    // Partial Functions
    val pf: PartialFunction[(String, Int), String] = {
      case (word, freq) if freq > 3 && freq < 25 => word
    }

    // Alternative Declaration
    val pf2 = new PartialFunction[(String, Int), String] {
      def apply(wordFrequency: (String, Int)) = wordFrequency match {
        case (word, freq) if freq > 3 && freq < 25 => word
      }
      def isDefinedAt(wordFrequency: (String, Int)) = wordFrequency match {
        case (word, freq) if freq > 3 && freq < 25 => true
        case _ => false
      }
    }

    def wordsWithoutOutliers2(implicit wordFrequencies: Seq[(String, Int)]): Seq[String] =
      wordFrequencies.collect(pf)

    println(wordsWithoutOutliers2)
  }
}