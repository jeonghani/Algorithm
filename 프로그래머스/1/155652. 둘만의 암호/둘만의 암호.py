def solution(s, skip, index):
    answer = ''
    alphabet = [chr(i) for i in range(ord('a'), ord('z')+1)]
    valid = [ch for ch in alphabet if ch not in skip]
    
    for i in s:
        char_index = valid.index(i)
        change_index = (char_index+index) % len(valid)
        answer += valid[change_index]
    return answer