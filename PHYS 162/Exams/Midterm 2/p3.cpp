#include <cstdlib>
#include <iostream>
#include <cmath>
#include <iostream>
#include <limits>

using std::cin;
using std::cout;
using std::endl;

int factorial(int n)
{
    int retval = 1;

    for (int i = 1; i <= n; i++)
    {
        retval *= i;
    }

    return retval;
}

int main(int argc, char **argv)
{
    cout << "Problem 3\n" << endl;

    int n = 1000000000;

    for(int i = 0; i <= n; i++)
    {
        cout << "Factorial of " << i << " = " << factorial(i) << endl;
    }
    
    // 10000000000 iterations breaks the program.
    // Using std ignore will fix the overflow.
    return EXIT_SUCCESS;
}

