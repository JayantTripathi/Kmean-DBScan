/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminning2;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author SuperUser
 */
public class LOadData {
    
    public int RowCount(String Path)
    {
           CsvReader products=null;
                        
                        try
                        {
                            products = new CsvReader(Path);
                        }
                        catch(FileNotFoundException EB)
                        {
                            System.out.println(EB.getMessage());
                        }
                        int ColumnCount=0;
                        int RowCount =0;
                        int iloop=0;
                        try
                        {
                            while (products.readRecord())
                            {    
                            ColumnCount=products.getColumnCount();
                            RowCount++;
                            
                            }
                        }
                        catch(IOException EN)
                        {
                            System.out.println(EN.getMessage());
                        }
    return RowCount;
    }
   
    
    public int ColumnCount(String Path)
    {
         CsvReader products=null;
                        
                        try
                        {
                            products = new CsvReader(Path);
                        }
                        catch(FileNotFoundException EB)
                        {
                            System.out.println(EB.getMessage());
                        }
                        int ColumnCount=0;
                        int RowCount =0;
                        int iloop=0;
                        try
                        {
                            while (products.readRecord())
                            {    
                            ColumnCount=products.getColumnCount();
                            RowCount++;
                            
                            }
                        }
                        catch(IOException EN)
                        {
                            System.out.println(EN.getMessage());
                        }
    return ColumnCount;
    }
    
    
    public double[][] Datasetup(String Path,int ColumnCount,int RowCount)
    {
     CsvReader products=null;
                        
                       
                        
                        int iloop=0;
                       
                        try 
                        {
                         products = new CsvReader(Path);
                        }
                        catch(FileNotFoundException E)
                        {
                                System.out.println(E.getMessage());
                        }
                        double[] predictedvalues=new double[RowCount];
                        double[] predictedvaluesloose=new double[RowCount/5];
                        double[][] Dataarray= new double[RowCount][ColumnCount];
                        try
                        {
                            while (products.readRecord())
                            {    
                            String v;
                            String[] x;
                            v = products.getRawRecord();
                            x =v.split(",");
                               for(int j=0;j<ColumnCount;j++)
                                {
                                    double value=0;
                                    int z=j;
                                    value=Double.parseDouble(x[z]);
                                    try
                                    {
                                    Dataarray[iloop][j]=value;
                                    }
                                    catch(Exception E)
                                    {
                                        System.out.println(E.getMessage());
                                    }
                                   // System.out.println(Dataarray[iloop][j]);
                                    }
                            iloop=iloop+1;    
                            }
                            }
                        catch(IOException Em)
                        {
                        System.out.println(Em.getMessage());
                        }
                        
	products.close();
        
        return Dataarray;
    }
    
}
