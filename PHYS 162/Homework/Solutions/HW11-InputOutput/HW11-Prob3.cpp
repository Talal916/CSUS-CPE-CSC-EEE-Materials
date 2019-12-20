#include <cmath>
#include <fstream>
#include <cstdlib>
#include <iostream>

int main()
{
	const double dx = 0.01, xmin = 0.0, xmax = 10.0;
	std::ofstream out;
	std::string filename = "fct.dat";
	
	out.open(filename);
	if (!out.is_open())
	{
		std::cout << "Could not open the file; check write permission!" << std::endl;
		return EXIT_FAILURE;
	}
	for (double x=xmin; x <= xmax; x += dx)
	{
		out << x << " " << pow(x,2)*sin(2.*x-M_PI/2.) << std::endl;
	}
	out.close();
}