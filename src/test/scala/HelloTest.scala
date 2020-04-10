import org.scalatest.{BeforeAndAfterAll, FlatSpec, GivenWhenThen, Matchers}
import Greeter.greet

class HelloTest extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfterAll {

  behavior of "Hello"

  it should "return hello <username>" in {
    Given("the user name")
    val username="John"

    When("greeting")
    val greeting=greet(username)

    Then("the greeting must be the expected")
    greeting shouldBe s"Hello $username"
  }

}
