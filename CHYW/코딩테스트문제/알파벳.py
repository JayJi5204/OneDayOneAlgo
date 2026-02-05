'''
문제 설명:
    세로 
    R칸, 가로
    C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고,
    좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

    말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

    좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지 리턴
    말이 지나는 칸은 좌측 상단의 칸도 포함된다.

제한 사항:
    시간 제한 2초
    메모리 제한 256MB
    (1 ≤ R,C ≤ 20)

문제 풀이:
    R,C가 20 이하 이므로 dfs로 완전 탐색을 할 때 시간 복잡도는 O(n^2) 이므로 제한 시간안에 통과할 수 있다.
    따라서 dfs로 진행.
    중복 알파뱃은 방문처리하여 더 이상 진행하지 않도록 조건을 준다.

    bfs로도 풀이가 가능하다. bfs는 특정 경로를 따라가는게 아닌 주변을 따라가기 때문에
    dfs처럼 특정 경로를 알 수 있도록 path를 따로 선언해주면 된다. 
'''

from collections import defaultdict
dy,dx = [1,0,-1,0],[0,1,0,-1]
answer = 0

def dfs(y,x,board:list[list],visited:defaultdict,cost=0):
    global answer
    answer = max(answer,cost)

    for i in range(4):
        yy = y + dy[i]
        xx = x + dx[i]
        
        if 0<=yy<len(board) and 0<=xx<len(board[0]):
            if visited.get(board[yy][xx],0) == 0:
                visited[board[yy][xx]]=1
                dfs(yy,xx,board,visited,cost+1)
                visited[board[yy][xx]]=0

    return

def bfs(y,x,board):
    answer = 0
    q = set()
    q.add((y,x,board[y][x]))

    while q:
        y,x,visited= q.pop()
        answer = max(answer,len(visited))
        for i in range(4):
            yy = y + dy[i]
            xx = x + dx[i]

            if 0<=yy<len(board) and 0<=xx<len(board):
                if board[yy][xx] not in visited:
                    q.add((yy,xx,visited+board[yy][xx]))

    return answer

def solution(board):
    visited = defaultdict(int)
    visited[board[0][0]]=1
    dfs(0,0,board,visited,1)
    print(answer)
    return


if __name__=="__main__":
    r,c = list(map(int,input().split()))
    board = [list(map(str,input())) for _ in range(r)]
    # solution(board)
    print(bfs(0,0,board))