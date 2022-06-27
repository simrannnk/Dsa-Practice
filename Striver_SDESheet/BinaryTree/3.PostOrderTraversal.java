class Solution {
    
    public void postOrder(TreeNode root,ArrayList<Integer> ans)
    {
        
        if(root==null)
        {
            return;
        }
        
        postOrder(root.left,ans);
        postOrder(root.right,ans);
        
        ans.add(root.val);
        
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
      postOrder(root,ans);
       return ans;
        
    }
}