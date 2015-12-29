/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminning2;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author SuperUser
 */
public class WriteCSv {
   
    public void writeCSVmethod(double[][] data, String Name){
    String outputFile = "Datasets\\Result"+Name+".csv";
    CsvWriter csvOutput =null;
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appendingry
                        try
                        {
			csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
                        }
                        catch(IOException IOE)
                        {
                            System.out.println(IOE.getMessage());
                        }
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("x");
				csvOutput.write("y");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			// write out a few records
                        for(int i=0;i<data.length;i++)
                        {
                          // (data[i][0]).
                                csvOutput.write(new Double(data[i][0]).toString());
			csvOutput.write(new Double(data[i][1]).toString());
			csvOutput.endRecord();
			
			
			
                         
                        }
			
			csvOutput.close();
		} 
               catch (IOException e)
                {
			 System.out.println(e.getMessage());
		}
   }
}