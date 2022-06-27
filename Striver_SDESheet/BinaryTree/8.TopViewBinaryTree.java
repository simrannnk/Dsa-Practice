class Solution
{
    public void widthOfShadow(Node root,int[] minMax,int vLevel)
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
        Node node=null;
        int vl=0;

        vPair(Node node,int vl)
        {
            this.node=node;
            this.vl=vl;
        }
    }

    public ArrayList<Integer> topView(Node root)
    {

        if(root==null)
        {
            return new ArrayList<>();
        }

        LinkedList<vPair> que=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();

        int[] minMax=new int[2];
        widthOfShadow(root,minMax,0);
        int len=minMax[1]-minMax[0]+1;

        for(int i=0;i<len;i++)
        {
            ans.add(null);
        }

        que.addLast(new vPair(root,Math.abs(minMax[0])));

        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                vPair rPair=que.removeFirst();
                Node rNode=rPair.node;
                int rLevel=rPair.vl;

                if(ans.get(rLevel)==null)
                {
                    ans.set(rLevel,rNode.data);
                }

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