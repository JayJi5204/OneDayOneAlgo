"""
문제 설명:
    수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 리턴

    예를 들어, 
    수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 
    가장 긴 감소하는 부분 수열은 A = {10, **30**, 10, **20**, 20, **10**}  이고, 길이는 3이다.

문제 풀이:
    부분 수열은 기본적으로 이중 for문을 사용한 완전 탐색으로 나타낼 수 있고
    감소하는 수열인지 확인하는 과정에서 for문을 하나 더 사용하여 최종적으로 풀이할 수 있다.

    이 때, 시간복잡도는 1000^3 = 1000000000(10억)이므로 제한 시간 1초를 훌쩍 넘겨버리게 된다.

    따라서 이중 for문을 사용한 DP를 사용하여 접근해야 시간안에 풀이가 가능하다.
    
    가장 긴 감소 수열을 구하는 방법은, 각 인덱스를 마지막으로 하는 감소 수열을 저장하는 것이다.
        - dp[i] = max(dp[i],dp[j]+1)
"""

def solution(n,A):
    dp = [1]*(n+1)
    for i in range(n):
        for j in range(i):
            if A[i] < A[j]:
                dp[i] = max(dp[i],dp[j]+1)
    return max(dp)

if __name__=="__main__":
    import sys
    input = sys.stdin.readline
    n = int(input())
    A = list(map(int,input().split(' ')))
    print(solution(n,A))