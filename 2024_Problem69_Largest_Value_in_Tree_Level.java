//515. Find Largest Value in Each Tree Row - https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
//Time Complexity: O(n)
//Space Complexity: O(n/2) ~ O(n)

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++){ //every node in level
                TreeNode curr = q.poll();

                max = Math.max(max, curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            //level is complete
            result.add(max);

        }
        return result;
    }
}