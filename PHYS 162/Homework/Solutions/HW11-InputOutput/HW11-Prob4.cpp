#include <cmath>
#include <fstream>
#include <cstdlib>
#include <iostream>
#include <vector>

int main()
{
	double x0, f0, x1, f1;
	std::ifstream in;
	std::ofstream out;
	std::string datafilename = "fct.dat";
	std::string outfilename = "slope.dat";
	
	in.open(datafilename);
	if (!in.is_open())
	{
		std::cout << "Could not open the file; check that it exists and you have read permission!" << std::endl;
		return EXIT_FAILURE;
	}
	
	int cnt = 0;
	std::string line;
	while (getline(in, line)) cnt++;
	
	in.clear();
	in.seekg(0);

	std::vector<double> xdata(cnt), fdata(cnt);
	
	for (int i=0; i<cnt; i++)
		in >> xdata.at(i) >> fdata.at(i);

	in.close();
	
	out.open(outfilename);
	if (!out.is_open())
	{
		std::cout << "Could not open the file; check write permission!" << std::endl;
		return EXIT_FAILURE;
	}

	double slope;
	for (int i=1; i<cnt; i++)
	{
		x0 = xdata.at(i-1); // preceding point
		f0 = fdata.at(i-1);
		x1 = xdata.at(i);   // current point
		f1 = fdata.at(i);
		slope = (f1-f0)/(x1-x0);
		out << 0.5*(x0+x1) << " " << slope << std::endl;
	}
	
	out.close();
}