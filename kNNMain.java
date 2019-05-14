import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException
  {

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
		
		String path = "H:\\w19-360420-machine-learning\\data\\breastCancer.csv";
		List<DataPoint> MyData = DataSet.readDataSet(path);
		DataPoint dp1 = MyData.get(1);
		System.out.println("The label is "+ dp1.getLabel());
		System.out.println(Arrays.toString(dp1.getX()));

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
		double fractionTrainingSet = 0.7;
		List<DataPoint> xxx = DataSet.getTrainingSet(MyData,fractionTrainingSet);
		
		double fractionTestSet = 0.3;
		List<DataPoint> qqq= DataSet.getTestSet(MyData,fractionTestSet);
		

    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)



    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	
		// initiation of an object && create 
		int GGG = 3;
		KNNClassifier classifier = new KNNClassifier(GGG);

		DataPoint[] somepointsnearby = classifier.getNearestNeighbors(MyData, MyData.get(0)); 
		// get somedatapoints that is the nearest point of the First datapoint
	  
		System.out.println("Nearest points is : ");
      
		System.out.println(" ");
		System.out.println(" ");
	  
		for(int k = 0; k < somepointsnearby.length; k++) 
		{
			for (int p = 0; p < somepointsnearby[k].x.length; p++) 
        
			System.out.print(somepointsnearby[k].x[p] + "  ");
			System.out.println(somepointsnearby[k].getLabel()); 
		}



    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	double cube[]= new double[1000];
	for (int z=0; z<1000; z++)
	{	
		
		int Rubik=0;
		for(int i=0; i<(xxx.size()); i++)
		{
			DataPoint cplusplus = xxx.get(i);
			String rob = classifier.predict(xxx, cplusplus);
			if (rob.equals(cplusplus.label))
			{
				Rubik++;
			}
		}
		cube[z]=(((double)Rubik/(double)(xxx.size()))*100.0);
	}
	System.out.println("the mean is "+ mean(cube) + "%");
	System.out.println("the standard deviation is  is "+ standardDeviation(cube));
  }

 

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
