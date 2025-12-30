'''
부분 문자열에서 가장 긴 팰린드롬의 길이를 리턴하는 문제
1. 부분 문자열을 구함
2. 팰린드롬인지 확인
'''
def isPalindrom(subString):
    return subString == subString[::-1]

def solution(s):
    answer = 0
    n = len(s)
    for i in range(n):
        for j in range(i+1,n+1):
            subString = s[i:j]
            if isPalindrom(subString):
                answer = max(answer,len(subString))
    return answer