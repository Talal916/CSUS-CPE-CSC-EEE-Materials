// ----------------------------------------------
// Final
// ----------------------------------------------

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

double x(double t)
{
    return 5 + 1.2*t - (2/3*sqrt(13)*pow(t,3/2)) - 4*(16+8*t+2*t)*exp(-0.5*t);
}

// Exact.
double v(double t)
{
    return 1.2 - (sqrt(13*t)) + 4*pow(t,2)*exp(-0.5*t);
}

double dfdxForward(double t, double dx)
{
    return ( x(t + dx) - x(t) ) / dx;
}

int main(int argc, char** argv)
{
    int steps = 100;
    double x, dx, dfdx, factor = 0.7;
    std::ofstream outFile;
    
    x = 0.8;
    dx = 1;
	
    std::ostringstream fileName;  // allows to write into a string as into a file stream
    fileName << "derivativeData.dat";
    
    outFile.open(fileName.str()); // add .c_str() after str() if not using C++11
    if(outFile.is_open())
        cout << "outFile stream opened successfully." << endl;
    else
    {
        cout << "outFile stream failed to open!" << endl;
        return EXIT_FAILURE;
    }
    
    for(int i=0;i<steps;i++)
    {
        dfdx = dfdxForward(x,dx);
        outFile << dx << " " << std::setprecision(9) 
			<< dfdx << endl;
        dx *= factor;
    }
    
	outFile.close();
	
    cout << "Approx: " << dfdx << endl;
    cout << "Exact: " << v(x) << endl;
    
	return EXIT_SUCCESS;
}