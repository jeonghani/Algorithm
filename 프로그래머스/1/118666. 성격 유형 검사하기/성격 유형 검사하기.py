def solution(survey, choices):
    answer = ''
    
    scores = {'R':0, 'T':0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0}
    score_map = {
        1: 3,
        2: 2,
        3: 1,
        4: 0,
        5: 1,
        6: 2,
        7: 3
    }
    
    for i in range(len(survey)):
        personality_1, personality_2 = survey[i][0], survey[i][1]
        choice = choices[i]
        
        score = score_map[choice]
        
        if choice < 4:
            scores[personality_1] += score
        else:
            scores[personality_2] += score
    print(scores)
    if scores['R'] >= scores['T']:
        answer += 'R'
    else :
        answer += 'T'
    if scores['C'] >= scores['F']:
        answer += 'C'
    else :
        answer += 'F'
    if scores['J'] >= scores['M']:
        answer += 'J'
    else : 
        answer += 'M'
    if scores['A'] >= scores['N']:
        answer += 'A'
    else :
        answer += 'N'
    
    return answer