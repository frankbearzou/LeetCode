class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        l = 0
        m = {}
        for r, c in enumerate(s):
            if c in m:
                l = m.get(c) + 1
                del m[c]
            m[c] = r
            res = max(res, r - l + 1)
        return res