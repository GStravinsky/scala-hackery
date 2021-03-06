package shekspearmonkeys

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class MonkeyTest extends AnyFlatSpecLike  with Matchers {

  val GUESS = "METHINKS HE IS LIKE A WEASEL"
  val GUESS_TWO = "METHINKS HEBIS LIKE A WEASEL"
  val testMonkey = Monkey(GUESS)
  val testComputer = Computer()

  it should "multiply the guesses " in {
    val guesses = testMonkey.copyAndMutate(GUESS)
    guesses.length shouldBe 100
  }

  it should "mutate the guess" in {
    val testProbs = Seq(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27)
    val mutated = testMonkey.mutateGuess(GUESS, testProbs)

    mutated.slice(5, GUESS.length) shouldBe GUESS.slice(5, GUESS.length)
    mutated.slice(0,4) should not be GUESS.slice(0, 4)
  }


  it should "pick the best string" in {
    val (bestGess, score) = testComputer.pickBestGuess(Seq(GUESS, GUESS_TWO))
    bestGess shouldBe GUESS
    score shouldBe 26
  }
}


