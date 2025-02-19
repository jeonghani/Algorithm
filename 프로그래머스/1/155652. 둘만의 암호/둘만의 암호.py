def solution(s, skip, index):
    answer = ''
    alphabet = [chr(i) for i in range(ord('a'), ord('z')+1)]
    valid_chars = [ch for ch in alphabet if ch not in skip]
    
    for i in s:
        char_index = valid_chars.index(i)
        new = valid_chars[(char_index+index)%len(valid_chars)]
        answer += new
    
    return answer