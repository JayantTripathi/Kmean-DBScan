/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminning2;

import com.csvreader.CsvReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.apache.commons.math3.linear.AnyMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
/**
 *
 * @author SuperUser
 */
public class DataMinning2 {

    /**
     * @param args the command line arguments
     */  
    public static void main(String[] args) throws IOException
    {
       // here is the code to load the iris.csv data in an array 
        
        int ColumnCount=0;
        int RowCount =0;
        double[][] Dataarraytest;
        double[][] Dataarray;
        double[][] SVDS = null;
        double[][] SVDU = null;
        double[][] SVDV = null;
        System.out.println("Do you want to work with 1.att.csv or 2.iris.csv  ");
        InputStreamReader Datasetchoice =new InputStreamReader(System.in);
        BufferedReader BDatasetChoice=new BufferedReader(Datasetchoice);
        int Datasetchoicevalue=Integer.parseInt(BDatasetChoice.readLine());
        String path=null;
       // LOadData LDobj=new LOadData();
        LOadData LDobj=new LOadData();
        TrainingSetDecomposition TestDataonj=new TrainingSetDecomposition();
        SVDDecomposition SVDobj=new SVDDecomposition();

        switch(Datasetchoicevalue)
        {
            case 1: path="Datasets\\att.csv";
                    ColumnCount=LDobj.ColumnCount(path);
                    RowCount=LDobj.RowCount(path);
                    Dataarray=LDobj.Datasetup(path,ColumnCount,RowCount);
                    Dataarraytest=TestDataonj.Decomposition(RowCount, RowCount, 2, Dataarray);
                
                    SVDS = SVDobj.DecompositionS(Dataarraytest);
                    SVDU = SVDobj.DecompositionU(Dataarraytest);
                    SVDV = SVDobj.DecompositionV(Dataarraytest);
                    
                    System.out.println("Do you want the graph to be plotted 1.yes 2.No");
                    Datasetchoicevalue=Integer.parseInt(BDatasetChoice.readLine());
                    if(Datasetchoicevalue == 1)
                    {
                     WriteCSv wcsvobj=new WriteCSv();
                     wcsvobj.writeCSVmethod(SVDU,"SVD");
                    }
                    
                    KMeans_Ex4a Kmeanobj1=new KMeans_Ex4a();
                    double[][] KmeanData1=Kmeanobj1.Main(SVDU);
                    System.out.println("Do you want the graph to be plotted 1.yes 2.No");
                    Datasetchoicevalue=Integer.parseInt(BDatasetChoice.readLine());
                    if(Datasetchoicevalue == 1)
                    {
                    WriteCSVKmean wcsvobj=new WriteCSVKmean();
                    wcsvobj.writeCSVmethod(KmeanData1,"KMean");
                    }
                    
                    Gui DBScanobj1=new Gui();
                    DBScanobj1.main(SVDU);
                    
                      System.out.println("Do you want the graph to be plotted 1.yes 2.No");
                    Datasetchoicevalue=Integer.parseInt(BDatasetChoice.readLine());
                    if(Datasetchoicevalue == 1)
                    {
                        
                      WriteCSv wcsvobj=new WriteCSv();
                     wcsvobj.writeCSVmethod(SVDU,"DBScan");
                    }
                  
                    break;
                
            case 2: path="Datasets\\iris.csv";
                    ColumnCount=LDobj.ColumnCount(path);
                    RowCount=LDobj.RowCount(path);
                    Dataarray=LDobj.Datasetup(path,ColumnCount,RowCount);
                    Dataarraytest=TestDataonj.Decomposition(RowCount, 150, ColumnCount, Dataarray);
                    
                    SVDS = SVDobj.DecompositionS(Dataarraytest);
                    SVDU = SVDobj.DecompositionU(Dataarraytest);
                    SVDV = SVDobj.DecompositionV(Dataarraytest);
                    System.out.println("Do you want the graph to be plotted 1.yes 2.No");
                    Datasetchoicevalue=Integer.parseInt(BDatasetChoice.readLine());
                    if(Datasetchoicevalue == 1)
                    {
                    WriteCSv wcsvobj=new WriteCSv();
                    wcsvobj.writeCSVmethod(SVDU,"SVD");
                    }
                    
                    KMeans_Ex4a Kmeanobj=new KMeans_Ex4a();
                    double[][] KmeanData=Kmeanobj.Main(SVDU);
                    ssecalc distobj=new ssecalc();
                    String output=distobj.calc(KmeanData);
                    System.out.println(output);
                    System.out.println("Do you want the graph to be plotted 1.yes 2.No");
                    Datasetchoicevalue=Integer.parseInt(BDatasetChoice.readLine());
                    if(Datasetchoicevalue == 1)
                    {
                    WriteCSVKmean wcsvobj=new WriteCSVKmean();
                    wcsvobj.writeCSVmethod(KmeanData,"KMean");
                    }
                    
                    Gui DBScanobj=new Gui();
                    DBScanobj.main(SVDU);
                    
                     System.out.println("Do you want the graph to be plotted 1.yes 2.No");
                    Datasetchoicevalue=Integer.parseInt(BDatasetChoice.readLine());
                    if(Datasetchoicevalue == 1)
                    {
                        
                     WriteCSv wcsvobj=new WriteCSv();
                    wcsvobj.writeCSVmethod(SVDU,"DBScan");
                    }
                    
                    break;
        }
        
        
       
        
    
        
       
        
       
    }
    
}
