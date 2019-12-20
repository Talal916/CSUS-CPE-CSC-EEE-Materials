// -------------------------------------------------------------------------------
// Homework 11: Input, output
// --
// Write a second C++ program that will read the data from your ﬁle generated in
// Problem 3 into an array (make one up, for example with Python, if you can’t
// ﬁgure out Problem 3), and use it to calculate the slope
//
//    slope = delta f / delta x = f(x2) - f(x1) / x2 - x1
//
// for each pair of consecutive points x1, x2.
//
// Write the x values and corresponding slopes in 2 columns in a diﬀerent data
// ﬁle, and use matplotlib to plot the slope as a function of x.
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

double f(double x)
{
    // Trying to plot y = 2^x.
    // x = pow(2, x); // y = 2^(x)
    // x = exp(x);
    x = sqrt(x);
    return x;
}

// f(x) (exponential function).
double slope(double x1, double x2)
{
    return (f(x2) - f(x1)) / (x2 - x1);
}

int main(int argc, char **argv)
{
    cout << "Problem 4\n"
         << endl; // Output header.

    std::ifstream file("outputData.dat");
    std::string line;

    double arrData1[1000];
    double arrData2[1000];

    // run x2 - x1
    double x2, x1;
    double dx = x2 - x1;

    int i = 0;
    while (getline(file, line))
    {
        std::istringstream ss(line);

        double col1;
        double col2;

        // ss >> col1; // extracts 1st col.
        // ss >> col2; // extracts 2nd col.
        ss >> arrData1[i]; // 1st col. x
        ss >> arrData2[i]; // 2nd col. y

        i++;
    }

    std::ofstream dataOut("slopeData.dat");
    if (dataOut.is_open())
    {
        for (int j = 0; j < i; j++)
        {

            // cout << arrData1[j] << " " << arrData2[j] << endl;
            // cout << "Slope is: " << slope(arrData1[j], arrData2[j]) << endl;
            double x1 = arrData1[j + 1] - arrData1[j] / 1000;
            double x2 = arrData2[j + 1] - arrData2[j] / 1000;

            // setw - means set width between columns.
            dataOut << std::left << std::setw(15) << arrData1[j]            // x values.
                    << std::right << std::setw(8) << slope(x1, x2) << endl; // corresponding slopes.

            // As the sqrt(x) function keeps going the slope will eventually decrease.
        }
        cout << "Usage - File: 'slopeData.dat' created." << endl;
    }
    else
    {
        cout << "Error - File not created." << endl;
    }
    dataOut.close();
}