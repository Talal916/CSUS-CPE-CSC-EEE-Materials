// -------------------------------------------------------------------
// Homework 8: Introduction to C++
// --
// Once your program is working, try and modify it to introduce 
// various  types of errors on purpose and compile to see what kind of 
// error messages the compiler gives.
//
// Before doing that, make a copy of your working program, for example 
// called Area-wrong.cpp and work on that copy rather than the 
// original.
// -------------------------------------------------------------------

// line 16: #nclude <cstdlib>
// error: invalid preprocessing directive #nclude; did you mean #include?
// observation: compiler responded to the typo and suggested the right one.
#include <cstdlib>
#include <iostream>
#include <iomanip>

// line 24: removing #include <cmath>
// error: 'acos' is not a member of 'std', note: suggested alternative: 'wios'
//        'pow' was not declared in this scope. note: suggested alternative: 'putw'
// observation: Removing breaks the entire program for math calculations.
#include <cmath>

// line 30: sing std::cin;
// error: 'cin' was not declared in this scope
// observation: It's suggesting to use extern istream cin; however, there was
//              a typo on using.
using std::cin;
using std::cout;

// line 37: removing using std::endl;
// error: 'endl' was not declared in this scope. note: suggested alternative:
//        'std::endl'
// observation: Removing this line forces you to use std::endl namespace.
using std::endl;

constexpr double PI = std::acos(-1);

// line 44: int areaMain(int argc, char** argv)
// error: undefined reference to 'main'
// observation: It's expecting the main function to be there,
int main(int argc, char** argv)
{
    // line 64: renaming double to int
    // error: n/a
    // observation: The program ran fine. The output this time had no precision/decimals
    //              for the calculation.

    // line 64: double adius, circum, area;
    // error: 'radius' was not declared in this scope
    // observation: It's suggesting to rename radius to 'adius' since radius
    //              below is already being initialized.

    // line 64: double radius circum, area;
    // error: expected initializer before 'circum'
    //        'radius' was not declared in this scope
    //        'circum' was not declared in this scope
    //        'area' was not declared in this scope
    //        note: suggested alternative: 'argc'
    // observation: Multiple errors popped up by removing the ','. It thinks
    //              3 variables weren't declared.
    double radius, circum, area;

    // line 69: cout << "pi = " << std::setprecision(16) << PI << endl
    // error: expected ';' before 'cout'
    // observation: Missing a ';' before line 48's cout.
    cout << "pi = " << std::setprecision(16) << PI << endl;

    // line 75: out << "Enter a radius in meters: ";
    // error: 'out' was not declared in this page
    // observation: It seems to think that out is variable that needs to be declared.
    cout << "Enter a radius in meters: ";
    cin >> radius;

    // line 81: circum = 2.*PIradius;
    // error: 'PIradius' was not declared in this scope
    // observation: It's correcting 'PIradius' to be 'radius'.
    circum = 2.*PI*radius;
    area = PI*pow(radius,2);

    cout << "Radius: " << radius << " m" << endl;
    cout << "Circumference: " << circum << " m" << endl;
    cout << "Area: " << area << " m^2" << endl;

    // line 90: removing return EXIT_SUCCESS;
    // error: n/a
    // observation: No error was created. The program ran fine.
    return EXIT_SUCCESS;
}    // end main
