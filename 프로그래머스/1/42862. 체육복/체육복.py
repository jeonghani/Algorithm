def solution(n, lost, reserve):
    answer = 0
    
    lost_set = set(lost)
    reserve_set = set(reserve)
    
    lost_set -= reserve_set
    reserve_set -= set(lost)
    
    lost_set = sorted(lost_set)
    reserve_set = sorted(reserve_set)
    
    for i in lost_set:
        if (i - 1) in reserve_set:
            reserve_set.remove(i-1)
        elif (i+1) in reserve_set:
            reserve_set.remove(i+1)
        else:
            answer+=1
            
    return n-answer