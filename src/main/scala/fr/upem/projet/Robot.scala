package fr.upem.projet


trait Robot {
  def startRobot(commands: List[String], coords: List[String], area: Area)
}

object Robot {
  def startRobot(commands: List[String], coords: List[String], area: Area): Unit = {
    area.areaTab((area.coordinates.y - 1) - coords.head.toInt)(coords(1).toInt) = "O"
    /*Coordinates.Orientation.move(coords(3), commands)
    case Orientation("G") case "N" "W"
    ("A")
    ("D")*/
  }
}