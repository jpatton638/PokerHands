case class Scoring(cards : Seq[Card]) {
  def reasons: String =
    s"with high card: ${Card.valueName(Scoring.calculate(cards))}"

}

object Scoring {
  def calculate(cards: Seq[Card]): Int = {
    cards.foldLeft(0){ (acc, cur) =>
      acc.max(cur.value)
    }
  }

}

