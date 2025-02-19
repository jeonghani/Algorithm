def solution(players, callings):
    player_rank = {player: i for i, player in enumerate(players)}
    
    for call in callings:
        idx = player_rank[call]
        
        if idx > 0:
            players[idx], players[idx-1] = players[idx-1], players[idx]
            player_rank[players[idx]] = idx
            player_rank[players[idx-1]] = idx-1
    
    return players