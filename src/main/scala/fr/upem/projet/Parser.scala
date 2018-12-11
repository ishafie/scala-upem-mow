package fr.upem.projet
import java.io.{BufferedReader, FileReader, Reader}

import Implicits._

import scala.util.{Failure, Success, Try}

trait Parser {
  def parser(bufferedReader: BufferedReader, line: String)
  def openFile(fileName: String)
}
object Implicits {

  implicit class SafeBufferedReader(val s: BufferedReader) {
    def safeReadLine: Option[String] = Option(s.readLine())
  }

}

object Parser {
  case class DoubleList(firstline: List[String], secondline: List[String])
  case class DoubleLine(firstline: Option[String], secondline: Option[String])



  val verifyCoords: List[String] => Boolean = {
    case x :: Nil if x.matches("[SNEO]$") => verifyCoords(Nil)
    case x :: Nil => false
    case x :: xs if x.matches("[0-9]+$") => verifyCoords(xs)
    case Nil => true
    case _ => false
  }

  val verify: DoubleList => Boolean = {
    case DoubleList(null, _) => false
    case DoubleList(_, null) => false
    case DoubleList(a, b) if a.length != 3 || b.length != 1 || !b.head.matches("[GDA]*$") || !verifyCoords(a) => false
    case DoubleList(_, _) => true
  }



  def parseAllLines(bufferedReader: BufferedReader, doubleline: DoubleLine, area: Area): String = {
    doubleline match {
      case DoubleLine(firstline, secondline) if firstline.isDefined && secondline.isDefined && verify(DoubleList(firstline.get.split(" ").toList, secondline.get.split(" ").toList)) => {
        Robot.startRobot(secondline.get.split(" ").toList.head.toList, firstline.get.split(" ").toList, area)
        area.displayMap(area.areaTab)
        parseAllLines(bufferedReader, DoubleLine(bufferedReader.safeReadLine, bufferedReader.safeReadLine), area)
      }
      case DoubleLine(_, _) => null
    }
  }

  def parser(bufferedReader: BufferedReader, coordArray: Array[String]): String = {
    if (coordArray.length == 2 && coordArray.head.matches("[1-9]+$") && coordArray(1).matches("[1-9]+$")) {
      val coords = {
        Coordinates.Point(coordArray(0).toInt.+(1), coordArray(1).toInt + 1)
      }
      val area = new Area {
        val areaTab: Array[Array[String]] = Array.ofDim[String](coords.y, coords.x)
        val coordinates: Coordinates.Point = coords
      }
      area.initMap(coords, area.areaTab)
      area.displayMap(area.areaTab)
      return parseAllLines(bufferedReader, DoubleLine(bufferedReader.safeReadLine, bufferedReader.safeReadLine), area)
    }
    "Mauvais fichier"
  }

  def openFile(fileName: String) : Option[BufferedReader] = {
    val reader = Try(Option(new BufferedReader(new FileReader(fileName))))
    reader match {
      case Success(v) => Success(v).value
      case Failure(e) => println("Fichier introuvable/impossible à ouvrir")
        Option.empty
    }
  }
}
