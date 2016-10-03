package hmrc.service

import hmrc.offer.Offer
import main.scala.hmrc.product.Product
import main.scala.hmrc.service.{BasicShoppingCart, Cart}

class DealShoppingCart(offers: List[Offer] = Nil) extends Cart {
  override def checkout(selectedItems: List[Product]): BigDecimal = {

    /*val apples = selectedItems.filter(_ match { case Apple => true case _ => false })
    val oranges = selectedItems.filter(_ match { case Orange => true case _ => false })
    val appleSavings = apples.take(apples.size / 2).map(_.price).sum
    val orangeSavings = oranges.size / 3 * Orange.price*/

    var totalDiscount = BigDecimal("0.0")
    for (offer <- offers) {
      totalDiscount += offer.calculateDiscount(selectedItems)
    }

    val defaultCheckout = new BasicShoppingCart
    defaultCheckout.checkout(selectedItems) - totalDiscount

  }
}
