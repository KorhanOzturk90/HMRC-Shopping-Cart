package hrmc

import hmrc.offer.{Apple2For1Offer, Orange3For2Offer}
import hmrc.service.DealShoppingCart
import main.scala.hmrc.product.{Apple, Orange}
import org.scalatest.FlatSpec

class DealShoppingCartSpec extends FlatSpec {
  var dealShoppingCart = new DealShoppingCart(List(Apple2For1Offer, Orange3For2Offer))

  "Shopping basket with ten apples " should "cost £3.0 with the deal" in {
    assert(dealShoppingCart.checkout(List.fill(10)(Apple)) == BigDecimal("3.00"))
  }

  "Shopping basket with 3 oranges " should "cost £0.5 with the deal" in {
    assert(dealShoppingCart.checkout(List.fill(3)(Orange)) == BigDecimal("0.50"))
  }

  "Shopping basket with 2 oranges " should "cost £0.5 with the deal" in {
    assert(dealShoppingCart.checkout(List.fill(2)(Orange)) == BigDecimal("0.50"))
  }

  "Shopping basket with 1 apple " should "cost £0.6 with the deal" in {
    assert(dealShoppingCart.checkout(List(Apple)) == BigDecimal("0.60"))
  }

  "Shopping basket with 10 apples 6 oranges " should "cost £4 with the deal" in {
    val oranges = List.fill(6)(Orange)
    val apples = List.fill(10)(Apple)
    assert(dealShoppingCart.checkout(apples ::: oranges) == BigDecimal("4.00"))
  }

  "Shopping basket with 11 apples 8 oranges " should "cost £4 with the deal" in {
    val oranges = List.fill(8)(Orange)
    val apples = List.fill(11)(Apple)
    assert(dealShoppingCart.checkout(apples ::: oranges) == BigDecimal("5.10"))
  }
}
