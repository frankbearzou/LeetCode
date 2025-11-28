class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        l = 0
        m = {}
        for r, c in enumerate(s):
            while c in m:
                del m[s[l]]
                l += 1
            m[c] = r
            res = max(res, r - l + 1)
        return res