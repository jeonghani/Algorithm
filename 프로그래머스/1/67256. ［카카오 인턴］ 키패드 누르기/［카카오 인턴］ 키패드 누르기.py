def solution(numbers, hand):
    answer = ''
    
    keypad = {
        1: (0, 0), 2: (0, 1), 3: (0, 2),
        4: (1, 0), 5: (1, 1), 6: (1, 2),
        7: (2, 0), 8: (2, 1), 9: (2, 2),
        0: (3, 1)
    }
    
    left = (3, 0)
    right = (3, 2)
    
    for number in numbers:
        if number in [1, 4, 7]:
            answer += 'L'
            left = keypad[number]
        elif number in [3, 6, 9]:
            answer += 'R'
            right = keypad[number]
        else :
            number_position = keypad[number]
            left_distance = abs(number_position[0]-left[0])+abs(number_position[1]-left[1])
            right_distance = abs(number_position[0]-right[0])+abs(number_position[1]-right[1])
            if left_distance < right_distance:
                answer += 'L'
                left = keypad[number]
            elif left_distance > right_distance:
                answer += 'R'
                right = keypad[number]
            else:
                if hand == 'left':
                    answer += 'L'
                    left = keypad[number]
                else :
                    answer += 'R'
                    right = keypad[number]
    
    return answer