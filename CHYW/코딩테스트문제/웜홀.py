"""
문제 설명:
    월드 나라에는 N개의 지점이 있고 N개의 지점 사이에는 M개의 도로와 W개의 웜홀이 있다.(단 도로는 방향이 없으며 웜홀은 방향이있다.)
    웜홀은 시작 위치에서 도착 위치로 가는 하나의 경로인데, 특이하게도 도착을 하게 되면 시작을 하였을 때보다 시간이 뒤로 가게된다. 
    웜홀 내에서는 시계가 거꾸로 간다고 생각하여도 좋다.

    시간 여행을 매우 좋아하는 백준이는 한 가지 궁금증에 빠졌다. 
    한 지점에서 출발을 하여서 시간여행을 하기 시작하여 다시 출발을 하였던 위치로 돌아왔을 때보다 시간이 되돌아가는 있는 경우가 있는지 없는지 판단해야한다.

    시간이 줄어들면서 출발 위치로 돌아오는 것이 가능하면 YES, 불가능하면 NO를 출력

제한 사항:
    시간 제한 2초
    메모리 제한 128MB
    N(1 ≤ N ≤ 500)
    M(1 ≤ M ≤ 2500)
    W(1 ≤ W ≤ 200)
    도로는 방향이 없으며(양방향) 웜홀은 방향이있다.(단방향)

문제 풀이:
    도로로 이동하게 되면 시간이 증가하지만, 웜홀을 통해 이동했을 경우 시간이 줄어든다.
    즉, 음의 가중치를 포함하고 있으므로, 벨만포드 알고리즘을 적용하면 된다.
    출발하였을 때 보다 시간이 되돌아가는 경우가 있는지 판단해야하므로 음의 사이클이 있는지 없는지만 확인하면 된다.

    1. 벨만포드 알고리즘을 구현한다.
    2. 모든 노드에서 그래프를 탐색을 시작하며 음의 사이클이 발견될 경우 중단한다.
    3. 발견된 경우 YES를 아니라면 NO를 출력한다.
"""

def bellmanford(n,start,edges):
    dist = [int(1e9)]*(n+1)
    dist[start]=0
    for i in range(n):
        for s,e,t in edges:
            if dist[e] > dist[s] + t:
                dist[e] = dist[s] + t
                if i == n-1:
                    return "YES"
    return "NO"

def solution():
    T = int(input())
    for _ in range(T):
        n,m,w = map(int,input().split())
        edges = []

        for _ in range(m):
            s,e,t = map(int,input().split())
            edges.append((e,s,t))
            edges.append((s,e,t))
        for _ in range(w):
            s,e,t = map(int,input().split())
            edges.append((s,e,-t))

        print(bellmanford(n,1,edges))

if __name__=="__main__":
    solution()