#include <cstdlib>
#include <iostream>
#include <cmath>

using std::cout;
using std::cin;
using std::endl;

double f(double x, double y, double & z)
{
    double retval;
    
    retval = std::sin(x * y);
    
    z = retval + 1.0;
    
    return retval;
}

int main(int argc, char** argv)
{
    double z, c;
    double x = 0.25, y = 2.;
    c = f(x, y, z);
    
    cout << "f(x,y,z) = " << c << endl;
    cout << "z = " << z << endl;
    
	return EXIT_SUCCESS;
}
