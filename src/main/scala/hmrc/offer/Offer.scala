package hmrc.offer

import main.scala.hmrc.product.{Apple, Orange, Product}


trait Offer {
  def calculateDiscount(items: List[Product]): BigDecimal
}

object Apple2For1Offer extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val apples = items.filter(_ match { case Apple => true case _ => false })
    val eligibleQuantity = apples.size - (apples.size % 2)
    (eligibleQuantity / 2) * Apple.price
  }
}

object Orange3For2Offer extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val oranges = items.filter(_ match { case Orange => true case _ => false})
    val eligibleQuantity = oranges.size - (oranges.size % 3)
    (eligibleQuantity / 3) * Orange.price
  }
}





