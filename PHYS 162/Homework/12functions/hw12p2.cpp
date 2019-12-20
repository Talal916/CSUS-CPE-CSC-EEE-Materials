// -------------------------------------------------------------------------
// Homework 12: Functions
// -------------------------------------------------------------------------

//
// Write a C++ program that does the following:
//
//    (a) deﬁnes a function that calculates and returns
//        f(x) = 3π sin^2* (2√x − 1), where x is a double input argument for
//        the function;
//    (b) deﬁnes a vector<double> called Dvec with 100 elements, where the
//        value of element i is f(i);
//    (c) deﬁnes a function changeElement of 3 arguments vec, idx, and x,
//        where vec is a vector<double>, idx is an int, and x is a double;
//        the function should modify element idx of the vector vec by
//        subtracting x from its current value and return the modiﬁed value;
//    (d) calls the function changeElement on each even element of Dvec with
//        the value of argument x being the next element in the vector
//        (that is x=Dvec.at(11) when called on element 10 of Dvec); and
//    (e) adds all elements of the modiﬁed vector Dvec together (hint: use a
//        loop) and prints the result.
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
#include <algorithm> // std::for_each

using std::cin;
using std::cout;
using std::endl;
using std::vector;

// (a)
double f(double x)
{
    double equation;
    equation = 3 * M_PI * pow(sin((2 * sqrt(x)) - 1), 2);
    return equation;
}

// (c)
double changeElement(vector<double> vec, int idx, double x)
{
    double modifiedValue;
    modifiedValue = vec.at(idx) - x;
    return modifiedValue;
}

int main(int argc, char **argv)
{
    // Header.
    cout << "Problem 2\n" << endl;

    std::vector<double> Dvec(100);
    double sum = 0.0;

    // (b)
    for (int i = 0; i < Dvec.size(); i++)
    {
        // Populate the vector 'Dvec' here, where
        // the value of element i is f(i);

        /*
        cout << "Dvec[" << i << "] = " << Dvec.at(i) << endl;
            // "\t  " << changeElement(Dvec, i % 2, i) << endl;
        */

        Dvec.at(i) = f(i);
    }

    // (d) Call function 'changeElement' on each even element of Dvec. 
    //     & add all elements of the modified vector Dvec together.
    //     Don't create another vector.
    for (int j = 0; j < Dvec.size(); j++)
    {
        Dvec.at(j) = f(j);

        // If statement block that contains a condition using
        // a modulus to confirm whether j is even or not.

        // If even....
        if(j % 2 == 0)
        {   
            /*
            cout << "Even Dvec[" << j << "] = " 
                << changeElement(Dvec, j, Dvec.at(j + 1)) << endl; // x=Dvec.at(100) when called
            */                                              // on element 99 of Dvec.
            
            sum += changeElement(Dvec, j, Dvec.at(j + 1));
        }
        // If not even...
        else 
        {
            /*
            cout << "Dvec[" << j << "] = " 
                << Dvec.at(j) << endl;
            */
            
            sum += Dvec.at(j);
        }
    }

    cout << "Sum = " << sum << endl;

    return EXIT_SUCCESS;
}
