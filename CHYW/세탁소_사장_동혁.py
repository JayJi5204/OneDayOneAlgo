def main():
    '''
    거스름돈: C가 주어졌을 때
    쿼터, 다임, 니켈, 페니의 개수를 최소로 구하기
    
    쿼터: 0.25
    다임: 0.1
    니켈: 0.05
    페니: 0.01

    최대한 높은 값들로 먼저 처리한다.
    greedy 알고리즘
    '''

    C = int(input())

    answer = [0]*4

    for i,cost in enumerate([25,10,5,1]):
        answer[i]=C//cost
        C = C%cost

    print(*answer)

    return

if __name__=='__main__':
    main()