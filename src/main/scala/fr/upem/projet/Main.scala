package fr.upem.projet

import java.io.{BufferedReader, FileInputStream, FileReader}

object Main {

  def parser(bufferedReader: BufferedReader, line: String): Unit = {
    if (line == null)
      return line
    println(line)
    return parser(bufferedReader, bufferedReader.readLine())
  }

  def openFile(fileName: String) : Option[BufferedReader] = {
    try {
      val reader = Option(new BufferedReader(new FileReader(fileName)))
      return reader
    } catch {
      case e: Exception => None
    }
  }

  def main(args: Array[String]): Unit = {
    val bufferedReader = openFile("test.txt")
    if (bufferedReader.isEmpty) {
      println("not found")
      return ;
    }
    parser(bufferedReader.get, bufferedReader.get.readLine)

  }
}
