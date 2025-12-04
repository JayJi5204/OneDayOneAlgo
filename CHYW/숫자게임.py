'''
모든 사원이 무작위로 자연수를 하나씩 부여받습니다.
각 사원은 딱 한 번씩 경기를 합니다.

전체 사원들은 우선 무작위로 자연수를 하나씩 부여받는다.

규칙은 숫자가 큰 쪽이 승리, 이긴 쪽이 승점 1점 얻는다.
B팀이 얻을 수 있는 최대 승점을 리턴하는 것이다.

A,B의 길이는 100,000만 이하
원소는 1,000,000,000 이하의 자연수를 가지고 있다.

완전 탐색을 진행할 경우 O(100,000^2)가 되므로 다른 접근을 해야함
O(nlogn)으로 풀이하면 통과

힙을 사용하면
for문 하나에 n
탐색 log n
시간복잡도는 O(nlogn)이므로 통과 가능

힙을 사용하며 A팀의 가장 작은 수를 뽑고
B팀에서 A팀의 수보다 큰 수를 뽑으면 B팀의 승점 1점 획득

따라서 최대한 적은 차이로 이긴다면 최대 승점을 얻을 수 있다.
greedy 알고리즘으로 볼 수 있다.

'''
import heapq

def solution(A, B):
    answer = 0
    heapq.heapify(A)
    heapq.heapify(B)
    while A and B:
        a = heapq.heappop(A)
        while B:
            b = heapq.heappop(B)
            if a < b:
                answer+=1
                break
    
    return answer