/* Prompts the user for an array length and then
 declares a double array of that length using
 dynamic memory allocation.  The array is populated
 with a simple formula in terms of the index i:
 sqrt(i+2). */

#include <iostream>
#include <cstdlib>
#include <cmath>
#include <limits>
#include <vector>

using std::cout;
using std::cin;
using std::endl;

int main()
{
    int arrLength;
    
    cout << "Please enter a length for the array of doubles: ";
    cin >> arrLength;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    
    std::vector<double> arr(arrLength);
    
    for(int i=0; i<arrLength; i++)
    {
        arr.at(i) = sqrt(i+2.0);
    }
  
	double sum = 0.;
    for(int i=0; i<arrLength; i++)
    {
        cout << "arr[" << i << "] = " << arr.at(i) << endl;
		sum += arr.at(i);
    }
	
	cout << "The sum of all elements is " << sum << endl;
    
	return EXIT_SUCCESS;
}
