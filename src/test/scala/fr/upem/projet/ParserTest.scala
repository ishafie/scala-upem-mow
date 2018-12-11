package fr.upem.projet

import java.io.BufferedReader

import fr.upem.projet.Parser.DoubleList
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class ParserTest extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {
  "verify" should "verify if two lines are correct" in {

    Parser.verify(DoubleList(List("11", "12", "N"), List("GAGAGAGAA"))) should be(true)
    Parser.verify(DoubleList(List("1", "1", "O"), List("AADAADADDA"))) should be(true)
    Parser.verify(DoubleList(List("0", "0", "E"), List("AAAAAAAAAA"))) should be(true)
    Parser.verify(DoubleList(List("5", "2", "S"), List("G"))) should be(true)

    Parser.verify(DoubleList(null, List("GAGAGAGAA"))) should be(false)
    Parser.verify(DoubleList(List("11", "12", "N"), null)) should be(false)
    Parser.verify(DoubleList(null, null)) should be(false)
    Parser.verify(DoubleList(List("GAGAGAGAA"), List("GAGAGAGAA"))) should be(false)
    Parser.verify(DoubleList(List("a", "b", "c"), List("abcddeg"))) should be(false)

  }

  "verifyCoords" should "verify if the orientation and coordinates are correct" in {
    Parser.verifyCoords(List("1", "1", "N")) should be(true)
    Parser.verifyCoords(List("12", "18", "O")) should be(true)
    Parser.verifyCoords(List("101", "91", "E")) should be(true)
    Parser.verifyCoords(List("0", "0", "S")) should be(true)

    Parser.verifyCoords(List("-1", "1", "N")) should be(false)
    Parser.verifyCoords(List("12", "18", "W")) should be(false)
    Parser.verifyCoords(List("A", "1", "N")) should be(false)
  }

  "openFile" should "return an error if the file doesnt exist" in {
    val bufferReader = Parser.openFile("test.txt")
    bufferReader should not be empty
  }

  /*"parseAllLines" should "return 'Mauvais Fichier' or the good coordinates" in {
    ???
  }*/

  //orientation avec enum
}