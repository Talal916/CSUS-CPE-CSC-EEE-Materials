#include <cstdlib>
#include <iostream>
#include <cmath>

using std::cout;
using std::cin;
using std::endl;

const double PI = std::acos(-1);

int main(int argc, char** argv)
{
    double radius, surface_area, volume;
    
    cout << "pi = " << PI << endl;
    
    cout << "Enter a radius in meters: ";
    cin >> radius;
    
    surface_area = 4*PI*pow(radius,2);
    volume = 4*PI*pow(radius,3)/3;
    
    cout << "Radius: " << radius << " m" << endl;
    cout << "Surface Area: " << surface_area << " m^2" << endl;
    cout << "Volume: " << volume << " m^3" << endl;
    
	return EXIT_SUCCESS;
}
