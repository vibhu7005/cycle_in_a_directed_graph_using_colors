import java.util.*;
public class Main
{
    int v;
    LinkedList<Integer>array[];
    public Main(int v)
    {
        this.v=v;
        array=new LinkedList[v];
        for(int i=0;i<v;i++)
        array[i]=new LinkedList();
    }
    void add_edge(int src,int dest)
    {
        array[src].add(dest);
    }
    void dfsutils(int s,int color[])
    {
        color[s]=1;//we will use 3 colors for unvisited,visited and traversed
        Iterator<Integer>I=array[s].listIterator();
        while(I.hasNext())
        {
            int n=I.next();
            if(color[n]==1)
            System.out.print("cycle exists"+" ");
            if(color[n]==0)
                dfsutils(n,color);
               
        }
        color[s]=2;
    }
    void dfs()
    {
        int color[]=new int[v];
        for(int i=0;i<v;i++)
        color[i]=0;
        for(int i=0;i<v;i++)
        {
            if(color[i]==0)
            {
                dfsutils(i,color);
            }
        }
    }
    public static void main(String[] args)
    {
        Main obj=new Main(4);
        obj.add_edge(0,1);
        obj.add_edge(0,2);
        obj.add_edge(2,0);

        obj.add_edge(1,2);
        obj.add_edge(2,3);
        obj.add_edge(3,3);
        obj.dfs();

    }
}

