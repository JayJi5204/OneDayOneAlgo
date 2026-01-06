class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
    
class LinkedList:
    def __init__(self):
        self.head = None
        self.length = 0
    
    def __len__(self):
        return self.length

    def appendleft(self,data):
        """
        Adds a new node with the specified data at the beginning of the list.
        """
        if self.head is None:
            self.head = Node(data)
        else:
            node = Node(data)
            node.next = self.head
            self.head = node
        self.length += 1
    
    def append(self,data):
        """
        Adds a new node with the specified data at the end of the list.
        """
        if self.head is None:
            self.head = Node(data)
        else:
            node = self.head
            while node.next is not None:
                node = node.next
            node.next = Node(data)
        self.length += 1
    
    def popleft(self):
        """
        Pop and returns the first node's data from the list.
        """
        if self.head is None:
            return None

        node = self.head
        self.head = self.head.next
        self.length -= 1

        return node.data

    def pop(self):
        """
        Pop and returns the last node's data from the list.
        """
        
        if self.head is None:
            return None
        
        node = self.head
        while node.next is not None:
            prev = node
            node = node.next

        if node == self.head:
            self.head = None
        else:
            prev.next = None
        
        self.length -= 1

        return node.data
    
    
    def remove(self,target):
        """
        Removes the first occurrence of a node with the specified target data.
        """

        node = self.head
        while node is not None and node.data != target:
            prev = node
            node = node.next

        if node is None:
            return False

        if node == self.head:
            self.head = self.head.next
        else:
            prev.next = node.next
        
        self.length -= 1

        return True
    
    def insert(self,position,data):

        if position < 0 or position > self.length:
            raise IndexError("Index out of bounds")
        
        node = self.head
        for i in range(position - 1):
            node = node.next
        new_node = Node(data)
        new_node.next = node.next
        node.next = new_node
    def __contains__(self, target):
        if self.head is None:
            return False
        
        node = self.head
        while node is not None:
            if node.next == target:
                return True
            node = node.next

        return False

    def __str__(self):
        if self.head is None:
            return "Linked list is empty!"
        res = "Head"
        node = self.head
        while node is not None:
            res += " -> " + str(node.data)
            node = node.next
        return res
    
    def __repr__(self):
        return f"""
        연결리스트를 재귀를 사용해 만든 구현체
        """