# Title:   Error Analysis
## Course - Section: 360-420-DW Section01
## Authors: Zhaoying Lei

## Distributions of Model Accuracy

1.	Each time you run the classification model, you should be getting a different accuracy. Why?
The command “Collections.shuffle(fullDataSet);” randomly permutes all the data in the dataset, so the nearest points will vary every time. As a result, the accuracy and the standard deviation are different each time.

2.	Run the entire classification process 1000 times (load data, split into off 30% for a test set, evaluate model performance)
The model has an accuracy of 98.11% with a standard deviation 7.514*10^-25.

3.	What is a sensible baseline against which we should compare our model's performance?
The result of “printLabelFrequencies” is used as a baseline to predict the data. It has a value of 65.2%. It is the baseline because it only counts the frequency of a particular element in the list but doesn’t evaluate all the elements. The accuracy of our model should not smaller than 65.2%, otherwise there is a mistake somewhere.

## Analysis of different error types

4.	What is a false positive?
A false positive is something that you predict it is positive, but the results show that it is actually negative. In our breast cancer example, when you predict the patient has breast cancer but the result shows that she doesn’t, your prediction will be false positive.

5.	What is a false negative?
A false negative is something that you predict it is negative, but the results show that it is actually positive. In our breast cancer example, when you predict the patient does not have breast cancer but the result shows that she has, your prediction will be false negative.

6.	Precision is the number of correct results divided by the number of all returned results, and recall is the number of correct results divided by the number of results that should have been returned. In other words, precision tells you that in all selected elements, how many of them are correct. Recall tells you that in all relevant elements, how many of them you select.

7.	A hyperparameter is a parameter whose value is already set before the learning process begins. In our case, the hyperparameter k is the number of closest neighbors that are used to determine the class of a datapoint. When k=3, we can only select 3 nearest points from the dataset. If we increase the value of k, the error will be bigger, so that the accuracy will decrease. Recall will be higher, because the more elements we select, the more chances we select the correct truely positive elements. Therefore, recall will increase. However, it's hard to say how precision changes. On one hand, we might select more truely positive elements since we are selecting more elements, thus precision increases. On the other hand, if the number of truely positive elements remains the same or doesn't increase a lot, but the number of false positive elements increases, then the precision will be smaller. If the value of k is too small, it is not accurate because If we decrease the value of k, the error precision will decrease because it has a difficulty to get a accurate element. Recall and precision will both decrease because there will be less selected, truely positive elements.
