package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class LeetcodeArray2 {
	/*public int romanToInt(String s) {
	       int answer=0;
	        for(int i=0;i<s.length();i++){
	            
	            if(s.charAt(i)=='I'){
	                
	                if(i<s.length()-1 && s.charAt(i+1)=='V'){
	                    answer+=4;
	                    i++;
	                    
	                }else if(i<s.length()-1 && s.charAt(i+1)=='X'){
	                    answer+=9;
	                    i++;
	                }else{
	                    answer+=1;
	                }
	            } else if(s.charAt(i)=='V'){
	               answer+=5; 
	            } else if(s.charAt(i)=='X'){
	                
	                if(i<s.length()-1 && s.charAt(i+1)=='L'){
	                    answer+=40;
	                    i++;
	                }else if(i<s.length()-1 && s.charAt(i+1)=='C'){
	                    answer+=90;
	                    i++;
	                }else{
	                    answer+=10;
	                }
	            } else if(s.charAt(i)=='L'){
	               answer+=50; 
	            }else  if(s.charAt(i)=='C'){
	                
	                if(i<s.length()-1 && s.charAt(i+1)=='D'){
	                    answer+=400;
	                    i++;
	                }else if(i<s.length()-1 && s.charAt(i+1)=='M'){
	                    answer+=900;
	                    i++;
	                }else{
	                    answer+=100;
	                }
	                
	            }else if(s.charAt(i)=='D'){
	               answer+=500; 
	            }else  if(s.charAt(i)=='M'){
	                answer+=1000;
	            }
	        }
	        return answer;
	    }*/
	//Using HAshmap
	public int romanToInt(String s) {
		int answer=0;
		Map<Character, Integer> hashMap=new HashMap<Character, Integer>();
		populate(hashMap);
		
		for(int i=0;i<s.length();i++) {
			if(i<s.length()-1 && hashMap.get(s.charAt(i))<hashMap.get(s.charAt(i+1))){
				//If character value ahead is greater than current character value then 
				//subtract ahead  value by current
				answer+=hashMap.get(s.charAt(i+1))-hashMap.get(s.charAt(i));
				i++;
			}else {
				answer+=hashMap.get(s.charAt(i));
			}
		}
		
		return answer;
		
	}
	

	private void populate(Map<Character, Integer> hashMap) {
		hashMap.put('I', 1);
		hashMap.put('V', 5);
		hashMap.put('X', 10);
		hashMap.put('L', 50);
		hashMap.put('C', 100);
		hashMap.put('D', 500);
		hashMap.put('M', 1000);
		
	}


	public static void main(String[] args) {
		LeetcodeArray2 la2=new LeetcodeArray2();
		int answer=la2.romanToInt("MCMXCIV");
		System.out.println(answer);
		//ans:1994

	}

}
