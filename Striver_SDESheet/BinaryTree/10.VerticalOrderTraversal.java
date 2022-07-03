class Solution {
    public void widthOfShadow(TreeNode root,int[] minMax,int vLevel)
    {
        if(root==null)
        {
            return;
        }

        minMax[0]=Math.min(minMax[0],vLevel);
        minMax[1]=Math.max(minMax[1],vLevel);

        widthOfShadow(root.left,minMax,vLevel-1);
        widthOfShadow(root.right,minMax,vLevel+1);
    }

    public class vPair{
        TreeNode node;
        int vl;

        vPair(TreeNode node,int vl)
        {
            this.node=node;
            this.vl=vl;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        LinkedList<vPair> que=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();

        int[] minMax=new int[2];
        int len=minMax[1]-minMax[0]+1;
        for(int i=0;i<len;i++)
        {
            ans.add(new ArrayList<>());
        }

        que.addLast(new vPair(root,Math.abs(minMax[0])));

        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                vPair rPair=que.removeFirst();
                TreeNode rNode=rPair.TreeNode;
                int rLevel=rPair.vl;

                ans.get(vl).add(rNode.val);

                if(rNode.left!=null)
                {
                    que.addLast(new vPair(rNode.left,rLevel-1));
                }

                if(rNode.right!=null)
                {
                    que.addLast(new vPair(rNode.right,rLevel+1));
                }

            }
        }

        return ans;
        
    }
}