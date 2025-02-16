def solution(myString):
    answer = myString.split("x")
    return [len(n) for n in answer]