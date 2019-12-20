// -------------------------------------------------------------------
// Homework 8: Introduction to C++
// --
// Type the source code from lecture notes 8, reproduced  below, in a 
// text ﬁle, save it as Area.cpp, compile it, and run it.
//
// Please do not just cut and paste, but type it yourself. You’ll 
// learn much more about what to be careful about this way.
// 
// Again, the line numbers are just there for convenience, and should 
// not be typed into the source code.
// -------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cmath>

using std::cin;
using std::cout;
using std::endl;

constexpr double PI = std::acos(-1);

int main(int argc, char** argv)
{
    double radius, circum, area;

    cout << "pi = " << std::setprecision(16) << PI << endl;

    cout << "Enter a radius in meters: ";
    cin >> radius;

    circum = 2.*PI*radius;
    area = PI*pow(radius,2);

    cout << "Radius: " << radius << " m" << endl;
    cout << "Circumference: " << circum << " m" << endl;
    cout << "Area: " << area << " m^2" << endl;

    return EXIT_SUCCESS;
}    // end main
