'''
문제 설명:
    수열 S가 어떤 수 S_k를 기준으로 S_1 < S_2 < ... S_k-1 < S_k > S_k+1 > ... S_N-1 > S_N을 만족한다면, 
    그 수열을 바이토닉 수열이라고 한다.

    예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만, {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

    수열 A가 주어졌을 때, 
    그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

제한 사항:
    시간 제한 1초
    메모리 제한 256MB
    1 ≤ N ≤ 1,000
    A의 원소 i : 1 ≤ A_i ≤ 1,000

문제 풀이:
    k를 기준으로 왼쪽에서는 증가하는 수열이고
    k를 기준으로 오른쪽은 감소하는 수열이다.

    k를 기준으로, 가장 긴 증가 수열을 만들고,가장 긴 감소 수열을 만들어 합치면 바이토닉이 된다.
    
    가장 긴 증가 수열을 만드는 방법

    if A[i] > A[j]:
        dp[i] = max(dp[i],dp[j]+1)
    
    가장 긴 감소 수열을 만드는 방법, 단 오른쪽 부터 거꾸로 시작
    하지만, 배열을 뒤집어 가장 긴 증가 수열 만드는 것과 동일하다.

    A = A[::-1]
    if A[i] > A[j]:
        dp[i] = max(dp[i],dp[j]+1)

    k를 기준으로, 가장긴 증감 수열의 인덱스 값을 더해주면, 바이토닉수열이 나온다.
    
'''

def solution(n,A):
    max_dp=[1]*n
    min_dp=[1]*n
    
    for i in range(n):
        for j in range(i):
            if A[i] > A[j]:
                max_dp[i] = max(max_dp[i], max_dp[j]+1)

    A = A[::-1]
    for i in range(n):
        for j in range(i):
            if A[i] > A[j]:
                min_dp[i] = max(min_dp[i], min_dp[j]+1)
    # print("오리지널:",A[::-1])
    # print("max_dp:",max_dp)
    # print("min_dp:",min_dp[::-1])
    # print("바이토닉:",[a+b for a,b in zip(max_dp,min_dp[::-1])])
    return max([a+b for a,b in zip(max_dp,min_dp[::-1])])-1

if __name__=="__main__":
    n = int(input())
    A = list(map(int,input().split()))
    print(solution(n,A))