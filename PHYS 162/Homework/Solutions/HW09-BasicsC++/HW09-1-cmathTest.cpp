/*
 A program to test the limits of the C++ math library, <cmath>.
 */

#include <cstdlib>
#include <iostream>
#include <cmath>

using std::cout;
using std::endl;

int main(int argc, char** argv)
{
    // The following fails to yield a useful result because the sqrt()
    // function is not designed to handle complex return values.
    cout << "Using the sqrt() function to calculate the square root of -1 yields " << sqrt(-1) << "." << endl << "This is because the result is imaginary." << endl;
    
    // The following fails to yield a useful result because the acos()
    // function expects an argument that is within the range of the cosine
    // function given a real input; namely, [-1,1].
    cout << "Using the acos() function to calculate the inverse cosine of 2.0 yields " << acos(2.0) << "." << endl << "This is because the range of cosine is [-1,1]." << endl;
    
    // The following actually gives a correct answer.  The limiting behavior
    // of any logarithm as its argument approaches zero (from the positive
    // side) is towards negative infinity.
    cout << "Using the log() function to calculate the natural logarithm of 0.0 yields " << log(0.0) << "." << endl << "This is because the logarithm diverges to negative infinity as one approaches" << endl << "zero from the right." << endl;
    
	return EXIT_SUCCESS;
}
