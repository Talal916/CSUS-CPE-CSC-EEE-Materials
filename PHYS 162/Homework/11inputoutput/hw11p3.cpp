// -------------------------------------------------------------------------------
// Homework 11: Input, output
// --
// Write a C++ program that will create a data ﬁle containing pairs of values
// x f(x) in 2 columns for a function f(x) of your choice and for a ﬁnite range of
// values of x. Use a step for the x values that gives you a smooth curve.
// (Note that we don’t have the convenience of something line numpy.linspace here
// so you will have to write your own algorithm for creating the discretized
// values of x; try to do this without using a ﬂoating point index in your loop.)
//
// Import the data created into a Python script and use matplotlib to plot the
// function from it.
//
// Submit your source code and your Python script. Create the data ﬁle in the
// current working directory so it will run easily for me.
// -------------------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <math.h> // For exponential.
#include <fstream>
#include <string>
#include <limits>
#include <iomanip>
#include <vector>
#include <numeric>

using std::cin;
using std::cout;
using std::endl;

// f(x) (exponential function).
double myFunc(double x)
{
    // Trying to plot y = 2^x.
    // x = pow(2, x); // y = 2^(x)
    x = sqrt(x);
    return x;
}

int main(int argc, char **argv)
{
    cout << "Problem 3\n"
         << endl; // Output header.
    //
    double xmin = 0;
    double xmax = 10;

    // Function bound.
    int bound = 1000; // "Don't declare global variables." (moved from global).

    // dx = xmax - xmin / n - 1
    double dx = (xmax - xmin) / (bound - 1);

    std::ofstream dataOut("outputData.dat");
    if (dataOut.is_open())
    {
        for (int i = 0; i < bound; i++)
        {
            // Getting the sub-divided parts "chunks" between xmin and xmax.
            //    Ex: if i = 1 the output of x = 0.25.
            double x;
            x = xmin + i * dx;

            // setw - means set width between columns.
            dataOut << std::left << std::setw(15) << x                  // x.
                    << std::right << std::setw(8) << myFunc(x) << endl; // y(observed).
        }
        cout << "Usage - File: 'outputData.dat' created." << endl;
    }
    else
    {
        cout << "Error - File not created." << endl;
    }
    dataOut.close();

    /*
    cout << std::left << std::setw(12) << "John Smith"
            << std::right << std::setw(3) << 23
            << '\n';
    cout << std::left << std::setw(12) << "Sam Brown"
            << std::right << std::setw(3) << 8
            << '\n';
    */
}