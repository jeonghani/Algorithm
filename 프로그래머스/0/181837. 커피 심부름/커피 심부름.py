def solution(order):
    answer = 0
    
    for i in order:
        if i == "anything" or "americano" in i:
            answer+=4500
        else:
            answer+=5000
    
    return answer