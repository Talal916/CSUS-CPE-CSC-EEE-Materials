// -------------------------------------------------------------------
// Homework 10: Debugging
// --
// Download the program 'HW10-CalcExp.cpp' from Google Drive and
// debug it. The program is supposed to calculate an approximation
// to the exponential function e^-x using its Taylor expansion
//    e^-x = [sumation from n=0 to inf] * (-x)^-n/n!
// -------------------------------------------------------------------

/* This program calculates an approximation to exp(-x) using
 a Taylor expansion for a user-specified value of x and a
 user-specified number of terms in the expansion n. */

#include <iostream>
#include <cstdlib>
// #include <math> - compilation terminated.
#include <cmath>
#include <stdlib.h> // for absolute value "abs()"

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char** argv)
{
    // doubles - suggested alternative: 'double'
    double x, term, sum, exact;
    // int N - makes the factorial into a negative as factorial gets larger.
    unsigned long int N, fact; // unsigned long - output largest numbers for factorial.
    
    cout << "This program calculates an approximation to exp(-x)\nbased on its Taylor expansion." << endl << endl;
    cout << "Enter a value for x: ";
    cin >> x;

    // cout << "Enter the number of terms to include in the approximation: " - expected ';' before 'cin'
    cout << "Enter the number of terms to include in the approximation: ";
    
    // cin >> n; - 'n' was not declared in this scope
    // n's in the rest of the code was corrected to 'N'
    cin >> N;
    
    // if(N<=0)
    //     cout << "Error: Number of terms has to be positive!" << endl;
    //     return EXIT_FAILURE;
    // this 'if' clause does not guard... [-Wmisleading-indendation]
    
    if(N <= 0)
    {
        cout << "Error: Number of terms has to be positive!" << endl;
        return EXIT_FAILURE;
    }
    
    // exact = exp[-x]; - invalid tpyes 'double(double) throw ()[double]'
    //                    array subscript
    exact = exp(-x);
    sum = 0.0;
    
    for(int i = 0; i < N; i++)
    {
        fact = 1;
        // for(int j = 2; j < i; j++) - 'j < i' is making 4! = 6 therefore factorial
        //                              is incorrect.
        for(int j = 2; j <= i; j++)
            fact = fact * j;
        term = pow(-x, i) / fact;
        sum += term;
        cout << "step " << i << ", result: " << sum << ", error: " << 100.0 * (sum-exact) / exact << "%, factorial: " << i << "! = " << fact << ", term = " << term << endl;
    }
    
    cout << endl << "Results: for x = " << x << endl;
    cout << "Approximate value of exp(-x) with " << N << " terms is " << sum << endl;
    cout << "Exact value of exp(-x) is " << exact << endl;
    cout << "Error is " << 100.0*(sum-exact) / exact << "%." << endl;
    
    // 
    // Remarks
    // 

    // For x: 5; terms: 30; step 24 is where the result for e^-5 is within
    // 1% accuracy. The result is steadily going down (converging) however, the signs
    // are alternating. I've also noticed that after step 24, the result starts 
    // to increase. 

    // For trying x: 5, term: 100; the output returns -nan and -inf or inf 
    // after step 65 & factorial starts to equal 0.

    // The problem that prevented me from getting a better precision was 
    // not fixing the factorial loop.
	return EXIT_SUCCESS;
}
