class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0
        s = set(nums)
        for num in s:
            if num - 1 not in s:
                step = 1
                while num + step in s:
                    step += 1
                res = max(res, step)
        return res