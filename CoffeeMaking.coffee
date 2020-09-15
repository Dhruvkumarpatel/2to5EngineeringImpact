#cerner_2^5_2020
# coffee script to make coffee based on coffee type and necessary ingredients.

noOfCoffee = 0;
coffee_powder = 100.0
milk = 1;
water = 2;
type = "BLACK"

if coffee_powder <= 10
   console.log("not sufficient ingredients avilable")
   
   console.log(type + " Coffee is getting ready")
   coffee_powder = coffee_powder - 10
        
if type != "MILK"
    water = water - 0.2
else 
    milk = milk - 0.2
    
noOfCoffee++;
console.log(type + "Coffee is ready")