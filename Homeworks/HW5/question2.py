from collections import deque

class Node:
	def __init__(self, value, left, right):
		self.value = value
		self.left = left
		self.right = right
	
	def __str__(self):
		return self.value

def traverse(root): #traverse the tree in back in forward using a deque
   # if root reached then return empty
    if root is None:
        return []

    #init   
    dq = deque([root])
    ans = []
    #indicate starting direction to be right
    isLeft = False
    
    while dq:
        #for each level traverse depending on direction
        for i in range(len(dq)):
            
            # If isleft dequeue from front
            if isLeft:
                curr = dq.popleft()
                
            # else dequeue from back
            else:
                curr = dq.pop()
            
            # Push current to answer list
            ans.append(curr.value)
            
            # If direction isleft enqueue right the left node and right node.
            if isLeft:
                if curr.left:
                    dq.append(curr.left)
                if curr.right:
                    dq.append(curr.right)
            
            # else enqueue left the right node and leftnode.
            else:
                if curr.right:
                    dq.appendleft(curr.right)
                if curr.left:
                    dq.appendleft(curr.left)
        
        #alternate the direction for next level in tree
        isLeft = not isLeft
    
    return ans

# #testing
# node9 = Node("Node9", None, None)
# node10 = Node("Node10", None, None)
# node7 = Node("Node7", None, None)
# node8 = Node("Node8", node9, node10)
# node5 = Node("Node5", None, None) 
# node6 = Node("Node6", node7, node8)
# node3 = Node("Node3", None, None)  
# node4 = Node("Node4", node5, node6)
# node1 = Node("Node1", node3, node4)
# node2 = Node("Node2", None, None)  
# root = Node("Root", node1, node2)

# for v in traverse(root):
# 	print(v)