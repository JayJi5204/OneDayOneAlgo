class Node:
    def __init__(self,data):
        self.data=data
        self.right=None
        self.left=None

class BinarySearchTree:
    def __init__(self,root):
        self.root=Node(root)
    
    def __contains__(self,data):
        node= self.root
        while node:
            if node.data == data:
                return True
            elif node.data > data:
                node = node.left
            else:
                node = node.right
        return False

    def insert(self,data):
        node = self.root
        while True:
            if data < node.data:
                if node.left != None:
                    node = node.left
                else:
                    node.left = Node(data)
                    break
            else:
                if node.right != None:
                    node = node.right
                else:
                    node.right = Node(data)
                    break

    def search(self,data):
        node = self.root
        while node:
            if node.data == data:
                return True
            elif node.data > data:
                node = node.left
            else:
                node = node.right
        return False

    def get_leftmost(self,node:Node):
        while node.left:
            node = node.left
        return node

    def _delete(self,node:Node,data):
        if node is None:
            return
        if node.data > data:
            node.left = self._delete(node.left,data)
        elif node.data < data:
            node.right = self._delete(node.right,data)
        else:
            if node.left and node.right:
                leftmost = self.get_leftmost(node.right)
                node.data = leftmost.data
                node.right = self._delete(node.right, leftmost.data)
                return node
            
            if node.left:
                return node.left
            else:
                return node.right
        return node
    
    def delete(self,data):
        self.root = self._delete(self.root,data)
        
    def preorder(self):
        def _preorder(node:Node):
            if node is None:
                return
            res.append(node.data)
            _preorder(node.left)
            _preorder(node.right)
        res = []
        _preorder(self.root)
        return res
    
    def inorder(self):
        def _inorder(node:Node):
            if node is None:
                return
            _inorder(node.left)
            res.append(node.data)
            _inorder(node.right)
        res = []
        _inorder(self.root)
        return res
    
    def postorder(self):
        def _postorder(node:Node):
            if node is None:
                return
            _postorder(node.left)
            _postorder(node.right)
            res.append(node.data)
        res = []
        _postorder(self.root)
        return res


if __name__=="__main__":
    arr = [50,30,24,5,28,45,98,52,60]
    bst = BinarySearchTree(arr[0])
    for i in range(1,len(arr)):
        bst.insert(arr[i])

    print(bst.preorder())
    print(bst.inorder())
    print(bst.postorder())
    