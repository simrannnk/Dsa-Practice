public class solution{
    public ArrayList<Integer> leftView(Node root)
    {
        if(root==null)
        {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans=new ArrayList<>();
        LinkedList<Node> que=new LinkedList<>();
        que.addLast(root);

        while(que.size()!=0)
        {
            ans.add(que.getFirst().data);
            int size=que.size();
            while(size-->0)
            {
                Node rNode=que.removeFirst();

                if(rNode.left!=null)
                {
                    que.addLast(rNode.left);
                }

                 if(rNode.right!=null)
                {
                    que.addLast(rNode.right);
                }
            }
        }

        return ans;
    }
}