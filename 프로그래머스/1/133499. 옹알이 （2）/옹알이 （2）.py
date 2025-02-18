def solution(babbling):
    answer = 0
    valid = ['aya', 'ye', 'woo', 'ma']
    
    for word in babbling:
        prev = ''
        is_valid = True
        
        while word:
            found = False
            for sound in valid:
                if word.startswith(sound):
                    if sound == prev:
                        is_valid = False
                        break
                    prev = sound
                    word = word[len(sound):]
                    found = True
                    break
            if not found:
                is_valid = False
                break

        if is_valid:
            answer+=1
    
    return answer