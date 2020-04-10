
import org.scalatest.{BeforeAndAfterAll, FlatSpec, GivenWhenThen, Matchers}

class SodukoTest  extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfterAll {

  behavior of "Soduko"

  it should "return true when put a number in a position that follow the rules" in {
    Given("a position valid in the board")
    val x=2
    val y=0
    val number=2

    When("put in the board")
    val isValid=Sudoku.checkPosition(x,y,number)

    Then("the result must be the true")
    isValid shouldBe true
  }

  it should "return true when put a number in a row 0 where this number doesn't exists without checking avalaibility" in {
    Given("a position valid in the row")
    val x=2
    val y=0
    val number=2

    When("put in the board")
    val isValid=Sudoku.checkRowRepetition(x,y,number)

    Then("the result must be the true")
    isValid shouldBe true
  }

  it should "return true when put a number in a row 0 where this number doesn't exists" in {
    Given("a position valid in the row")
    val x=2
    val y=0
    val number=2

    When("put in the board")
    val isValid=Sudoku.checkRow(x,y,number)

    Then("the result must be the true")
    isValid shouldBe true
  }

  it should "return false when put a number in a row 0 that already has this number" in {
    Given("a position valid in the row")
    val x=2
    val y=0
    val number=3

    When("put in the board")
    val isValid=Sudoku.checkRow(x,y,number)

    Then("the result must be the false")
    isValid shouldBe false
  }

  it should "return true when put a number in any row where this number doesn't exists" in {
    Given("a position valid in the row")
    val x=1
    val y=1
    val number=3

    When("put in the board")
    val isValid=Sudoku.checkRow(x,y,number)

    Then("the result must be the true")
    isValid shouldBe true
  }

  it should "return false when put a number in a row that already has this number" in {
    Given("a position valid in the row")
    val x=1
    val y=1
    val number=1

    When("put in the board")
    val isValid=Sudoku.checkRow(x,y,number)

    Then("the result must be the false")
    isValid shouldBe false
  }

  it should "return false when put a number in a position already occupied" in {
    Given("a position valid in the row")
    val x=1
    val y=0
    val number=2

    When("put in the board")
    val isValid=Sudoku.checkRow(x,y,number)

    Then("the result must be the false")
    isValid shouldBe false
  }

  it should "return true when the position is available" in {
    Given("a position available")
    val x=2
    val y=0


    When("put in the board")
    val isAvailable=Sudoku.checkPositionAvalaibility(x,y)

    Then("the result must be the true")
    isAvailable shouldBe true
  }

  it should "return false when the position is not available" in {
    Given("a position not available")
    val x=3
    val y=1


    When("put in the board")
    val isAvailable=Sudoku.checkPositionAvalaibility(x,y)

    Then("the result must be the false")
    isAvailable shouldBe false
  }

  it should "return false when the position is repeated in the 3x3 square without checking avalaibility first square" in {
    Given("a value that already exists in the square")
    val x=1
    val y=1
    val value=9


    When("put in the board")
    val isValid=Sudoku.checkSquare(x,y,value)

    Then("the result must be the false")
    isValid shouldBe false
  }

  it should "return false when the position is repeated in the 3x3 square without checking avalaibility other square" in {
    Given("a value that already exists in the square")
    val x=7
    val y=7
    val value=7


    When("put in the board")
    val isValid=Sudoku.checkSquare(x,y,value)

    Then("the result must be the false")
    isValid shouldBe false
  }

}