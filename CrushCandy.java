    private static String crushCandy(String input)
    {
        if (input == null || input.length() == 0)
        {
            return "";
        }
        final Stack<Character> characterStack = new Stack<>();
        final Stack<Integer> noOfConsicutiveChars = new Stack<>();
        
        for (int i=0; i<input.length(); i++)
        {
            char c = input.charAt(i);
            
            if (!characterStack.isEmpty() && characterStack.peek() == c)
            {
                noOfConsicutiveChars.push(noOfConsicutiveChars.pop() + 1);
            }
            else if (!characterStack.isEmpty() && characterStack.peek() != c && noOfConsicutiveChars.peek() >= 3)
            {
                characterStack.pop();
                
                if (!characterStack.isEmpty() && characterStack.peek() == c)
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