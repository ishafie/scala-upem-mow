package fr.upem.projet

import fr.upem.projet.Coordinates.Orientation
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class CoordinatesTest extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {
  "move" should "return the good orientation after moving in a certain direction" in {
    Coordinates.move(Orientation("N"))('A') should be("unknown")
    Coordinates.move(Orientation("A"))('G') should be("unknown")

    Coordinates.move(Orientation("O"))('G') should be("S")
    Coordinates.move(Orientation("O"))('D') should be("N")
    Coordinates.move(Orientation("N"))('G') should be("O")
    Coordinates.move(Orientation("N"))('D') should be("E")
    Coordinates.move(Orientation("S"))('G') should be("E")
    Coordinates.move(Orientation("S"))('D') should be("O")
    Coordinates.move(Orientation("E"))('G') should be("N")
    Coordinates.move(Orientation("E"))('D') should be("S")
  }
}
