import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Analyzer {
    // take array list of doubles and return median value of array.
    public double median(ArrayList<Double> numbers){
        ArrayList<Double> temp = numbers;
        Collections.sort(temp);
        // if even number take mean of middle two numbers, else odd just take center element
        if(numbers.size() % 2 ==0){
            return (temp.get(temp.size()/2) + temp.get(temp.size()/2 - 1)) / 2;
        } else{
            return temp.get(temp.size()/2);
        }
    }

    // take array list of doubles and return mean of array.
    public double mean(ArrayList<Double> numbers){
        double sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }
        return sum/numbers.size();
    }

    // take array list of doubles and return mode of array.
    public double mode(ArrayList<Double> numbers){
        double mostOccurrences = numbers.get(0);
        int numberOccurrences = 0;
        // loop through each element of the numbers array
        for(int i = 0; i < numbers.size(); i++){
            double currentNumber = numbers.get(i);
            int countOccurrences = 0;
            // compare each element of the numbers array to the current element.
            // if == then increment occurrences counter by 1.
            for(int j = 0; j < numbers.size(); j++){
                if (numbers.get(j) == currentNumber){
                    countOccurrences++;
                }
            }
            // if the current element has more occurrences in the array than the current max occurrences
            // then set most occurrences and number of occurrences equal to current element.
            if(countOccurrences > numberOccurrences){
                mostOccurrences = currentNumber;
                numberOccurrences = countOccurrences;
            }
        }

        return mostOccurrences;
    }

    // array list of doubles and return variance of array.
    public double variance(ArrayList<Double> numbers){
        double mean = mean(numbers);
        double sumSquares = 0;
        // iterate through all elements, and sum the square of their deviance from the mean
        for(int i = 0; i < numbers.size(); i++){
            sumSquares += (numbers.get(i) - mean) * (numbers.get(i) - mean);
        }
        // divide by size of array list and return variance
        return sumSquares/numbers.size();
    }

    // array list of doubles and return standard deviation of array.
    public double standardDeviation(ArrayList<Double> numbers){
        return Math.sqrt(variance(numbers));
    }

    // array list of doubles and return minimum element value of array.
    public double minimumValue(ArrayList<Double> numbers){
        double currentMin = numbers.get(0);
        // loop through all elements of array and compare to current observed min
        // if current element is greater than current min, set current min to current element.
        for(int i = 1; i < numbers.size(); i++){
            if(numbers.get(i) < currentMin){
                currentMin = numbers.get(i);
            }
        }

        return currentMin;
    }

    // array list of doubles and return maximum element value of array.
    public double maximumValue(ArrayList<Double> numbers){
        double currentMax = numbers.get(0);
        // loop through all elements of array and compare to current observed max
        // if current element is greater than current max, set current max to current element.
        for(int i = 1; i < numbers.size(); i++){
            if(numbers.get(i) > currentMax){
                currentMax = numbers.get(i);
            }
        }

        return currentMax;
    }

    // array list of doubles and return mode of array along with the number of occurrences for the mode in array list of size 2.
    public ArrayList<Double> maximumOccurrences(ArrayList<Double> numbers){
        double mostOccurrences = numbers.get(0);
        double numberOccurrences = 0;
        // loop through each element of the numbers array
        for(int i = 0; i < numbers.size(); i++){
            double currentNumber = numbers.get(i);
            int countOccurrences = 0;
            // compare each element of the numbers array to the current element.
            // if == then increment occurrences counter by 1.
            for(int j = 0; j < numbers.size(); j++){
                if (numbers.get(j) == currentNumber){
                    countOccurrences++;
                }
            }
            // if the current element has more occurrences in the array than the current max occurrences
            // then set most occurrences and number of occurrences equal to current element.
            if(countOccurrences > numberOccurrences){
                mostOccurrences = currentNumber;
                numberOccurrences = countOccurrences;
            }
        }
        // put return values in ArrayList of size 2
        ArrayList<Double> returnValues = new ArrayList<Double>();
        returnValues.add(mostOccurrences);
        returnValues.add(numberOccurrences);

        return returnValues;
    }

    // call all descriptive stat methods and print outputs
    public void analyze(ArrayList<Double> numbers){
        Analyzer a = new Analyzer();
        ArrayList<Double> maxOccur = a.maximumOccurrences(numbers);
        System.out.println("median: " + a.median(numbers));
        System.out.println("mean: " + a.mean(numbers));
        System.out.println("mode: " + a.mode(numbers));
        System.out.println("variance: " + a.variance(numbers));
        System.out.println("standard deviation: " + a.standardDeviation(numbers));
        System.out.println("min value: " + a.minimumValue(numbers));
        System.out.println("max value: " + a.maximumValue(numbers));
        System.out.println("most common element: " + maxOccur.get(0));
        System.out.println("number of occurrences of most common element: " + maxOccur.get(1));
    }
}