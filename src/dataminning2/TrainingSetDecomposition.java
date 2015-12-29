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
public class TrainingSetDecomposition {
   
    public double[][] Decomposition(int RowCount,int TestRow,int ColumnCount,double[][] Dataarray )
    {
        int testrowcount=TestRow;
        int trainingrowcount=RowCount;
        double[][] Dataarraytest= new double[testrowcount][ColumnCount];
        double[][] Dataarraytraining= new double[trainingrowcount][ColumnCount];
        
        for(int i=0;i<testrowcount;i++)
                        {
                                for(int j=0;j<ColumnCount;j++)
                                {
                                    Dataarraytest[i][j]=Dataarray[i][j];
 
                                }
                        }
       return  Dataarraytest;
    }
    
}
