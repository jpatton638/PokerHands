case class Card(suit: Char, value: Int) extends Ordered[Card] {
  def max(card: Card): Card =
    if(this.value > card.value) this else card

  override def compare(that: Card): Int =
    this.value - that.value
}

object Card {
  def apply(input: String): Card = {
    val suitOfCard = input.last

    val valueOfCard =
      if (Character.isDigit(input.head)) {
        val dig = Integer.parseInt(input.head.toString)
        if(dig > 1) dig
        else
          throw new IllegalArgumentException(s"$dig is not a valid card value")
      } else {
        input.head.toUpper match {
          case 'T' => 10
          case 'J' => 11
          case 'Q' => 12
          case 'K' => 13
          case 'A' => 14
          case _ => throw new IllegalArgumentException (s"invalid argument ${input.head}")
        }
      }
    Card(suitOfCard, valueOfCard)
  }

  def valueName(value: Int): String = {
    value match {
      case 14 => "Ace"
      case 13 => "King"
      case 12 => "Queen"
      case 11 => "Jack"
      case _ => value.toString
    }
  }
}
