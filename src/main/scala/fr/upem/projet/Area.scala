package fr.upem.projet

import fr.upem.projet.Coordinates.Orientation

trait Area {
  val areaTab: Array[Array[String]]
  val coordinates: Coordinates.Point

  def displayMap(tab: Array[Array[String]]): Unit = tab foreach { row => row foreach print; println }

  def initMap(coordinates: Coordinates.Point, tab: Array[Array[String]]) = for {
    i <- 0 until coordinates.y
    j <- 0 until coordinates.x
  } tab(i)(j) = "X"

  def advance(area: Area, orientation: Orientation, position: Coordinates.Point): Coordinates.Point = orientation match {
    case Orientation("O") if position.x - 1 >= 0 => setAndRetCoordinates(area, position.x - 1, position.y)
    case Orientation("E") if position.x + 1 < area.coordinates.x => setAndRetCoordinates(area, position.x + 1, position.y)
    case Orientation("N") if position.y - 1 < area.coordinates.y => setAndRetCoordinates(area, position.x, position.y - 1)
    case Orientation("S") if position.y + 1 >= 0 => setAndRetCoordinates(area,position.x, position.y + 1)
    case _ => position

  }

  def setAndRetCoordinates(area: Area, x: Int, y: Int): Coordinates.Point = {
    println("x: " + x + ", y: " + y)
    area.areaTab(y)(x) = "O"
    Coordinates.Point(x, y)
  }

}
