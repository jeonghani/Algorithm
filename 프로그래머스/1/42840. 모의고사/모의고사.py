def solution(answers):
    pattern_1 = [1,2,3,4,5]
    pattern_2 = [2,1,2,3,2,4,2,5]
    pattern_3 = [3,3,1,1,2,2,4,4,5,5]
    score = [0, 0, 0]
    for i, answer in enumerate(answers):
        if answer == pattern_1[i%len(pattern_1)]:
            score[0] += 1
        if answer == pattern_2[i%len(pattern_2)]:
            score[1] += 1
        if answer == pattern_3[i%len(pattern_3)]:
            score[2] += 1
    return [i+1 for i in range(3) if score[i]==max(score)]