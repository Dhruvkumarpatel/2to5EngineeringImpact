
class TreeNode:
  def __init__(self, value):
      self.val = value
      self.left = None
      self.right = None
      
      
def insert(root, value):
    if root is None:
        return TreeNode(value)
    else:
        if root.val > value:
            root.left = insert(root.left, value)
        elif root.val < value:
            root.right = insert(root.right, value)
        else:
            return root
    return root

# validate Binary search Tree and return true if it is binary search tree otherwise false.
# This is the actual function intended for cerner_2^5_2020
def isBST(root):
    stack = []
    
    previous = -1
    
    while True:
        if root != None:
            stack.append(root)
            root = root.left
        else:
            
            if len(stack) == 0:
                break
            
            root = stack.pop()
            
            if root.val <= previous:
                return False
            
            previous = root.val
            root = root.right
    
    return True
            
      
  
root = TreeNode(50)
root = insert(root, 30)  
root = insert(root, 20)  
root = insert(root, 40)  
root = insert(root, 70)  
root = insert(root, 60)  
root = insert(root, 80)

print(isBST(root))