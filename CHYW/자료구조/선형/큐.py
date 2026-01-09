class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class Que:
    def __init__(self):
        """
        큐는 선입선출 방식으로 작동
        한쪽에 자료를 넣으면 반대편에서 먼저 들어간 자료부터 나오는 구조
        """
        self.front = None
        self.rear = None

    def enqueue(self,data):
        """
        노드 삽입 (enqueue):
        큐가 비어 있다면 front와 rear가 모두 새 노드를 가리킨다.
        큐가 비어 있지 않다면, rear.next가 새 노드를 가리키게 하고, rear를 새 노드로 옮긴다.
        """
        
        if self.front is None:
            self.front = self.rear = Node(data)
        else:
            node = Node(data)
            self.rear.next = node
            self.rear = node
        
    
    def dequeue(self):
        """
        노드 제거 (dequeue):
        노드를 제거하고 큐가 비게 되면 front와 rear 모두 None으로 설정한다.
        큐에 노드가 남아 있으면 front를 front.next로 옮긴다.
        """

        if self.front is None:
            return None
        
        node = self.front
        if self.front == self.rear:
            self.front = self.rear = None
        else:
            self.front = self.front.next
        
        return node.data

    def is_empty(self):
        return self.front is None