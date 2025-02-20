def solution(bandage, health, attacks):
    t, x, y = bandage
    cur_health = health
    success_time = 0
    attack_dict = {time: damage for time, damage in attacks}
    
    for sec in range(1, attacks[-1][0]+1):
        if sec in attack_dict:
            cur_health -= attack_dict[sec]
            success_time = 0
            if cur_health <= 0 :
                return -1
        else:
            cur_health = min(health, cur_health + x)
            success_time += 1
            if success_time == t:
                cur_health = min(health, cur_health + y)
                success_time = 0
    
    return cur_health