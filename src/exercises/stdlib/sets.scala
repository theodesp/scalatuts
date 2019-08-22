object sets extends App {
  val mySet = Set("Michigan", "Ohio", "Wisconsin", "Michigan")

  val mySet2 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
  val aNewSet = mySet2 -- List("Michigan", "Ohio")

  val mySet3 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
  val mySet4 = Set("Wisconsin", "Michigan", "Minnesota")
  val aNewSet = mySet3 intersect mySet4
}

