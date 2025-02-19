def solution(s):
    answer = 0
    start = 0 
    
    while start < len(s):
        first = s[start]
        x_count = 0
        other_count = 0
        end = start
        
        while end < len(s):
            if s[end] == first:
                x_count += 1
            else:
                other_count += 1
            
            if x_count == other_count:
                answer += 1 
                start = end + 1 
                break
            
            end += 1
        
        if end == len(s):
            answer+=1
            break
    
    return answer
