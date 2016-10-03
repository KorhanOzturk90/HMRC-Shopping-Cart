package main.scala.hmrc.service

import main.scala.hmrc.product.Product

class BasicShoppingCart extends Cart {

  override def checkout(items: List[Product]) = items.foldLeft(BigDecimal(0)) { (price, product) =>
    product.price + price
  }

}
