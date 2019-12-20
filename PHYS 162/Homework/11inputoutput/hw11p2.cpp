// -------------------------------------------------------------------------------
// Homework 11: Input, output
// --
// Problem 2:
// (a) Prompt the user for the length of a double array (i.e., a vector of type 
//     double).
//  
// (b) Create an array of the speciﬁed length and populate its elements with the 
//     square root of the element’s index plus 2. For example, element 10 should 
//     be √(12).
//
// (c) Use a loop to print the elements of the array to the screen; also, ﬁnd the 
//     sum of all the elements and then print the result.
// -------------------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <math.h>
#include <fstream>
#include <string>
#include <limits>
#include <iomanip>
#include <vector>
#include <numeric>

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char** argv)
{
    cout << "Problem 2\n" << endl; // Output header.
    //

    // (a)
    int arrLength; 
    cout << "Please enter a length of a double array: ";
    cin >> arrLength;
    
    std::vector<double> arrDouble(arrLength);

    // Check size of array.
    // cout << arrDouble.size() << endl;

    for(int i = 0; i < arrDouble.size(); i++)
    {
        arrDouble.at(i) = sqrt(i + 2) ;
        cout << "array[" << i << "] = √(" << i + 1 << ") = " << arrDouble.at(i) << endl;
    }

    // "accumulate" returns the result of accumulating all the values in the range 
    // [first,last) to init.
    double sum = std::accumulate(arrDouble.begin(), arrDouble.end(), 0.0);
    cout << "Sum of all elements = " << sum << endl;
   
	return EXIT_SUCCESS;
}
