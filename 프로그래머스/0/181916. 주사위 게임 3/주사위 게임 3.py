def solution(a, b, c, d):
    dice = [a, b, c, d]
    dice_dict = dict()
    
    for n in dice:
        if n not in dice_dict:
            dice_dict[n] = 1
        else:
            dice_dict[n] += 1
    
    dice_dict = sorted(dice_dict, key=lambda x:dice_dict[x])
    print(dice_dict)
    
    if len(dice_dict) == 1:
        answer = 1111 * a
    elif len(dice_dict) == 2:
        if dice.count(dice_dict[0]) in [1, 3]:
            answer = (10 * dice_dict[1] + dice_dict[0]) ** 2
        else:
            answer = (dice_dict[0] + dice_dict[1]) * abs(dice_dict[0] - dice_dict[1])
    elif len(dice_dict) == 3:
        answer = dice_dict[0] * dice_dict[1]
    else:
        answer = min(dice)

    return answer