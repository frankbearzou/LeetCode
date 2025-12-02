class Solution:
    def minWindow(self, s: str, t: str) -> str:
        window, countT = {}, {}
        for c in t:
            countT[c] = countT.get(c, 0) + 1
        have, need = 0, len(countT)
        l = 0
        resStr, resLen = [-1, -1], float("inf")
        for r, c in enumerate(s):
            window[c] = window.get(c, 0) + 1
            if c in countT and window[c] == countT[c]:
                have += 1
            while have == need:
                if r - l + 1 < resLen:
                    resStr = [l, r]
                    resLen = r - l + 1
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
        if resLen == float("inf"):
            return ""
        l, r = resStr
        return s[l:r + 1]