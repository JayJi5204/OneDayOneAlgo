"""
문제 설명:
    카운트 다운 게임이 시작되면 무작위로 점수가 정해지고, 다트를 던지면서 점수를 깎아서 정확히 0점으로 만드는 게임입니다.
    
    목표 점수 target이 매개변수로 주어졌을 때 최선의 경우 던질 다트 수와 그 때의 "싱글" 또는 "불"을 맞춘 횟수(합)를 순서대로 배열에 담아 return 
    
    다트 과녁에는 1 부터 20 까지의 수가 하나씩 있고 각 수마다 "싱글", "더블", "트리플" 칸이 있습니다.
    
        - "싱글"을 맞히면 해당 수만큼 점수를 얻고 
        - "더블"을 맞히면 해당 수의 두 배만큼 점수를 얻고 
        - "트리플"을 맞히면 해당 수의 세 배만큼 점수를 얻습니다. 
        - 가운데에는 "불"과 "아우터 불"이 있는데 "카운트 다운" 게임에서는 구분 없이 50점을 얻습니다.
        - 단, 남은 점수보다 큰 점수로 득점하면 버스트가 되며 실격 합니다.
    
    게임에서 승리하는 방법
        - 1. 최소한의 다트로 목표 점수를 0점으로 만드는게 가장 중요하고
        - 2. 그러한 방법이 여러가지 가 있다면 '싱글' 똔느 '불'을 최대한 많이 던지는 방법을 선택
    

문제 풀이:
    목표 점수가 58점일 때 만들 수 있는 경우:
        58 = 트리플 19(57) + 1(싱글)
        58 = 50 + 8(싱글)
        ...
    
    목표 점수가 50점 일 때 만들 수 있는 경우:
        50 = 불(50)
        트리플 10(30) + 20(싱글)
        ...
    
    경우를 살펴 보면 목표 점수는 자기 자신보다 낮은 수들로 분해 될 수 있다.
    위의 예시 처럼, 58을 생각해보면 58 = 50 + 8, 58 = 트리플 10(30) + 20으로 분해될 수 있다.
        - 50이 가진 정보는 [1,1] 8이 가진 정보는 [1,1] = [2,2] 
        - 트리플 10(30) 가진 정보는 [1,0], 20 [1,1] = [2,1]
        - 조건에 따라 싱글/불 점수가 높은 [2,2]가 선택된다.

    따라서 자기 자신 보다 낮은 수들이 가진 값들을 비교하는 점화식을 세운다면 문제를 해결할 수 있다.
    따라서 2차원 DP로 문제를 접근할 수 있고, 점화식은 아래와 같다.
        - dp[i] = min(dp[i][0] - dp[i - score][0]) 
        - if dp[i][0] == dp[i - score][0] -> dp[1] = max(dp[i],dp[i - score][1])

"""

def solution(target):

    valid_scores = []
    for i in range(1,21):
        valid_scores.append((i,1))
    valid_scores.append((50,1))
            
    
    for i in range(1,21):
        valid_scores.append((i*2,0))
        valid_scores.append((i*3,0))
    
    dp = [[float('inf'),0] for _ in range(target + 1)]
    dp[0] = [0,0]
    
    for i in range(1,target+1):
        for score,is_single_or_bull in valid_scores:
            prev_score = i - score
            
            if prev_score >= 0:
                count = dp[prev_score][0] + 1
                single_bull = dp[prev_score][1] + is_single_or_bull
                
                if count < dp[i][0]:
                    dp[i] = [count,single_bull]
                elif count == dp[i][0]:
                    if single_bull > dp[i][1]:
                        dp[i][1] = single_bull
                        
    return dp[target]