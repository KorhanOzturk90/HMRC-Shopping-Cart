# Checkout System

This is a simple implementation of a checkout system for fruits (Apple and Orange). The system scans the items in the shopping cart
and calculates and displays the output at the checkout.

Note that there are two ways of calculating the total cost of the shopping:

 - First one, `BasicShoppingCart` is the sum of standard price of each fruit,

 - Second one, `DealShoppingCart` takes into account *current deals on the offer* such as
 
    * buy one, get one free on Apples
    * 3 for the price of 2 on Oranges.

Use sbt tool command for compiling, running, and testing the application.