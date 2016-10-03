package main.scala.hmrc.product

sealed trait Product {
  def name: String

  val price: BigDecimal
}

case object Apple extends Product {
  override def name: String = "Apple"

  override val price: BigDecimal = 0.60
}

case object Orange extends Product {
  override def name: String = "Orange"

  override val price: BigDecimal = 0.25
}

