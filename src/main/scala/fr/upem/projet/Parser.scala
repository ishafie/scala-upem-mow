package fr.upem.projet
import java.io.{BufferedReader, FileReader}

trait Parser {
  def parser(bufferedReader: BufferedReader, line: String)
  def openFile(fileName: String)
}


object Parser {

  def parse_all_lines(bufferedReader: BufferedReader, firstline: String, area: Area): String = {
    if (firstline == null)
      return firstline
    val secondline = bufferedReader.readLine()
    if (secondline == null)
      return secondline

    val coords = firstline.split(" ").toList
    val commands = secondline.split(" ").toList
    println(commands)
    // A TRANSFORMER EN CASE CLASS TOUS LES IF
    if (coords.length != 3) {
      println("Mauvais fichier")
      return null
    }
    if (commands.length != 1 || !commands.head.matches("[GDA]*$")) {
      println("Mauvais fichier")
      return null;
    }
    Robot.startRobot(commands, coords, area)
    area.displayMap(area.areaTab)
    parse_all_lines(bufferedReader, bufferedReader.readLine(), area)
  }

  def parser(bufferedReader: BufferedReader, line: String): String = {
    //println("ATTENTION FIRST LINE : " + line + "| " + line.length)
    if (line.length != 3) {
      "Mauvais fichier"
    }
    val coordArray = line split " "
    val coords = Coordinates.Point(coordArray(0).toInt, coordArray(1).toInt)
    /*println("MY HEIGHT: " + coordinates.y)
    println("MY WIDTH: " + coordinates.x)*/
    val area = new Area{val areaTab = Array.ofDim[String](coords.y, coords.x)
      val coordinates: Coordinates.Point = coords
    }
    area.initMap(coords, area.areaTab)
    area.displayMap(area.areaTab)
    parse_all_lines(bufferedReader, bufferedReader.readLine(), area)
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
