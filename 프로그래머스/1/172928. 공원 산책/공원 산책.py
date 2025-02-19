def solution(park, routes):
    H = len(park)
    W = len(park[0])
    x, y = 0, 0
    
    for i in range(H):
        for j in range(W):
            if park[i][j] == 'S':
                x, y = i, j
    
    direction = {
        "N": (-1, 0),
        "S": (1, 0),
        "W": (0, -1),
        "E": (0, 1)
    }
    
    for route in routes:
        d, n = route.split()
        n = int(n)
        
        nx, ny = x, y
        valid = True
        
        for _ in range(n):
            nx += direction[d][0]
            ny += direction[d][1]
            
            if not (0<=nx<H and 0<=ny<W) or park[nx][ny]=='X':
                valid = False
                break
        
        if valid:
            x, y = nx, ny
            
    return [x, y]