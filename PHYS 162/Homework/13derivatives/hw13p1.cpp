// -------------------------------------------------------------------------
// Homework 12: Derivatives, integrals
// -------------------------------------------------------------------------

//
// Write a C++ program that calculates the derivative of f(x) = x^4−2x^3+5x−1
// for various values of Δx, using either of the numerical derivative
// formulas from the notes.
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

using std::begin;
using std::cin;
using std::copy;
using std::cout;
using std::endl;
using std::ostream_iterator;
using std::ostringstream;
using std::prev;
using std::vector;

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

// Function f.
double f(double x)
{
    // f(x) = x^4 − 2x^3 + 5x − 1
    return (pow(x, 4) - 2 * pow(x, 3) + 5 * x - 1);
}

// Derivative of f.
double f_d(double x)
{
    // f(x) = 4x^3 - 6x^2 + 5
    return (4 * pow(x, 3) - 6 * pow(x, 2) + 5);
}

int main()
{
    // Header.
    cout << "Homework 12: Derivatives, integrals - Problem 1\n"
         << endl;
    //

    // Declare vars.
    double x;
    double delta_x;
    double decrease_delta_x;
    // double f;

    // Prompt user for inputs.
    cout << "Enter a value for x: ";
    cin >> x;
    cout << "Enter a starting value of Δx: ";
    cin >> delta_x;
    cout << endl;

    //
    double ans = f(x);

    std::ofstream dataOut("derivativeData.dat");
    if (dataOut.is_open())
    {
        for (int i = 1; i <= 100; i++)
        {
            delta_x = 0.7 * delta_x; // Old 0.25.
            double approx = (f(x + delta_x) - f(x)) / delta_x;
            // double error = fabs(ans - approx);
            double exact = f_d(x);

            // Print results.
            cout << "Forward derivative of i = " << i << "; Decreasing Δx = " << delta_x << "; Approximation = " << approx << "; Exact = " << exact << endl;

            // Output data to file.
            dataOut << std::left << std::setw(15) << delta_x
                    << std::right << std::setw(8) << approx << endl;
        }
        cout << "\nFile 'derivativeData.dat' is created." << endl;
    }
    else
    {
        cout << "\nError - File not created." << endl;
    }
    dataOut.close();

    return 0;
}