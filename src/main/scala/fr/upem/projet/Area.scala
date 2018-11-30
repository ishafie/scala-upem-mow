package fr.upem.projet

trait Area {
  val areaTab: Array[Array[String]]
  val coordinates: Coordinates.Point
  def displayMap(tab: Array[Array[String]]): Unit = tab foreach { row => row foreach print; println }
  def initMap(coordinates: Coordinates.Point,  tab: Array[Array[String]]) = for {
    i <- 0 until coordinates.y
    j <- 0 until coordinates.x
  } tab(i)(j) = "X"
}
