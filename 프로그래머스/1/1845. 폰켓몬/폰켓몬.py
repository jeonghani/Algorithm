def solution(nums):
    sets = set(nums)
    print(nums)
    return min(len(sets), len(nums)//2)