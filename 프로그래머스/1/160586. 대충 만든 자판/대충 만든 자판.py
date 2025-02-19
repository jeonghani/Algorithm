def solution(keymap, targets):
    answer = []
    min_key = {}
    
    for keys in keymap:
        for i, char in enumerate(keys):
            if char in min_key:
                min_key[char] = min(min_key[char], i+1)
            else:
                min_key[char] = i+1
    
    for target in targets:
        total = 0
        for char in target:
            if char in min_key:
                total += min_key[char]
            else:
                total = -1
                break
        answer.append(total)
        
    return answer