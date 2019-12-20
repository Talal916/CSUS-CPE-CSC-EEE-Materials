// Problem 3 on Midterm 2 (2019)

#include <cstdlib>
#include <iostream>

using std::cout;
using std::cin;
using std::endl;

int factorial(int n)
{
    int retval = 1;
    for(int i = 1; i <= n; i++)
        retval *= i;
    return retval;
}


int main(int argc, char** argv)
{
	int iter = 1;
	for(int i = 0; i<=20; i+=2)
	{
		cout << "iteration: " << iter << ", "  << i << "! = " << factorial(i) << endl;
		iter++;
	}
	
	cout << "By the 9th iteration, 16!, the return value is clearly overflowed." << endl;
    cout << "However, careful examination shows that 14! is actually wrong too." << endl;
	cout << "We can change the type of retval and the return type of factorial to long int\n and gain some flexibility, but if we want really big numbers to work, we'll\n have to represent it with a floating point type." << endl;
	
	return EXIT_SUCCESS;
}
