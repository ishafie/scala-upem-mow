package fr.upem.projet

final case class Robot(coordinates: Coordinates, commands: Commands)


object Main extends App {


  override def main(args: Array[String]): Unit = {
    val bufferedReader = Parser.openFile("test.txt")
    if (bufferedReader.isEmpty) {
      println("not found")
      return;
    }
    Parser.parser(bufferedReader.get, bufferedReader.get.readLine)

  }
}
