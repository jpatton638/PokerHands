case class Card(suit: Char, value: Int)

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
}
