package fr.upem.projet

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks


class AreaTest extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {
  "initMap" should "fill map with X" in {
    val coords = Coordinates.Point(2, 2)
    val area = new Area {
      val areaTab: Array[Array[String]] = Array.ofDim[String](2, 2)
      val coordinates: Coordinates.Point = coords
    }
    area.initMap(coords, area.areaTab)
    val result = Array(Array("X", "X"), Array("X", "X"))
    area.areaTab should be(result)
  }

  "checkPosition" should "check if the position is out of bounds" in {
    val coords = Coordinates.Point(2, 2)
    val area = new Area {
      val areaTab: Array[Array[String]] = Array.ofDim[String](2, 2)
      val coordinates: Coordinates.Point = coords
    }
    area.initMap(coords, area.areaTab)
    area.checkPosition(0)(0)(0)(0) should be(false)
    area.checkPosition(1)(0)(2)(1) should be(true)
    area.checkPosition(3)(1)(1)(1) should be(false)
    area.checkPosition(-1)(1)(1)(1) should be(false)
    area.checkPosition(1)(2)(3)(4) should be(true)
  }



}
