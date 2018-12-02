package dianlu;

public class dianlubuxian {  
    public int[] c;//  
    public int[][] size;//最大不想交子集  
    public int[] net;  
    public dianlubuxian(int[] cc){  
        this.c=cc;  
        this.size=new int[cc.length][cc.length];//下标从1开始  
        this.net=new int[cc.length];  
    }  
    public void mnset(int[] c,int[][] size){  
        int n = c.length-1;  
        for(int j=0;j<c[1];j++){//i=1时，分了两种情况，分别等于0,1  
            size[1][j]=0;  
        }  
        for(int j =c[1];j<=n;j++){  
            size[1][j]=1;  
        }  
        for(int i =2;i<n;i++){//i大于1时，同样分了两种情况(当i=n时单独计算，即此方法最后一行)  
            for(int j=0;j<c[i];j++){//第一种  
                size[i][j]=size[i-1][j];  
            }  
            for(int j=c[i];j<=n;j++){//第二种  
                size[i][j]=Math.max(size[i-1][j], size[i-1][c[i]-1]+1);  
            }  
        }  
        size[n][n]=Math.max(size[n-1][n], size[n-1][c[n]-1]+1);  
    }  
    //构造最优解  
    public int traceback(int[] c,int[][] size,int[] net){  
        int n=c.length-1;  
        int j=n;  
        int m=0;  
        for(int i=n;i>1;i--){  
            if(size[i][j]!=size[i-1][j]){  
                net[m++]=i;  
                j=c[i]-1;  
            }  
              
        }  
        if(j>=c[1])  
            net[m++]=1;  
        System.out.println("最大不相交连线分别为：");  
        for (int t = m - 1; t >= 0; t--) {  
            System.out.println(net[t]+"  "+c[net[t]]);  
        }  
        return m;  
    }  
    public static void main(String[] args) {  
        int[] c = {0,8,3,2,7,6,1,9,4,10,5};//下标从1开始,第一个数，0不算,总共10个数  
        dianlubuxian di = new dianlubuxian(c);  
        di.mnset(di.c, di.size);  
        int x = di.traceback(di.c, di.size, di.net);  
        System.out.println("最大不相交连线数目为：:"+x);  
    }  
}  

