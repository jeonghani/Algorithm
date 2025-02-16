def solution(picture, k):
    answer = []
    
    for row in picture:
        expand=''
        
        for x in row:
            expand += x*k
        for _ in range(k):
            answer.append(expand)
    
    return answer