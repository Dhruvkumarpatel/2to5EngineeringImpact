=begin

cerner_2^5_2020
Function to check if the number is Happy Number or not.
A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

=end
def isHappyNumber(n)
    
    def add_split(num)
        arr = num.to_s.split("")
        arr.map do |str|
            str.to_i ** 2
        end.sum
    end
    
    i = add_split(n)
    
    until i == 1 || i == 4
        i = add_split(i)
    end
    
    i == 1 ? true : false 
    
end
puts isHappyNumber(19);