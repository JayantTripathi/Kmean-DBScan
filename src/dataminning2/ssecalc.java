/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminning2;

/**
 *
 * @author SuperUser
 */
public class ssecalc {
    
    public String calc(double[][] data )
    {
        int distance1=0;
        int distance2=0;
        int distance3=0;
        String Ans=null;
       // KMeans_Ex4a obj=new KMeans_Ex4a();
        for(int i=3;i<data.length;i++)
        {
        if(data[i][2]==0)
        {
        distance1+= Math.pow(dist(data[i][0],data[i][1],data[0][0],data[0][1]), 2);
        }
        else if(data[i][2]==1)
        {
        distance2+=Math.pow(dist(data[i][0],data[i][1],data[1][0],data[1][1]), 2) ;
        }
        else if(data[i][2]==2)
        {
        distance3+=Math.pow(dist(data[i][0],data[i][1],data[2][0],data[2][1]), 2);
        }
        }
        Ans = "SSE for cluster 0 ="+ distance1 +"\ncluster 1 ="+ distance2 +"\ncluster 2=" + distance3;
        return Ans;
    }
     public double dist(double  vx,double vy,double cx,double cy)
    {
        return Math.sqrt(Math.pow((cx - cy), 2) + Math.pow((vx - vy), 2));
    }
}
