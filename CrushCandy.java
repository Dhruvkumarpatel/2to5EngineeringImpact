    /**
        cerner_2^5_2020

        Function to crush candy in one dimensional board. In candy crushing games, groups of like items are removed from the board. 
        In this problem, any sequence of 3 or more like items should be removed and any items adjacent to that sequence should now be considered adjacent to each other.
        For Example :

        Input: "aabbccddeeedcba"
        Output: ""
        Explanation:
        1. Remove 3 'e': "aabbccddeeedcba" => "aabbccdddcba"
        2. Remove 3 'd': "aabbccdddcba" => "aabbcccba"
        3. Remove 3 'c': "aabbcccba" => "aabbba"
        4. Remove 3 'b': "aabbba" => "aaa"
        5. Remove 3 'a': "aaa" => ""
    **/
    private static String crushCandy(String input)
    {
        final Stack<Character> characterStack = new Stack<>();
        final Stack<Integer> noOfConsicutiveChars = new Stack<>();
        
        for (int i=0; i<input.length(); i++)
        {  
            if (!characterStack.isEmpty() && characterStack.peek() == input.charAt(i))
            {
                noOfConsicutiveChars.push(noOfConsicutiveChars.pop() + 1);
            }
            else if (!characterStack.isEmpty() && characterStack.peek() != input.charAt(i) && noOfConsicutiveChars.peek() >= 3)
            {
                characterStack.pop();
                
                if (!characterStack.isEmpty() && characterStack.peek() == input.charAt(i))
                {
                    noOfConsicutiveChars.push(noOfConsicutiveChars.pop() + 1);
                }
                else
                {
                    characterStack.push(c);
                    noOfConsicutiveChars.push(1);
                }
            }
            else
            {
                characterStack.push(c);
                noOfConsicutiveChars.push(1);
            }
        }
        
        if (!characterStack.isEmpty() && noOfConsicutiveChars.peek() >= 3)
        {
            characterStack.pop();
        }
        
        String result = "";

        while(!characterStack.isEmpty())
        {
            result = characterStack.pop() + result;
        }
        
        return result;
    }