import org.scalatest.{MustMatchers, WordSpec}

class CardSpec extends WordSpec with MustMatchers {

  "2 of clubs returns with the value two" in {
    assert(Card("2C").value == 2)
  }

  "Jack of clubs returns the value of 11" in {
    assert(Card("JC").value == 11)
  }

  "1 of clubs should thrown an Illegal Argument Exception" in {
    assertThrows[IllegalArgumentException](Card("1C"))
  }

  "invalid special character should throw an Illegal Argument Exception" in {
    assertThrows[IllegalArgumentException](Card("BC"))
  }

}
