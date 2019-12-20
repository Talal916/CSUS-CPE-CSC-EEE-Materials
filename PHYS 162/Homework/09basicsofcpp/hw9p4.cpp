// -------------------------------------------------------------------
// Homework 8: Basics of C++
// --
// Write a program that lists all integers up to 50 and next to each
// integer the sum of all previous integers (including the current
// one). The output should look something like this:
//    i = 0    sum = 0
//    i = 1    sum = 1
//    i = 2    sum = 3
//    i = 3    sum = 6
//    ...
// -------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cmath>
#include <limits>

using std::cin;
using std::cout;
using std::endl;
using std::acos;
using std::sqrt;
using std::string;
using std::setprecision;

int main(int argc, char** argv)
{
    cout << "Problem 4\n" << endl;

    int i; // Iterator variable.
    int n = 50; // Number of integers.
    int sum = 0;
    for(i = 0; i <= n; i++)
    {
        sum += i;
        cout << "i = " << i << "\t" << "sum = " << sum << endl;
    }

    return EXIT_SUCCESS;
}