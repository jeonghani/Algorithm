def solution(s):
    answer = []
    li = s.split(' ')
    for i in li:
        word = ''.join([char.upper() if idx%2==0 else char.lower() for idx, char in enumerate(i)])
        answer.append(word)
    return ' '.join(answer)