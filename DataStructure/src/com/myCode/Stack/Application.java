package com.myCode.Stack;


import java.util.HashMap;

/**
 * @Author: qdd
 * @Date: 2019/10/28 10:40
 * @Description: 栈应用实例  来自 https://leetcode-cn.com/problems/valid-parentheses/ 第20题
 * 解题突破点：括号从最内部一对对的消除 消除完了就是合法的
 */
public class Application {
    private static HashMap<Character, Character> mappings;

    public static void main(String[] args) {
        // System.out.println(isValid("()"));
        mappings = new  HashMap<Character, Character>();
        mappings.put(')','(');
        mappings.put('}','{');
        mappings.put(']','[');
        System.out.println(solution2(") "));
    }

    public static boolean isValid(String s) {
        Stack<Character> as = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) { //先将左括号装入
                as.push(c);
            } else {
                if (as.isEmpty()) { //有右括号的时候，必须栈顶要有元素与其匹配
                    return false;
                }else if (')' == c && as.pop() != '(') {
                    return false;
                } else if ('}' == c && as.pop() != '{') {
                    return false;
                } else if (']' == c && as.pop() != '[') {
                    return false;
                }
            }
        }
        return "".equals(s) ? false : as.isEmpty();
    }

    //此方法本质和上面方案一致的
    public static boolean solution2(String s) {
        Stack<Character> as = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(mappings.containsKey(c)){ //有右括号的时候，必须栈顶要有元素与其匹配
               if(as.isEmpty() || mappings.get(c) != as.pop()) {
                   return false;
               }
            }else {
                as.push(c);
            }

        }
        return "".equals(s) ? false : as.isEmpty();
    }
}

/*[()] 举例：我们把它当成消消乐游戏来玩，从最内测开始成对消除，如果消除到发现这对不匹配那么这个字符串就不是对称的
   遍历字符串的时候，我们判断是左括号就把将其入栈，判断是右括号就取栈顶元素出来匹配，匹配成功后栈顶元素出栈（消除了）。
   直到匹配失败或者匹配完了（）*/
