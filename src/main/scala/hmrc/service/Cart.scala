package main.scala.hmrc.service

import main.scala.hmrc.product.Product

trait Cart {

  def checkout(selectedItems : List[Product] ) : BigDecimal
}
