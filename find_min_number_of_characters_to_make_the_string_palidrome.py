#this program finds the minimum number of characters
#we need to add to the string so it becomes palindrome

#to do that we need to find the maximum palindrome substring
#that starts from 0 position or from the last position

def find_min_number_of_characters_to_make_the_string_palidrome(s):
    for i in range(len(s)):
        if is_palindrome(s[i:]) or is_palindrome(s[0:len(s) - i]):
            return i

def is_palindrome(s):
    if s == '':
        return True
    if s[0] != s[len(s) - 1]:
        return False
    return is_palindrome(s[1:len(s) - 2])
