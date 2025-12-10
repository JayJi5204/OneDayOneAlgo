'''
기지국을 최소로 설치하면서 모든 아파트에 전파를 전달하는 것이 목표
기지국의 전파 도달 범위는 w

제한사항:
N:200,000,000
stations의 크기: 10,000 이하의 자연수
w:10,000 이하의 자연수

풀이:
가장 간단한 방법은 모든 구간을 w범위로 나누어 주면된다.
하지만 기지국이 설치된 구간은 제외해야 한다.
따라서 기지국이 전파하는 구간을 제외한, 각 구간의 길이를 w범위로 나눠서 개수 카운트
'''
import math

def solution(n, stations, w):
    answer = 0
    
    bandwiths = [] 
    
    for i in range(1,len(stations)):
        bandwiths.append((stations[i]-w-1)-(stations[i-1]+w))
    bandwiths.append(stations[0]-w-1) #맨앞
    bandwiths.append(n-(stations[-1]+w)) #맨뒤
    
    for bandwith in bandwiths:
        if bandwith > 0:
            answer+=math.ceil(bandwith/(2*w+1))
    
    return answer