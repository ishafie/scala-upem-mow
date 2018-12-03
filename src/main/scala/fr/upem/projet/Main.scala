package fr.upem.projet

import Parser._;


object Main extends App {


  override def main(args: Array[String]): Unit = {
    val bufferedReader = Parser.openFile("test.txt")
    if (bufferedReader.isEmpty) {
      println("not found")
    } else {
      Parser.parser(bufferedReader.get, bufferedReader.get.readLine)
    }

  }
}
