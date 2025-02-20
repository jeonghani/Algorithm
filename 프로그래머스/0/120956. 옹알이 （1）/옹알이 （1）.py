def solution(babbling):
    answer = 0
    valid = ["aya", "ye", "woo", "ma"]
    
    for word in babbling:
        for sound in valid:
            word = word.replace(sound," ", 1)
        if word.strip() =="":
            answer+=1
    
    return answer