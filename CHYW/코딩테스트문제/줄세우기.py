'''
문제 설명:
    번호를 가진 n 명의 아이가 번호에 상관없이 줄을 서 있다.
    아이들을 번호 순서대로 배치하기 위해 옮겨지는 아이의 최소 수를 리턴
    
    예) 3 7 5 2 6 1 4 -> 1 2 3 4 5 6 7
    

문제 풀이:
    가장 긴 증가 수열 사이에 이외의 수인 7,2,1,4만 자리에 맞게 옮겨주면 된다.

    3 7 5 2 6 1 4이 주어질 때
    3, 5, 6를 그대로 두고, 사이에 나머지수를 넣으면 최소로 옮길 수있다.

    가장 긴 부분증가수열을 구하는 방법은, 각 n을 마지막으로 하는 증가수열의 길이를 저장하는것이다.
    점화식은 다음과 같다.
        - dp[i] = max(dp[i],dp[j]+1)
'''
import sys

input = sys.stdin.readline
n = int(input())
kids =[int(input()) for _ in range(n)]

def solution(n,kids):
    dp = [1 for _ in range(n+1)]

    for i in range(n):
        for j in range(i):
            if kids[i] > kids[j]:
                dp[i] = max(dp[i],dp[j]+1)
    return n - max(dp)

if __name__=='__main__':
    print(solution(n,kids))