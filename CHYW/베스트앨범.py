from collections import defaultdict

'''

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려고 합니다,
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1.가장 많이 재생된 장르먼저 수록
2.장르내에서 많이 재생된 노래 먼저 수록
3.고유 번호가 낮은 노래를 먼저 수록

베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 리턴

아이디어:
규칙에 따라 움직이면 된다.

1. 장르별로 재생된 횟수를 딕셔너리에 저장
2. 장르별로 재생된 노래 리스트를 딕셔너리에 저장
3. 장르별 재생 횟수를 기준으로 내림차순 정렬
4. 정렬된 장르별로 재생된 노래 리스트를 재생 횟수 기준으로 내림차순 정렬


'''

def solution(genres, plays):
    answer = []
    
    play_list = defaultdict(list)
    genre_count = defaultdict(int)
    
    n=len(genres)
    for i in range(n):
        genre_count[genres[i]]+=plays[i]
        play_list[genres[i]].append((plays[i],i))
    
    genre_count = sorted(genre_count.items(),key=lambda x:x[1],reverse=True)
    
    for k,v in genre_count:
        play_list[k].sort(key=lambda x:(x[0],-x[1]),reverse=True)
        answer.extend(play_list[k][:2])
        
    
    return [i[1] for i in answer]