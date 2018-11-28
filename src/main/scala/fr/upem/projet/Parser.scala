package fr.upem.projet
import java.io.{BufferedReader, FileReader}

trait Parser {
  def parser(bufferedReader: BufferedReader, line: String);
  def openFile(fileName: String);
}


object Parser {

  def parse_all_lines(bufferedReader: BufferedReader, line: String): String = {
    if (line == null)
      return line
    println(line)
    parse_all_lines(bufferedReader, bufferedReader.readLine())
  }

  def parser(bufferedReader: BufferedReader, line: String): String = {
    //println("ATTENTION FIRST LINE : " + line + "| " + line.length)
    if (line.length != 3) {
      "Mauvais fichier"
    }
    val coordArray = line split(" ")
    val coordinates = Coordinates.Point(coordArray(0).toInt, coordArray(1).toInt)
    println("MY HEIGHT: " + coordinates.y)
    println("MY WIDTH: " + coordinates.x)
    //val program = Program(coordinates, area)
    parse_all_lines(bufferedReader, bufferedReader.readLine())
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
