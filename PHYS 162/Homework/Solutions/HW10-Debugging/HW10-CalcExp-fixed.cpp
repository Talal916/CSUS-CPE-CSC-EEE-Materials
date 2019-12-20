/* This program calculates an approximation to exp(-x) using
 a Taylor expansion for a user-specified value of x and a
 user-specified number of terms in the expansion n. */

#include <iostream>
#include <cstdlib>
#include <cmath>   // the math library is cmath, not math!

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char** argv)
{
    double x, term, sum, exact;   // double is singular, even if several variables are declared!
    long int n, fact;    // N and n are different variables!
    		// using long int allows to include more terms and get to the required precision for x=5
    
    cout << "This program calculates an approximation to exp(-x)\nbased on its Taylor expansion." << endl << endl;
    cout << "Enter a value for x: ";
    cin >> x;
    cout << "Enter the number of terms to include in the approximation: "; // missing ;
    cin >> n;
    
    if(n<=0) { // without curly brackets, only the next line is part of if, and return is always called, so the program stopped here with failure output.
        cout << "Error: Number of terms has to be positive!" << endl;
        return EXIT_FAILURE;
    }
    exact = exp(-x);   // functions use () for arguments, not []!
    sum = 0.0;
    
    for(int i=0; i<n; i++)
    {
        fact = 1;
        for(int j=2; j<=i; j++) // fact = i*(i-1)*..., so test j<i misses one multiplication!
            fact = fact * j;
        term = pow(-x,i)/fact;
        sum += term;
        cout << "step " << i+1 << ", term added: " << term << ", factorial: " << i << "! = " << fact << endl <<"  result: " << sum << ", error: " << 100.0*(sum-exact)/exact << "%" << endl; // humans count from 1, not 0! (not really an error)
    }
    
    cout << endl << "Results: for x = " << x << endl;
    cout << "Approximate value of exp(-x) with " << n << " terms is " << sum << endl;
    cout << "Exact value of exp(-x) is " << exact << endl;
    cout << "Error is " << 100.0*(sum-exact)/exact << "%." << endl;
    
	return EXIT_SUCCESS;
}
