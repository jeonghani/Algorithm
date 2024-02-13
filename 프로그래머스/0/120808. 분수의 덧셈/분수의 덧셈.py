import math

def solution(numer1, denom1, numer2, denom2):
    a = denom1*denom2
    b = numer1*denom2 + numer2*denom1
    c = math.gcd(a, b)
    answer = [b/c, a/c]
    return answer