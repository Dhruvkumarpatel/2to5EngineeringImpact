/**
cerner_2^5_2020

BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees

This function validates that given binary tree is a binary search tree or not. It returns true if 
given tree is binary search tree, false otherwise.

For ex 1: 
	2
   / \
  1   3

Input: [2,1,3]
Output: true

EX 2:

	5	
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false	
Explanation: The root node's value is 5 but its right child's value is 4.
 
**/
public boolean isBST(Node root)
{
	final Stack<Node> stack = new Stack();
	
	Node current = root;
    int lastpopped = Integer.MIN_VALUE;
	
	while (true)
	{
		if (current != null)
		{
			stack.push(current);
			current = current.left;
		}
		else
		{
			if (stack.isEmpty())
			{
				break;
			}
			
			Node pop = stack.pop();
			
			if (pop.val < lastpopped)
			{
				return false;
			}
			lastpopped = pop.val;
		    current = pop.right;
		}	
	}
	
	return true;
}

