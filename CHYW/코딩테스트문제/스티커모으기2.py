'''
스티커 한장을 뜯어내면 양쪽으로 인접해있는 스티커는 찢어져서 사용할 수 없다.

스티커 합의 최댓값을 리턴하는 방법은 완전탐색, DP가 있다.
완전탐색으로 진행하기엔 N(<=100,000)이 너무 크기에 DP로 접근한다.

고려해야할 경우의 수는 2가지,
스티커를 뜯었을 경우, 스티커를 뜯지 않았을 경우

뜯는 경우, 스티커 합이 최댓값이기 때문에 뜯는다.
뜯지 않는 경우, 바로 전까지의 스티커 합이 최댓값이기에 뜯지 않는다.

새로 들어온 수 + 2칸 전까지의 최적의 값, 1칸 전의 최적의 값

따라서 점화식을 아래와 같이 세울 수 있다.

dp[i] = max(dp[i-1],dp[i-2] + sticker[i])
'''
def solution(sticker):
    answer = 0
    n = len(sticker)
    
    if n == 1: return sticker[0]
    
    dp1 = [0]*n
    dp1[0] = sticker[0]
    dp1[1] = sticker[0]
    
    for i in range(2,n-1):
        dp1[i] = max(dp1[i-1],dp1[i-2] + sticker[i])
    
    dp2 = [0]*n
    dp2[0] = 0
    dp2[1] = sticker[1]
    
    for i in range(2,n):
        dp2[i] = max(dp2[i-1],dp2[i-2] + sticker[i])

    return max(dp1[-2],dp2[-1])