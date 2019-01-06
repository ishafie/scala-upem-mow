package fr.upem.projet

trait Coordinates

object Coordinates {

  trait Show[S] {
    def show(s: S): String
  }

  case class Point(x: Int, y: Int)
  case class Orientation(orientation: String)

  implicit val pointShow: Show[Coordinates.Point] = (point: Coordinates.Point) => "x: " + point.x + ", y: " + point.y

  val move: Orientation => Char => String = orientation => c => orientation match {
      //should use enum
    case Orientation("O") if c.equals('G') => "S"
    case Orientation("O") if c.equals('D') => "N"
    case Orientation("N") if c.equals('G') => "O"
    case Orientation("N") if c.equals('D') => "E"
    case Orientation("S") if c.equals('G') => "E"
    case Orientation("S") if c.equals('D') => "O"
    case Orientation("E") if c.equals('G') => "N"
    case Orientation("E") if c.equals('D') => "S"
    case _ => "unknown"
  }

  def print[A](a: A)(implicit ev: Show[A]): Unit = println(ev.show(a))
}
