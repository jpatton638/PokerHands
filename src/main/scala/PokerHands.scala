import scala.io.Source

object PokerHands extends App {

  def readResource(fileName:String) =
    Source.fromResource(fileName).getLines()

  readResource("inputs.txt").foreach(println)
}
