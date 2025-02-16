def solution(rank, attendance):
    a, b, c = -1, -1, -1
    
    for i in range(1, len(rank)+1):
        if a == -1 and attendance[rank.index(i)]:
            a = rank.index(i)
        elif b == -1 and attendance[rank.index(i)]:
            b = rank.index(i)
        elif c == -1 and attendance[rank.index(i)]:
            c = rank.index(i)
            break
    
    return 10000 * a + 100 * b + c