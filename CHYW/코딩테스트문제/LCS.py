'''
문제 설명:
    LCS(Longest Common Subsequence, 최장 공통 부분 수열) 문제는 두 수열이 주어졌을 때,
    두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

    예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

제한 사항:
    시간 제한 0.1초
    메모리 제한 256 MB
    문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자

문제 풀이:
    예를 살펴 보자, 
    ACAYKP와 CAPCAK의 공통 부분 수열이 ACAK인 것을 보면

    주어진 첫 번쨰 문자열을 s1, 두 번째 문자열을 s2라고 했을 때 s1을 기준으로 잡고 s2에 문자를 하나씩 늘려가면서 비교한다.
    s1:  A A  A   A    A     A     
    s2:  C CA CAP CAPC CAPCA CAPCAK
    next:C A  AP  AC   AA    AK 
    LCS:   A  A   A    A     A      
    LCS: 0 1  1   1    1     1     

    s1:  AC AC AC  AC   AC    AC
    s2:  C  CA CAP CAPC CAPCA CAPCAK
    next:C  A  AP  AC   ACA   ACK
    LCS: C  C  A   AC   AC    AC
    LCS: 1  1  1   2    2     2     

    s1:  ACA ACA ACA  ACA   ACA    ACA
    s2:  C   CA  CAP  CAPC  CAPCA  CAPCAK
    next:C   A   AP   AC    ACA    ACAK
    LCS: C   C   A    AC    ACA    ACA
    LCS: 1   1   1    2     3      3

    과정을 다시 설명하면 아래와 같다.
    s2에 문자 하나를 계속 이어 붙여가면서 기준(s1)과 비교 한다.
    붙인 문자열이 기준안에 포함되면 LCS를 업데이트한다.
    이전의 LCS를 재활용하면서 과정을 반복한다.

    위 과정을 통해 문제에서 말하는 부분 수열은 원래의 문자열 집합에서 여러개로 쪼개어져 반복됨. (Optimal Substructure)
    여기서 가장 길이가 큰 LCS가 다음 LCS를 계산할 때 그대로 반영됨.(Overlapping Subproblem)

    DP의 조건을 충분히 만족함.

    위의 과정은 2차원 형태를 띄고 있으므로 행렬로 나타낼수 있다.
    
      A C A Y K P
    C 0 1 1 1 1 1
    A 1 1 2 2 2 2
    P 1 1 2 2 2 3
    C 1 2 
    A 1 2
    K 1 2

    s1 = ACA , s2 = CA 는 AC,C에서 A,A를 붙인것과 같다. LCS가 갱신되었으므로 ACA,A 에서 +1 이 때 값= 2
    마찬가지로
    s1 = ACAY, s2 = CA 는 ACA,C에서 Y,A를 붙인것과 같다. 이 때 LCS는 ACA,AC로 갱신되지 않았으므로, 이전 값을 그대로 가져져온다.
    행렬을 살펴 보면 이전의 최댓 값이 꼭 왼쪽에 있는것은 아니고 위쪽에도 있으므로, 아래와 같이 점화식을 세울 수 있다.
    
    비교한 문자가 같은 경우
        dp[i][j] = dp[i-1][j-1]+1
    같지 않을 경우
        dp[i][j] = max(dp[i][j-1],dp[i-1][j])


'''

def solution(A,B):
    dp = [[0]*(len(B)+1) for _ in range(len(A)+1)]

    for i in range(1,len(A)+1):
        for j in range(1,len(B)+1):
            if A[i-1] == B[j-1]:
                dp[i][j] = dp[i-1][j-1]+1
            else:
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])

    return dp[-1][-1]

if __name__=="__main__":
    A = list(input())
    B = list(input())
    print(solution(A,B))