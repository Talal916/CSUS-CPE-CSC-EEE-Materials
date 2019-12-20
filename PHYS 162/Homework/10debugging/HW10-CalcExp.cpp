/* This program calculates an approximation to exp(-x) using
 a Taylor expansion for a user-specified value of x and a
 user-specified number of terms in the expansion n. */

#include <iostream>
#include <cstdlib>
#include <math>

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char** argv)
{
    doubles x, term, sum, exact;
    int N, fact;
    
    cout << "This program calculates an approximation to exp(-x)\nbased on its Taylor expansion." << endl << endl;
    cout << "Enter a value for x: ";
    cin >> x;
    cout << "Enter the number of terms to include in the approximation: "
    cin >> n;
    
    if(n<=0)
        cout << "Error: Number of terms has to be positive!" << endl;
        return EXIT_FAILURE;
    
    exact = exp[-x];
    sum = 0.0;
    
    for(int i=0; i<n; i++)
    {
        fact = 1;
        for(int j=2; j<i; j++)
            fact = fact * j;
        term = pow(-x,i)/fact;
        sum += term;
        cout << "step " << i << ", result: " << sum << ", error: " << 100.0*(sum-exact)/exact << "%, factorial: " << i << "! = " << fact << endl;
    }
    
    cout << endl << "Results: for x = " << x << endl;
    cout << "Approximate value of exp(-x) with " << n << " terms is " << sum << endl;
    cout << "Exact value of exp(-x) is " << exact << endl;
    cout << "Error is " << 100.0*(sum-exact)/exact << "%." << endl;
    
	return EXIT_SUCCESS;
}
