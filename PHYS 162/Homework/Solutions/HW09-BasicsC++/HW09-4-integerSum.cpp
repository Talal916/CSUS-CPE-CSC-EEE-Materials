/*
 A program that displays the integers from 0 to 50
 and the cumulative sum of the integers at each step.
 */

#include <cstdlib>
#include <iostream>

using std::cout;
using std::endl;

int main(int argc, char** argv)
{
    int sum=0;
    
    for(int i=0;i<=50;i++)
    {
        sum+=i;
        cout << "i = " << i << "\t\tsum = " << sum << endl;
    }
    
	return EXIT_SUCCESS;
}
