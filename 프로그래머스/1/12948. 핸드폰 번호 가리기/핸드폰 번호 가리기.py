def solution(phone_number):
    answer = ['*' for i in range(len(phone_number)-4)]
    print(answer)
    answer += phone_number[-4:]
    return ''.join(answer)