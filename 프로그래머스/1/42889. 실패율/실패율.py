def solution(N, stages):
    answer = []
    player = [0] * (N+1)
    players = len(stages)
    print(players)
    
    for i in stages:
        if i<=N:
            player[i] += 1
    
    failure = []
    
    for i in range(1, N+1):
        if players == 0:
            failure_rate = 0
        else:
            failure_rate = player[i]/players
        failure.append((i, failure_rate))
        players -= player[i]
    
    failure.sort(key=lambda x:x[1], reverse=True)
    
    for i in failure:
        answer.append(int(i[0]))
    
    return answer