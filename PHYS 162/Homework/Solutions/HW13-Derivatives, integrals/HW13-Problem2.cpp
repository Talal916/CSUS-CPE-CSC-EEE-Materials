/*
 A program to calculate the integral of sin(x)/(x^2+4) from 0 to 10.
 */

#include <cstdlib>
#include <iostream>
#include <cmath>

using std::cout;
using std::cin;
using std::endl;

double f(double x)
{
    return sin( x ) / ( pow( x , 2 ) + 4. );
}

double integrate(double x0, double x1, int N)
{
	double dx = ( x1 - x0 ) / N;
	double x, sum = 0.;
	for( int i=0 ; i <= N ; i++ )
	{
		x = x0 + i * dx;
		sum += f(x);
	}
	sum -= ( f(x0) + f(x1) ) / 2.0;
	sum *= dx;
    return sum;
}


int main(int argc, char** argv)
{
    int Ntraps = 4;
    double x0=0., x1=10.;
	double prec = 0.00001; // relative precision required
	double sum=-2., oldsum=0.;
    
	cout << "Enter the relative precision required: ";
	cin >> prec;

	cout << "Initial estimate for N = " << Ntraps << " is " << integrate(x0,x1,Ntraps) << endl;
	
	while (fabs(sum-oldsum) > prec*sum)
	{
		oldsum = sum;
		Ntraps *= 2;
		sum = integrate(x0, x1, Ntraps);
		cout << "For N = " << Ntraps << ", the sum gives " << sum << endl;
		cout << "\tChange from previous estimate is " << (sum-oldsum)/sum << " %" << endl;
	}
    
	
	return EXIT_SUCCESS;
}
