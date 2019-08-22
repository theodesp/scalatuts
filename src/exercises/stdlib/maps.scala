object maps extends App {
  val myMap =
    Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
  myMap.size // 4

  val aNewMap = myMap + ("IL" → "Illinois")

  val mapValues = myMap.values

  mapValues.head
  mapValues.last

  myMap("MI")

  val myMap2 = Map("Ann Arbor" → "MI", 49931 → "MI")

  myMap.getOrElse("TX", "missing data")

  val aNewMap2 = myMap - "MI"

  aNewMap2.contains("MI") // false

  val aNewMap3 = myMap - ("MI", "WI")
}