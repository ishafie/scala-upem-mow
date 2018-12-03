package fr.upem.projet

import fr.upem.projet.Parser.{DoubleLine, DoubleList}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class Test extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {
  "verify" should "verify if two lines are correct" in {
    Parser.verify(DoubleList(List("a", "b", "c"), List("abcddeg"))) should be(false)
  }
}
