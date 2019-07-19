#This function takes as input a string and returns the palindrome substring
#which has the maximum length
#We use dynamic programming:
#opt(i,j): 1 if substring with i length that starts from j position is palindrome else 0
#opt(i,j) = opt(i-2,j+1) if s[j] == s[j+i-1] else 0
#Complexity: O(n^2)

def getMaxPalindromeSubstring(s):
    if s == '' or len(s) == 1:
        return s
    
    opt = []
    for i in range(len(s) + 1):
        array = []
        for j in range(len(s)):
            array.append(0)
        opt.append(array)

    for j in range(len(s)):
        opt[0][j] = opt[1][j] = 1
    maxSub = s[0]
    for i in range(2,len(s) + 1):
        for j in range(len(s)):
            if j + i <= len(s):
                if s[j] == s[j + i - 1] and opt[i - 2][j + 1] == 1:
                    opt[i][j] = 1
                    if len(s[j:j+i-1]) > len(maxSub):
                        maxSub = s[j:j+i]
                else:
                    opt[i][j] = 0
    
    return maxSub
