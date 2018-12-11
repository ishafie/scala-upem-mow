package fr.upem.projet

import fr.upem.projet.Coordinates.Orientation

trait Robot {
  def startRobot(commands: List[Char], coords: List[String], area: Area)
}

object Robot {
  def executeCommands(area: Area, commands: List[Char], orientation: String, position: Coordinates.Point): String = commands match {
    case x :: xs if x equals 'A' => executeCommands(area, xs, orientation, area.advance(area, Orientation(orientation), position))
    case x :: xs => {
      //println("Command: " + x + ", Orientation: " + orientation)
      //Coordinates.print(position)
      //println("----")
      executeCommands(area, xs, Coordinates.move(Orientation(orientation))(x), position)
    }
    case Nil => "x: " + position.x + ", y: " + ((area.coordinates.y - 1) - position.y) + " (" + orientation + ")"
  }

  def startRobot(commands: List[Char], coords: List[String], area: Area): Unit = {
    val point = Coordinates.Point(coords.head.toInt, (area.coordinates.y - 1) - coords(1).toInt)
    if (point.y >= 0 && point.y < area.coordinates.y && point.x >= 0 && point.x < area.coordinates.x) area.areaTab(point.y)(point.x) = "O"
    //Coordinates.print(point)
    println(executeCommands(area, commands, coords(2), point))
  }
}