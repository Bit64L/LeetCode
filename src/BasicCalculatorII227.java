import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII227 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int count = 0;
        TreeNode root = null;
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                if (i == 0 || S.charAt(i - 1) != '-') {
                    TreeNode node = new TreeNode(Integer.parseInt(num.toString()));
                    if (root == null) root = node;
                    if (count == stack.size()) {
                        if (!stack.isEmpty()) {
                            stack.peek().left = node;
                        }
                    } else if (count < stack.size()) {
                        while (count != stack.size()) {
                            stack.pop();
                        }
                        if (!stack.isEmpty()) {
                            stack.peek().right = node;
                        }
                    }
                    stack.push(node);
                    count++;
                }

            } else {
                num.append(S.charAt(i));
            }
        }
        return root;

    }
}
