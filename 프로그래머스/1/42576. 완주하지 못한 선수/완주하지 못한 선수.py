from collections import Counter

def solution(participant, completion):
    p_count = Counter(participant)
    c_count = Counter(completion)
    
    for p in p_count:
        if p_count[p] != c_count[p]:
            return p