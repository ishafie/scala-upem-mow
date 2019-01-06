package fr.upem.projet

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class RobotTest extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {

  "executeCommands" should "return the string corresponding to the wanted coordinates" in {
//    def executeCommands(area: Area, commands: List[Char], orientation: String, position: Coordinates.Point):
    val coords = Coordinates.Point(5 + 1, 5 + 1)
    val area = new Area {
      val areaTab: Array[Array[String]] = Array.ofDim[String](coords.x, coords.y)
      val coordinates: Coordinates.Point = coords
    }
    area.initMap(coords, area.areaTab)
    val commands : List[Char] = List('D', 'A', 'A')
    Robot.executeCommands(area, commands, "N", Coordinates.Point(0, 0)) should be("x: 2, y: 5 (E)")
    Robot.executeCommands(area, commands, "S", Coordinates.Point(0, 0)) should be("x: 0, y: 5 (O)")
    Robot.executeCommands(area, commands, "N", Coordinates.Point(-10, 0)) should be("x: -10, y: 5 (E)")
  }
}
