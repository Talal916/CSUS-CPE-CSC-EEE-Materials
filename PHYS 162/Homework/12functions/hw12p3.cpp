// -------------------------------------------------------------------------
// Homework 12: Functions
// -------------------------------------------------------------------------

//
// Write a function that takes 2 vectors<double> arguments and returns their
// scalar product
//
//    a * b = a1b1 + a2b2 + ...
//
// Make sure your function works for any size vector. If the two vectors
// have different sizes, print a warning message, but calculate the scalar
// product anyway using the smaller size.
//
// Use your function to calculate the scalar product of the following
// vectors:
//
//    a = (5.2, -pi, 2.1)   and   b = (sqrt(3), e, -ln5).
//
// Don't forget to print the result.
//

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

using std::cin;
using std::cout;
using std::endl;
using std::vector;
using std::ostringstream;
using std::copy;
using std::begin;
using std::prev;
using std::ostream_iterator;

// Function to calculate the scalar product of 2 vectors.
double scalarProduct(vector<double> A, vector<double> B)
{
    double scalarProduct = 0.0;

    // Calculating size of the vectors.
    int lengthA = A.size();
    int lengthB = B.size();
    
    // If 2 vectors have different sizes, print warning message.
    if (lengthA != lengthB)
        cout << "Warning - The 2 vectors have different sizes!\n" << endl;

    // If vector A is smaller...
    if (lengthA < lengthB) 
    {
        for (int i = 0; i < lengthA; i++)
        {
            double product = A.at(i) * B.at(i);
            scalarProduct += product;
        }
    }
    // If vector B is smaller...
    else 
    {
        for (int i = 0; i < lengthB; i++)
        {
            double product = A.at(i) * B.at(i);
            scalarProduct += product;
        }
    }
    return scalarProduct;
}

int main(int argc, char **argv)
{
    // Header.
    cout << "Problem 3\n"
         << endl;
    //

    // a = (5.2, -pi, 2.1)   and   b = (sqrt(3), e, -ln5).
    vector<double> A = {5.2, -M_PI, 2.1};
    vector<double> B = {sqrt(3), exp(1), -log(5)};

    // -------------------------------------------------------------------
    // Print out vector A.
    int lengthA = A.size();

    // For printing commas between elements in vectors.
    ostringstream ss1;

    // If vector A is empty stop printing separating commas.
    if(!A.empty()) 
    {
      copy(A.begin(), prev(A.end()), ostream_iterator<double>(ss1, ", "));
      ss1 << A.back();
    }
    cout << "Vector A (size " << lengthA << "): " 
        << "(" << ss1.str() << ")" << endl;

    // -------------------------------------------------------------------
    // Print out vector B.
    int lengthB = B.size();

    // For printing commas between elements in vectors.
    ostringstream ss2;

    if(!B.empty()) 
    {
      copy(B.begin(), prev(B.end()), ostream_iterator<double>(ss2, ", "));
      ss2 << B.back();
    }
    cout << "Vector B (size " << lengthB << "): " 
        << "(" << ss2.str() << ")\n" << endl;

    // -------------------------------------------------------------------
    // Output result.
    double result = scalarProduct(A, B);

    if(lengthA != lengthB)
    {
        cout << "Scalar product (using smaller size) = " << result << endl;
    }
    else
    {
        cout << "Scalar product = " << result << endl;
    }
    
}
