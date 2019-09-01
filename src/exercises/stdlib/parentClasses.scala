object parentClasses extends App {
  class Soldier(val firstName: String, val lastName: String) {}
  class Pilot(override val firstName: String, override val lastName: String, val squadron: Long)
    extends Soldier(firstName, lastName)
  val pilot = new Pilot("John", "Yossarian", 256)
  pilot.firstName // John
  pilot.lastName //

  class Soldier(val firstName: String, val lastName: String) {}
  class Pilot(override val firstName: String, override val lastName: String, val squadron: Long)
    extends Soldier(firstName, lastName)

  val pilot = new Pilot("John", "Yossarian", 256)
  val soldier: Soldier = pilot

  soldier.firstName // John
  soldier.lastName

  abstract class Soldier(val firstName: String, val lastName: String) {

    class Catch(val number: Long) {
      // nothing to do here.  Just observe that it compiles
    }

  }
  class Pilot(override val firstName: String, override val lastName: String, val squadron: Long)
    extends Soldier(firstName, lastName)

  val pilot = new Pilot("John", "Yossarian", 256)
  val catchNo = new pilot.Catch(22)

  catchNo.number // 22
}