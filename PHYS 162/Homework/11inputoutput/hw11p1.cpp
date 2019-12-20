// -------------------------------------------------------------------------------
// Homework 11: Input, output
// --
// Problem 1:
// (a) Create an integer array (i.e., a vector of int variables) that will store
//     the values
//        {-45, 72, 1024, 0, 97, 42, -534}.
//
// (b) Use a loop to print out every element of the array to the screen, one per
//     line, preceded by its index (such as a[2] = ...).
//
// (c) Change the value of 1024 to 768 and add two elements at the end of the array,
//     with values 283 and 526 (again print the full array to the screen.)
// -------------------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <fstream>
#include <string>
#include <limits>
#include <iomanip>
#include <vector>

using std::cin;
using std::cout;
using std::endl;

int main(int argc, char **argv)
{
    cout << "Problem 1\n"
         << endl; // Output header.

    std::vector<int> valArr;

    // (a)
    valArr = {-45, 72, 1024, 0, 97, 42, -534};

    // Array size.
    // cout << "Array: " << valArr.size() << endl;

    // (b)
    for (int i = 0; i < valArr.size(); i++)
    {
        cout << "a[" << i << "] = " << valArr.at(i) << endl;
    }

    cout << "\n"
         << endl;

    // (c)
    std::vector<int> valArrNew;
    valArrNew = {-45, 72, 768, 0, 97, 42, -534};
    valArrNew.push_back(283);
    valArrNew.push_back(526);

    for (int j = 0; j < valArrNew.size(); j++)
    {
        cout << "b[" << j << "] = " << valArrNew.at(j) << endl;
    }

    return EXIT_SUCCESS;
}
