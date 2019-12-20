// -------------------------------------------------------------------------
// Homework 12: Derivatives, integrals
// -------------------------------------------------------------------------

//
// Calculate numerically
//    ∫0-10 ( sin(x) / x^2 + 4 ) dx
// with a precision of 0.1%. You do not need to implement the doubling-
// without-recalculating-points scheme described in the notes, but you do
// need to increase N to check precision.

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <fstream>
#include <string>
#include <limits>
#include <iomanip>
#include <vector>
#include <numeric>
#include <algorithm>
#include <iterator>
#include <sstream>

using std::begin;
using std::cin;
using std::copy;
using std::cout;
using std::endl;
using std::ostream_iterator;
using std::ostringstream;
using std::prev;
using std::vector;

// A sample function whose definite integral's
// approximate value is computed using Trapezoidal
// rule.
float f(float x)
{
    // Declaring the function.
    return (sin(x)) / (pow(x, 2) + 4);
}

// Trapezoidal Rule for approximate Value of 
// definite integral.

// Function to evalute the value of integral.
float trapezoidal(float a, float b, float n)
{
    // Grid spacing.
    float h = (b - a) / n;

    // Computing sum of first and last terms
    // in above formula.
    float s = f(a) + f(b);

    // Adding middle terms in above formula.
    for (int i = 1; i < n; i++)
        s += 2 * f(a + i * h);

    // h / 2  indicates (b - a) / 2n. Multiplying h / 2
    // with s.
    return (h / 2) * s;
}

int main() 
{ 
     // Header.
    cout << "Homework 12: Derivatives, integrals - Problem 2\n"
         << endl;
    //

    // Range of definite integral.
    float x0 = 0; 
    float xn = 10; 
  
    // Number of grids. Higher value means more accuracy. 
    int n = 5; 
  
    cout << "The value of the integral is " << trapezoidal(x0, xn, n) << "%" << endl;
       
    return EXIT_SUCCESS; 
} 