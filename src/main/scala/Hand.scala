sealed trait Hand

case object NoHand extends Hand
case class HighCard(highest: Card, hand: Seq[Card]) extends Hand
case class Pair(i: Int) extends Hand
case class TwoPair(i: Int, j: Int) extends Hand
case class ThreeOfAKind(i: Int) extends Hand
case class Straight(start: Int, size: Int) extends Hand
case class Flush(suit: Char, size: Int, cards: Seq[Card]) extends Hand
case class FullHouse(small: Pair, large: ThreeOfAKind) extends Hand
case class FourOfAKind(i: Int) extends Hand
case class StraightFlush(from: Int, to: Int, suit: Char) extends Hand

case class ComboHand(hand1: Hand, hand2: Hand) extends Hand

object Hand {

//  Could use implicit ordering of hands to get winner
//  implicit val handOrdering: Ordering[Hand] = Ordering

  def merge(a: Hand, b: Hand): Hand = {
    (a, b) match {
      case (NoHand, other) => other
      case (other, NoHand) => other
      case(left @ (_: StraightFlush | _: FourOfAKind | _: FullHouse | Flush(_, 5, _) | Straight(_, 5)), _) => left
      case(_, right @ (_: StraightFlush | _: FourOfAKind | _: FullHouse | Flush(_, 5, _) | Straight(_, 5))) => right
      case (Flush(suit, size, fHand), HighCard(_, hand))
        if hand.exists(_.suit == suit) => Flush(suit, size+1, hand ++ fHand)
      case (Flush(_, _, fHand), HighCard(highest, hand)) =>

        val newHand = hand ++ fHand

        HighCard(
          newHand.foldLeft(highest){ (acc, cur) =>
            acc.max(cur)
          }, newHand
        )

//      case (Straight(_, _), HighCard(_, _))
    }
  }
}