#include <iostream>
#include <cstdlib>
#include <cmath>
#include <vector>

constexpr double PI = acos(-1.);

double scalarprod(std::vector<double> a, std::vector<double> b)
{
	int size = fmin(a.size(), b.size());
	if (a.size() != b.size()) 
		std::cout << "Warning: the two vectors have different sizes; will use the smaller size for calculation!" << std::endl;
	double out=0.0;
	for (int i=0; i < size; i++)
        out += a.at(i)*b.at(i);
	return out;
}

int main(int argc, char** argv)
{
	std::vector<double> a, b;
	
	a.push_back(5.2); // adding elements with push_back
	a.push_back(-PI);
	a.push_back(2.1);

	b.resize(3);      // declaring b with size 3
	b.at(0) = sqrt(3.0);  // and assigning elements with at
	b.at(1) = exp(1.0);
	b.at(2) = -log(5.0);

	std::cout << "The scalar product of the two vectors is "
		<< scalarprod(a,b) << std::endl;
}
