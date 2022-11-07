package Arrays;
/*
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
Accepted
2,410,253
Submissions
5,900,520
Seen this question in a real interview before?

Yes

No

Problems

 */
public class LeetcodeArray3 {
	public boolean isValid(String s) {
        return isParenthesesValid(s);
    }

    private static boolean isParenthesesValid(String s) {
        int currentIndex = -1;
        char[] stack = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (isOpen(s.charAt(i))) {
                stack[++currentIndex] = s.charAt(i);
            } else {
                if (currentIndex == -1) {
                    return false;
                }
                if (compensate(s.charAt(i), stack[currentIndex])) {
                    if ((--currentIndex) < -1) {
                        return false;
                    }
                } else {
                    return false; // the parenthesis is invalid.
                }
            }
        }
        return (currentIndex==-1);
    }

    private static boolean isOpen(char charAt) {
        switch (charAt) {
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private static boolean compensate(char charAt, char c) {
        if (charAt == ')' && c == '(') {
            return true;
        }
        if (charAt == '}' && c == '{') {
            return true;
        }
        if (charAt == ']' && c == '[') {
            return true;
        }
        return false;
    }
}


/*
 ({[[]])
 ()
*/