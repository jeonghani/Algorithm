def solution(s, n):
    answer = []
    for char in s:
        if char.isupper():
            new = chr((ord(char)-ord('A')+n)%26+ord('A'))
            answer.append(new)
        elif char.islower():
            new = chr((ord(char)-ord('a')+n)%26+ord('a'))
            answer.append(new)
        else:
            answer.append(char)
    return ''.join(answer)