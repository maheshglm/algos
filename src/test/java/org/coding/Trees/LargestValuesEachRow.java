package org.coding.Trees;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=vNWdv7tivao
//https://www.youtube.com/watch?v=91Gok_PQY24
public class LargestValuesEachRow {


    private List<Integer> solution(TreeNode root) {
        List<Integer> output = new ArrayList();
        dfs(root, output, 0);
        return output;
    }

    private void dfs(TreeNode node, List<Integer> output, int level) {
        if (node == null) return;
        if (level == output.size()) {
            output.add(node.val);
        } else {
            int max = Math.max(output.get(level), node.val);
            output.set(level, max);
        }

        dfs(node.left, output, level + 1);
        dfs(node.right, output, level + 1);
    }


}
