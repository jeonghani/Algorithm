def solution(myString, pat):
    myString = ''.join(["B" if s == "A" else "A" for s in myString])
    return 1 if pat in myString else 0