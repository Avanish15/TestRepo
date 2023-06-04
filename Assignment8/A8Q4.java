public class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                int j = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                TreeNode curt = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if (stack.isEmpty()) stack.push(curt);
                else {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) parent.left = curt;
                    else parent.right = curt;
                    stack.push(curt);
                }
            }
            if (s.charAt(i) == ')') stack.pop();
        }
        return stack.pop();
    }
}