import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class CombinationModel {

	public static void main(String args[]) throws Exception
	{
		System.out.println(" ---Combination Model---");
		Scanner scan = new Scanner(System.in);
		
		String[] baseResults = new String[300];
		String[] packageResults1 = new String[300];
		String[] packageResults2 = new String[300];
		String[] packageResults3 = new String[300];
		String[] finalResults = new String[300];
		
		String[] baseTraining = new String[269];
		String[] packageTraining1 = new String[269];
		String[] packageTraining2 = new String[269];
		String[] packageTraining3 = new String[269];
		String[] finalTraining = new String[269];
		String[] actualTraining = new String[269];
		
		int prediction1=0,prediction2=0,prediction3=0,prediction4=0;
		int tprediction1=0,tprediction2=0,tprediction3=0,tprediction4=0;
		
		
		//Reading the matrix and processing it
		
		//for reading the actual training file
		String actualFile ="ctrain.txt";
		BufferedReader areadfile1 = new BufferedReader(new FileReader(actualFile));
		String aread1;
		int arow_count1=0;
		while ((aread1 = areadfile1.readLine()) != null) 
		{
			//read1=readfile2.readLine();
			String tokens1[]=aread1.split("\\t");
			String truth=tokens1[0];
			//int gtruth=Integer.parseInt(truth);
			actualTraining[arow_count1]= truth;
			arow_count1++;
		}
		
		//for reading the base file
		String baseFile ="resultfile.txt";
		BufferedReader readfile1 = new BufferedReader(new FileReader(baseFile));
		String read1;
		int row_count1=0;
		while ((read1 = readfile1.readLine()) != null) 
		{
			//read1=readfile2.readLine();
			String tokens1[]=read1.split("\\t");
			String truth=tokens1[1];
			//int gtruth=Integer.parseInt(truth);
			baseResults[row_count1]= truth;
			row_count1++;
		}
		
		//for reading the base training file
		String tbaseFile ="basetrain.txt";
		BufferedReader treadfile1 = new BufferedReader(new FileReader(tbaseFile));
		String tread1;
		int trow_count1=0;
		while ((tread1 = treadfile1.readLine()) != null) 
		{
			//read1=readfile2.readLine();
			String tokens1[]=tread1.split("\\t");
			String truth=tokens1[0];
			//int gtruth=Integer.parseInt(truth);
			baseTraining[trow_count1]= truth;
			trow_count1++;
		}
		
		//for reading the 1st package file
				String packageFile1 ="cl_test5.txt";
				BufferedReader readfile2 = new BufferedReader(new FileReader(packageFile1));
				String read2;
				int row_count2=0;
				while ((read2 = readfile2.readLine()) != null) 
				{
					//read1=readfile2.readLine();
					String tokens1[]=read2.split("\\t");
					String truth=tokens1[0];
					//int gtruth=Integer.parseInt(truth);
					packageResults1[row_count2]= truth;
					row_count2++;
				}
				
				//for reading the 1st training file
				String tpackageFile1 ="ctrain5.txt";
				BufferedReader treadfile2 = new BufferedReader(new FileReader(tpackageFile1));
				String tread2;
				int trow_count2=0;
				while ((tread2 = treadfile2.readLine()) != null) 
				{
					//read1=readfile2.readLine();
					String tokens1[]=tread2.split("\\t");
					String truth=tokens1[0];
					//int gtruth=Integer.parseInt(truth);
					packageTraining1[trow_count2]= truth;
					trow_count2++;
				}
				
				
				//for reading the 2nd package file
				String packageFile2 ="cl_test8.txt";
				BufferedReader readfile3 = new BufferedReader(new FileReader(packageFile2));
				String read3;
				int row_count3=0;
				while ((read3 = readfile3.readLine()) != null) 
				{
					//read1=readfile2.readLine();
					String tokens1[]=read3.split("\\t");
					String truth=tokens1[0];
					//int gtruth=Integer.parseInt(truth);
					packageResults2[row_count3]= truth;
					//System.out.println(packageResults2[row_count3]);
					row_count3++;
				}	
				
				//for reading the 2nd training file
				String tpackageFile2 ="ctrain8.txt";
				BufferedReader treadfile3 = new BufferedReader(new FileReader(tpackageFile2));
				String tread3;
				int trow_count3=0;
				while ((tread3 = treadfile3.readLine()) != null) 
				{
					//read1=readfile2.readLine();
					String tokens1[]=tread3.split("\\t");
					String truth=tokens1[0];
					//int gtruth=Integer.parseInt(truth);
					packageTraining2[trow_count3]= truth;
					trow_count3++;
				}	
				
				//for reading the 3rd package file
				String packageFile3 ="cl_test7.txt";
				BufferedReader readfile4 = new BufferedReader(new FileReader(packageFile3));
				String read4;
				int row_count4=0;
				while ((read4 = readfile4.readLine()) != null) 
				{
					//read1=readfile2.readLine();
					String tokens1[]=read4.split("\\t");
					String truth=tokens1[0];
					//int gtruth=Integer.parseInt(truth);
					packageResults3[row_count4]= truth;
					row_count4++;
				}	
				
				//for reading the 3rd training file
				String tpackageFile3 ="ctrain7.txt";
				BufferedReader treadfile4 = new BufferedReader(new FileReader(tpackageFile3));
				String tread4;
				int trow_count4=0;
				while ((tread4 = treadfile4.readLine()) != null) 
				{
					//read1=readfile2.readLine();
					String tokens1[]=tread4.split("\\t");
					String truth=tokens1[0];
					//int gtruth=Integer.parseInt(truth);
					packageTraining3[trow_count4]= truth;
					trow_count4++;
				}
				
		//for finding the final train matrix
				for(int i=0;i<269;i++)
				{
				int countM=0,countB=0;
				
				//checking for base file
				if(baseTraining[i].equals("B"))
				{
					countB++;
				}
				else if(baseTraining[i].equals("M"))
				{
					countM++;
				}
				
				//checking for 1st package file
				if(packageTraining1[i].equals("B"))
				{
					countB++;
				}
				else if(packageTraining1[i].equals("M"))
				{
					countM++;
				}
				
				//checking for 2nd package file
				if(packageTraining2[i].equals("B"))
				{
					countB++;
				}
				else if(packageTraining2[i].equals("M"))
				{
					countM++;
				}
				
				//checking for 3rd package file
				if(packageTraining3[i].equals("B"))
				{
					countB++;
				}
				else if(packageTraining3[i].equals("M"))
				{
					countM++;
				}
				
				if(countM>countB)
				{
					finalTraining[i]="M";
				}
				
				else if (countB>countM)
				{
					finalTraining[i]="B";
				}
				
				else if(countB==countM)
				{
					int max=0,pcount=0;
					if(prediction1>=max)
					{
						max= prediction1;
					}
					if(prediction2>=max)
					{
						max=prediction2;
					}
					if(prediction3>=max)
					{
						max=prediction3;
					}
					if(prediction4>=max)
					{
						max=prediction4;
					}
					
					//checking for a tie in prediction value
					int check[] ={prediction1,prediction2,prediction3,prediction4};
					for(int j=0;j<4;j++)
					{
						if(check[j]==max)
						{
							pcount++;
						}
					}
					if(pcount>=2)
					{
						finalTraining[i] = packageTraining1[i];
					}
					else
					{
						if(max==prediction1)
						{
							finalTraining[i]=baseTraining[i];
						}
						else if(max == prediction2)
						{
							finalTraining[i]=packageTraining1[i];
						}
						else if(max == prediction3)
						{
							finalTraining[i]=packageTraining2[i];
						}
						else if(max == prediction4)
						{
							finalTraining[i]=packageTraining3[i];
						}
					}
						
				}
				//updating the prediction variable
				if(finalTraining[i].equals(baseTraining[i]))
				{
					prediction1++;
				}
				
				if(finalTraining[i].equals(packageTraining1[i]))
				{
					prediction2++;
				}
				
				if(finalTraining[i].equals(packageTraining2[i]))
				{
					prediction3++;
				}
				
				if(finalTraining[i].equals(packageTraining3[i]))
				{
					prediction4++;
				}
				
			}
				
				
				
				//for finding the final test matrix
				for(int i=0;i<300;i++)
				{
				int countM=0,countB=0;
				
				//checking for base file
				if(baseResults[i].equals("B"))
				{
					countB++;
				}
				else if(baseResults[i].equals("M"))
				{
					countM++;
				}
				
				//checking for 1st package file
				if(packageResults1[i].equals("B"))
				{
					countB++;
				}
				else if(packageResults1[i].equals("M"))
				{
					countM++;
				}
				
				//checking for 2nd package file
				if(packageResults2[i].equals("B"))
				{
					countB++;
				}
				else if(packageResults2[i].equals("M"))
				{
					countM++;
				}
				
				//checking for 3rd package file
				if(packageResults3[i].equals("B"))
				{
					countB++;
				}
				else if(packageResults3[i].equals("M"))
				{
					countM++;
				}
				
				if(countM>countB)
				{
					finalResults[i]="M";
				}
				
				else if (countB>countM)
				{
					finalResults[i]="B";
				}
				
				else if(countB==countM)
				{
					
					int max=0,pcount=0;
					if(tprediction1>=max)
					{
						max= tprediction1;
					}
					if(tprediction2>=max)
					{
						max=tprediction2;
					}
					if(tprediction3>=max)
					{
						max=tprediction3;
					}
					if(tprediction4>=max)
					{
						max=tprediction4;
					}
					
					//checking for a tie in prediction value
					int check1[] ={tprediction1,tprediction2,tprediction3,tprediction4};
					for(int j=0;j<4;j++)
					{
						if(check1[j]==max)
						{
							pcount++;
						}
					}
					if(pcount>=2)
					{
						finalResults[i] = packageResults1[i];
					}
					else
					{
						if(max==tprediction1)
						{
							finalResults[i]=baseResults[i];
						}
						else if(max == tprediction2)
						{
							finalResults[i]=packageResults1[i];
						}
						else if(max == tprediction3)
						{
							finalResults[i]=packageResults2[i];
						}
						else if(max == tprediction4)
						{
							finalResults[i]=packageResults3[i];
						}
					}
						
				}
				//updating the prediction variable
				//System.out.println(" i = "+i);
				if(finalResults[i].equals(baseResults[i]))
				{
					
					tprediction1++;
				}
				
				if(finalResults[i].equals(packageResults1[i]))
				{
					tprediction2++;
				}
				
				if(finalResults[i].equals(packageResults2[i]))
				{
					tprediction3++;
				}
				
				if(finalResults[i].equals(packageResults3[i]))
				{
					tprediction4++;
				}
				
				}
		
		//end of reading the matrix
				
				FileWriter outfile = new FileWriter("result_sujithmo.txt");
				PrintWriter out = new PrintWriter(outfile);
				System.out.println(" The final test results are as follows");
				int count=0;
				for(int i=0;i<300;i++)
				{
					System.out.println(finalResults[i]);
					out.println(finalResults[i]);
					if(finalResults[i].equals("B"))
					{
						count++;
					}
				}
				out.close();
				System.out.println(" Count of B = "+count);
				System.out.println(" Count of M = "+(300-count));
				
				
				
				FileWriter outfile1 = new FileWriter("CombinationModel_train_result.txt");
				PrintWriter out1 = new PrintWriter(outfile1);
				double nummatches=0;
				for(int i=0;i<269;i++)
				{
					out1.println(finalTraining[i]);
					if(finalTraining[i].equals(actualTraining[i]))
					{
						nummatches++;
					}
				}
				out1.close();
				System.out.println(" Accuracy = "+(nummatches/269.0)*100);
	}
	
}


