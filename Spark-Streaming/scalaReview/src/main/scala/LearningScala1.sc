object LearningScala1 {
  val hello: String = "Hello"

  val theUltimateAnswer: String = "To life, the universe, and everything is 42."

  val pattern = """.* ([\d]+).*""".r
  val pattern(answerString) = theUltimateAnswer
  val answer = answerString.toInt
  println(answer)

  val number = 3
  number match {
    case 1 => println("one")
    case 2 => println("two")
    case 3 => println("three")
    case _ => println("Something else")
  }


  for (x <- 1 to 4) {
    val squared = x * x
    println(squared)
  }


  {val x = 10; x + 20}
  println({val x = 10; x + 20})

  val captiainStuff = ("Picard", "Enterprise-D", "NCC-1701-D")
  println(captiainStuff)
  println(captiainStuff._1)
  println(captiainStuff._2)

  val picardShip = "Picard" -> "Enterprise-D"
  println(picardShip)
  println(picardShip._2)

  val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Space Nine")

  println(shipList(1))
  println(shipList.head)
  println(shipList.tail)
  for (ship <- shipList) {println(ship)}

  val backwardShips = shipList.map((ship: String) => { ship.reverse })

  for (ship <- backwardShips) { println(ship) }

  val numberList = List(1, 2, 3, 4, 5)
  val sum = numberList.reduce( (x: Int, y: Int) => x + y)
  println(sum)

  val iHateFives = numberList.filter((x: Int) => x != 5)
  val iHateThree = numberList.filter((_ != 3))

  // Concatenating list
  val moreNumbers = List(6, 7, 8)
  val lotsOfNumber = numberList ++ moreNumbers


 // More List fun
  val reversed = numberList.reverse
  val sorted = reversed.sorted
  val lotsOfDuplicates = numberList ++ numberList
  val distinctValues = lotsOfDuplicates.distinct
  val maxValue = numberList.max
  val total = numberList.sum
  val hasThree = iHateThree.contains(3)

  // Maps
  val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine", "Janeway" -> "Voyager")

  println(shipMap.contains("Archer"))
  val archersShip = util.Try(shipMap("Archer")) getOrElse "Unknown"
  println(archersShip)

}