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
public class DBScanGraphplot extends JPanel {
    
       double[] dataX = null;
      double[] dataY = null; 
      double[][] data=null;
    
    public DBScanGraphplot(double[][] Data)
    {
        dataX = new double[Data.length];
        dataY = new double[Data.length];
        
        for(int i=0;i<Data.length;i++)
        {
        dataX[i]=Data[i][0];   
        dataY[i]= Data[i][1];
        data=Data;
        }
        
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
        int length1=0;
        int length2= data.length/3;
        for(int i = 0; i < data.length; i++) {
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
    
}
