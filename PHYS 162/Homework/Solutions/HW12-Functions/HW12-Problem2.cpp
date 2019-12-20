#include <iostream>
#include <cstdlib>
#include <fstream>
#include <cmath>
#include <vector>

constexpr double PI = acos(-1.);

double fct(double x)
{
	double s,f;
	s = sin(2.0*sqrt(x)-1.0);
	f = 3.0*PI*pow(s,2);
	return f;
}

double changeElement(std::vector<double>& vec, int idx, double x)
  // vec needs to be a reference or its elements will not be modified 
  // (only those of the copy of vec in the function are!)
{ // uncomment to print more details on what the function does
/*	std::cout << "idx = " << idx
		<< ", vec[idx] = " << vec.at(idx)
		<< ", vec[idx+1]= " << vec.at(idx+1)
		<< ", x = " << x << std::endl; */
	vec.at(idx) -= x;
	double newelem = vec.at(idx);
//	std::cout << "New value: " << newelem << std::endl;
	return newelem;	
}

int main(int argc, char** argv)
{
	std::vector<double> Dvec(100);
	
	// assign the vector elements:
	for (unsigned int i=0; i<Dvec.size(); i++) {
		Dvec.at(i) = fct(i);
/*		std::cout << "Dvec[" << i << "] = " 
			<< Dvec.at(i) << std::endl; */
	}
	
	// Modifies all even elements
	for (unsigned int i=0; i<Dvec.size(); i += 2)
	{
		double oldval = Dvec.at(i);
		std::cout << "elem " << i << " change from "
			<< oldval << " to " 
			<< changeElement(Dvec, i, Dvec.at(i+1))
			<< std::endl;
		std::cout << "elem " << i+1 << " unchanged at "
			<< Dvec.at(i+1) << std::endl;
	}

	// add up all the elements as sum variable
	double sum=0.0;
	for (unsigned int i=0; i<Dvec.size(); i++)
        sum += Dvec.at(i);
	
    std::cout << "The sum of all elements of Dvec is " 
		<< sum << std::endl;
}
