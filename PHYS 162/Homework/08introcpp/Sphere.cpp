// -------------------------------------------------------------------
// Homework 8: Introduction to C++
// --
// Write another program similar to Area.cpp that will ask for a 
// radius,  calculate the volume (V = 4/3*π*R^3) and surface area 
// (A = 4*π*R^2) of  a sphere of that radius, and print the results to 
// the screen.
// 
// Make sure that the result is correct before submitting!
// -------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cmath>

using std::cin;
using std::cout;
using std::endl;
using std::acos;
using std::setprecision;

constexpr double PI = acos(-1);

int main(int argc, char** argv)
{
    // Declare variables: (R)adius, (V)olume, Surface (A)rea.
    double R, V, A;

    cout << "pi = " << setprecision(16) << PI << endl;

    // Prompt the user to enter the radius.
    cout << "Enter a radius in meters: ";
    cin >> R;

    V = ((float)4/3) * PI * pow(R, 3);  // Volume formula.
    A = 4 * PI * pow(R, 2); // Area formula.

    cout << "Radius: " << R << " m" << endl;
    cout << "Volume: " << V << " m" << endl;
    cout << "Surface Area: " << A << " m^2" << endl;

    return EXIT_SUCCESS;
} 
