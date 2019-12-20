import org.scalatest.{MustMatchers, WordSpec}

class ScoringSpec extends WordSpec with MustMatchers {

  "2C is less than 4D" in {
    val c2 = Seq(Card('C', 2))
    val d4 = Seq(Card('D', 4))

    val score1 = Scoring.calculate(c2)
    val score2 = Scoring.calculate(d4)

    score2 must be > score1
  }

  "compare two hands of two cards" in {
    val cards1 = Seq(Card('C', 2), Card('D', 4))
    val cards2 = Seq(Card('C', 8), Card('D', 14))

    val score1 = Scoring.calculate(cards1)
    val score2 = Scoring.calculate(cards2)

    score2 must be > score1
  }

  "score must return winning card" in {
     val cards = Seq(Card('C',2), Card('H', 8))
    val score = Scoring(cards)
    score.reasons mustBe "with high card: 8"
  }


  "score must return winning card when Face Card" in {
    val cards = Seq(Card('C',2), Card('H', 12))
    val score = Scoring(cards)
    score.reasons mustBe "with high card: Queen"
  }

  "return winning pair" in {
    val cards = Seq(Card('H',2), Card('C', 2))
    val score = Scoring(cards)
    score.reasons mustBe "with pair: 2"
  }


}
