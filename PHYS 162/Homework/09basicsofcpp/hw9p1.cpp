// -------------------------------------------------------------------
// Homework 8: Basics of C++
// --
// Write a program that calculates the following:
//    - sqrt(-1)
//    - cos^-1 (2.0)
//    - log(0.0)
// and prints the results with some comments on why it is what it is.
// -------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cmath>

using std::cin;
using std::cout;
using std::endl;
using std::acos;
using std::sqrt;
using std::setprecision;

int main(int argc, char** argv)
{
    double part1, part2, part3;

    cout << "Problem 1\n" << endl;

    part1 = sqrt(-1);
    cout << "sqrt(-1) = " << part1 << endl;
    // The output is "-nan". The return value for sqrt(-1)
    // cannot be represented. The acronym "nan" means 
    // not a number. Therefore, it is not a real number.
    // The real output sqrt(-1) is "i" which means it 
    // is a imaginary number. C++ can't identify imaginary
    // numbers, so the return value is "-nan".
 
    part2 = acos(2.0);
    cout << "cos^(-1) (2.0) = " << part2 << "" << endl;
    // The output is "nan". Part2 cannot be represented
    // as a real number since the output returned as 
    // "not a number". The real domain for arccos(x) is
    // -1 <= x <= 1. 2.0 is not in the domain. Therefore,
    // it is "nan".

    part3 = log(0.0);
    cout << "log(0.0) = " << part3 << endl;
    // The output is "-inf" which means negative infinity.
    // This means the it returned as a real number.

    return EXIT_SUCCESS;
}



