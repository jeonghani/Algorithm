import re

def solution(dartResult):
    matches = re.findall(r'(\d{1,2})([SDT])([*#]?)', dartResult)
    score_list = []
    for i, (score, bonus, option) in enumerate(matches):
        score = int(score)
        
        if bonus == 'S':
            score **= 1
        elif bonus == 'D':
            score **= 2
        elif bonus == 'T':
            score **= 3
        
        if option == '*':
            score *= 2
            if i>0:
                score_list[i-1] *= 2
        elif option == '#':
            score *= -1
        
        score_list.append(score)
            
    return sum(score_list)