// Problem 1 on Final Exam (2019)

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <fstream>

using std::cout;
using std::cin;
using std::endl;

double x(double t)
{
    return 5 + 1.2 * t - ( 2.0 / 3.0 ) * std::pow( 13 , 0.5 ) * std::pow( t , 3.0 / 2.0 )
            - 4 * ( 16 + 8 * t + 2 * std::pow( t , 2 ) ) * std::exp( -0.5 * t );
}


int main(int argc, char** argv)
{
	double tmin = 0.0;
    double tmax = 10.0;
    int steps = 1001;
    double dt = ( tmax - tmin ) / ( steps -1 );
    double t, v;
    
    std::ofstream outputFile("v_of_t.dat");
    if(!outputFile.is_open())
    {
        cout << "Output file failed to open!  Exiting..." << endl;
        return EXIT_FAILURE;
    }
    
    for( int i = 0; i < steps; i++ )
    {
        t = tmin + i * dt;
        v = ( x( t + dt / 2.0 ) - x( t - dt / 2.0 ) ) / dt;
        outputFile << t << "\t" << v << endl;
    }
    outputFile.close();
	
	return EXIT_SUCCESS;
}
