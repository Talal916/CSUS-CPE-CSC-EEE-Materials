#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cmath>

using std::cout;
using std::cin;
using std::endl;

const double PI = std::acos(-1);

int main(int argc, char** argv)
{
	double radius, circum, area;

	cout << "pi = " << std::setprecision(16) << PI << endl;

	cout << "Enter a radius in meters: ";
	cin >> radius;

	circum = 2.*PI*radius;
	area = PI*pow(radius,2);

	cout << "Radius: " << std::setprecision(6) << radius << " m" << endl;
	// added std::setprecision(6) to limit the number of digits in output of the various results.
	cout << "Circumference: " << circum << " m" << endl;
	cout << "Area: " << area << " m^2" << endl;
 
	return EXIT_SUCCESS;
} // end main
