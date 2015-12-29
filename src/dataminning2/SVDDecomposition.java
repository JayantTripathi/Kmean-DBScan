/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminning2;
import Jama.Matrix;
import org.apache.commons.math3.linear.AnyMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.ujmp.commonsmath.CommonsMathDenseDoubleMatrix2DFactory;

/**
 *
 * @author SuperUser
 */
public class SVDDecomposition {
   
    public double[][] DecompositionU(double[][] Dataarraytest)
    {
        Array2DRowRealMatrix rmA=new Array2DRowRealMatrix(Dataarraytest);
        SingularValueDecomposition svdObj=new SingularValueDecomposition(rmA);
        double[][] DataU=svdObj.getU().getData();
        
        return DataU;
    }
    
     public double[][] DecompositionV(double[][] Dataarraytest)
    {
        Array2DRowRealMatrix rmA=new Array2DRowRealMatrix(Dataarraytest);
        SingularValueDecomposition svdObj=new SingularValueDecomposition(rmA);
        double[][] DataV=svdObj.getV().getData();
        return DataV;
    }
     
      public  double[][] DecompositionS(double[][] Dataarraytest)
    {
        Array2DRowRealMatrix rmA=new Array2DRowRealMatrix(Dataarraytest);
        SingularValueDecomposition svdObj=new SingularValueDecomposition(rmA);
        double[][] Sobj= svdObj.getS().getData();
        return Sobj;
    }
}
