'''
n >= 1,000,000,000 이므로 O(n) 또는 O(nlogn)으로 접근해야함
이분 탐색으로 진행시 nlog으로 접근할 수 있다.

1. 임의의 시간 동안 몇 명이 심사 받을 수 있는지 확인하고 이 값을 최소로 만들기
2. 시간의 최소,최대 범위를 구하고 중간 값이 n명을 심사 할 수 있는 시간인지 확인하며 이분 탐색을 진행
3. 중간 값 시간 동안
4. n명 보다 많이 심사 가능 -> 중간값 기준 왼쪽 범위 탐색
5. n명 보다 적게 심사 가능 -> 중간값 기준 오른쪽 범위 탐색
6. 임의의 시간동안 몇명을 심사할 수 있는지 확인하는 방법
'''

def binarySearch(n,left,right,times):
    answer = 0
    
    while left <= right:
        mid = (left + right) // 2
        checked = 0
        
        for time in times:
            checked += mid // time
            #모든 심사관을 거치지 않아도 mid분 동안 n명 이상의 심사를 할 수 있다면 반복문을 나간다.
            if checked >= n:
                break
            #심사한 사람의 수가 심사 받아야할 사람의 수(n)보다 많거나 같은 경우
        if checked >= n:
            answer = mid
            right = mid -1
        elif checked < n:
            left = mid + 1
    return answer

def solution(n, times):
    left = min(times)
    right = max(times)*n
    
    return binarySearch(n,left,right,times)