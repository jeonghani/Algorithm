def solution(wallpaper):
    lux, rdx = len(wallpaper), 0
    luy, rdy = len(wallpaper[0]), 0
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                lux = min(lux, i)
                rdx = max(rdx, i)
                
                luy = min(luy, j)
                rdy = max(rdy, j)
    
    return [lux, luy, rdx + 1, rdy + 1]