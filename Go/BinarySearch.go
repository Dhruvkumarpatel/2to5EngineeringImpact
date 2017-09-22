// cerner_2^5_2017

package main
import "fmt"

func isNumberPresent(num int, arrayOfNumbers[] int, length int) bool{
	var low, high = 0, length - 1
	var mid int;
	var result bool;
	
	 for high >= low{
		mid = (low+high) / 2

		if arrayOfNumbers[mid] == num{
			result = true
			break;
		}
		
		if arrayOfNumbers[mid] < num{
			low = mid + 1
		}
		
		if arrayOfNumbers[mid] > num{
			high = mid - 1
		}
	}
	
	if (result == true){
		return result
	}else{
		return false
	}
}

func main() {  
  var num int = 5
  var arrayOfNumbers = []int {2,5,7,8,9}
  var output bool
  output = isNumberPresent(num, arrayOfNumbers, 5)
  fmt.Printf("True if number presnt otherwise false: %v\n", output )
}
