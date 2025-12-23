'''
Docstring for 코딩테스트문제.연속펄스부분수열의합

연속되는 구간의 합을 구하는 문제이다.
n >= 500,000이므로 누적합으로 접근해야한다.

'''
def solution(sequence):
    answer = int(-1e9)
    
    n = len(sequence)
    s1 = s2 = 0
    s1_min = s2_min = 0
    pulse = 1
    
    for i in range(n):
        s1 += sequence[i] * pulse
        s2 += sequence[i] * (-pulse)
        
        answer = max(answer,s1-s1_min,s2-s2_min)
        
        s1_min = min(s1_min,s1)
        s2_min = min(s2_min,s2)
        pulse*=-1
    return answer