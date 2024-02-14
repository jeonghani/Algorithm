def solution(array):
    answer = 0
    set_arr = set(array)
    
    max_count = 0
    for i in set_arr :
        count = array.count(i)
        if max_count < count :
            answer = i
            max_count = count
        elif max_count == count :
            answer = -1
    return answer