package fr.upem.projet
import java.io.{BufferedReader, FileReader}

trait Parser {
  def parser(bufferedReader: BufferedReader, line: String)
  def openFile(fileName: String)
}


object Parser {
  case class DoubleList(firstline: List[String], secondline: List[String])
  case class DoubleLine(firstline: String, secondline: String)

  val verifyCoords: List[String] => Boolean = {
    case x :: Nil if x.matches("[SNEO]$") => verifyCoords(Nil)
    case x :: Nil => false
    case x :: xs if x.matches("[0-9]$") => verifyCoords(xs)
    case Nil => true
    case _ => false
  }

  val verify: DoubleList => Boolean = {
    case DoubleList(null, _) => false
    case DoubleList(_, null) => false
    case DoubleList(a, b) if a.length != 3 || b.length != 1 || !b.head.matches("[GDA]*$") || !verifyCoords(a) => false
    case DoubleList(_, _) => true
  }

  def parse_all_lines(bufferedReader: BufferedReader, doubleline: DoubleLine, area: Area): String = {
    doubleline match {
      case DoubleLine(null, _) => null
      case DoubleLine(_, null) => null
      case DoubleLine(firstline, secondline) if verify(DoubleList(firstline.split(" ").toList, secondline.split(" ").toList)) => {
        Robot.startRobot(secondline.split(" ").toList.head.toList, firstline.split(" ").toList, area)
        area.displayMap(area.areaTab)
        parse_all_lines(bufferedReader, DoubleLine(bufferedReader.readLine(), bufferedReader.readLine()), area)
      }
      case DoubleLine(_, _) => null
    }
  }

  def parser(bufferedReader: BufferedReader, line: String): String = {
    //A MODIFIER EN MIEUX
    if (line == null) {
      return "Mauvais fichier"
    }
    val coordArray = line split " "
    if (coordArray.length != 2 || !coordArray.head.matches("[1-9]+$") || !coordArray(1).matches("[1-9]+$")) {
      return "Mauvais fichier"
    }
    val coords = Coordinates.Point(coordArray(0).toInt, coordArray(1).toInt)
    val area = new Area{val areaTab: Array[Array[String]] = Array.ofDim[String](coords.y, coords.x)
      val coordinates: Coordinates.Point = coords
    }
    area.initMap(coords, area.areaTab)
    area.displayMap(area.areaTab)
    parse_all_lines(bufferedReader, DoubleLine(bufferedReader.readLine(), bufferedReader.readLine()), area)
  }

  def openFile(fileName: String) : Option[BufferedReader] = {
    try {
      val reader = Option(new BufferedReader(new FileReader(fileName)))
      reader
    } catch {
      case e: Exception => None
    }
  }
}
