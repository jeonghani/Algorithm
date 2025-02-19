def solution(schedules, timelogs, startday):
    answer = 0
    
    for i in range(len(schedules)):
        h, m = divmod(schedules[i], 100)
        m+=10
        
        if m>=60:
            h += 1
            m -= 60
        
        schedules[i] = int(f"{h:02d}{m:02d}")
    
    for i in range(len(timelogs)):
        valid = True
        for j in range(7):
            weekday = (startday + j - 1) % 7 + 1
            if weekday in (6, 7):
                continue
            if schedules[i] < timelogs[i][j]:
                valid = False
                break
        if valid:
            answer += 1
                        
    return answer