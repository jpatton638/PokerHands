import org.scalatest.{MustMatchers, WordSpec}

class PokerHandsSpec extends WordSpec with MustMatchers {

  "readResource returns all lines of the input document" in {
    PokerHands.readResource("inputs.txt").length mustBe 4
  }

}
