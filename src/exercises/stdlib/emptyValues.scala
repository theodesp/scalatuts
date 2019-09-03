object emptyValues extends App {
  //List() === Nil // true

  None === None // true

  None eq None // true

  None.toString

  //None.toList === Nil // true

  None.isEmpty // true

  None.asInstanceOf[Any] == None // ture
  None.asInstanceOf[AnyRef] == None // true
  None.asInstanceOf[AnyVal] == None // true

  val optional: Option[String] = None
  optional.isEmpty // true
  optional // None

  val optional: Option[String] = Some("Some Value")

  optional == None

  optional.getOrElse("No Value") // "Some Value"

  val optional2: Option[String] = None
  optional2.getOrElse("No Value") // "No Value"
}