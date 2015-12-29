/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminning2;
import java.awt.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.JPanel;
import org.apache.commons.math3.linear.AnyMatrix;
/**
 *
 * @author SuperUser
 */
public class KmeanGraphplot extends JPanel{
      double[] dataX = null;
      double[] dataY = null; 
      double[][] data=null;
      int cluster1strt=0;
      int cluster2strt=0;
      int cluster3strt=0;
      double cluster0[][];
      double cluster1[][];
      double cluster2[][];
      
    
    public KmeanGraphplot(double[][] Data)
    {
        dataX = new double[Data.length];
        dataY = new double[Data.length];
        
        for(int i=0;i<Data.length;i++)
        {
        dataX[i]=Data[i][0];   
        dataY[i]= Data[i][1];
        data=Data;
        }
         Calcluster();
    } 
    
    final int PAD = 20;
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        double xInc = (double)(w - 2*PAD)/(data.length-1);
        double scale = (double)(h - 2*PAD)/88;
        // Mark data points.
        

       
        
        g2.setPaint(Color.red);
       
        for(int i = 0; i < cluster0.length; i++) {
            double x = PAD + i*dataX[i];
            double y = h - PAD - scale*dataY[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
        
          g2.setPaint(Color.BLUE);
       
         for(int i = 0; i < cluster1.length; i++) {
            double x = PAD + i*dataX[i];
            double y = h - PAD - scale*dataY[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
         g2.setPaint(Color.YELLOW);
       
         for(int i = 0; i<cluster2.length; i++) {
            double x = PAD + i*dataX[i];
            double y = h - PAD - scale*dataY[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
 
    private int getMax() {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++) {
            if(dataY[i] > max)
                max = (int)dataY[i];
        }
        return max;
    }
     
   public void Main()
   {
       
   }
   
   public void Calcluster()
   {   int increment=0;
        int increment1=0;
        int increment2=0;
       int count0=0;
       int count1=0;
       int count2=0;
       for(int j=0;j<data.length;j++)
       {
        if(data[j][2]==0)
           {
               count0++;
           }
           
        if(data[j][2]==1)
        {
           count1++;
                    }
        
        else if (data[j][2]==2)
        {
           count2++;
        }
       }
      cluster0=new double[count0][2];
      cluster1=new double[count1][2];
      cluster2=new double[count2][2];
        for(int j=0;j<data.length;j++)
        {
           if(data[j][2]==0)
           {
               if(j==0)
               {
             cluster0[j][0]=data[j][0];
             cluster0[j][1]=data[j][1];
             
             increment++;
                     }
               else{
               cluster0[increment][0]=data[j][0];
               cluster0[increment][1]=data[j][1];
               increment++;
               }
               
           }
           
        if(data[j][2]==1)
        {
         if(j==0)
               {
             cluster1[j][0]=data[j][0];
             cluster1[j][1]=data[j][1];
             
             increment1++;
                     }
               else{
               cluster1[increment1][0]=data[j][0];
               cluster1[increment1][1]=data[j][1];
                 increment1++;
               }
                    }
        
        else if (data[j][2]==2)
        {
          if(j==0)
               {
             cluster2[j][0]=data[j][0];
             cluster2[j][1]=data[j][1];
             
             increment2++;
                     }
               else{
               cluster2[increment2][0]=data[j][0];
               cluster2[increment2][1]=data[j][1];
                  increment2++;
               }
        }  
        }
   }
   
}
