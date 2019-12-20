/* Declares an integer array using static memory
 allocation and doing some basic stuff with it. */

#include <iostream>
#include <cstdlib>
#include <vector>

using std::cout;
using std::endl;

int main()
{
    std::vector<int> arr = { -45, 72, 1024, 0, 97, 42, -534 };
    
    for(unsigned int i=0; i<arr.size(); i++)
        cout << "arr[" << i << "] = " << arr.at(i) << endl;
    
    arr.at(2) = 768;
	arr.push_back(283);
	arr.push_back(526);
	
    cout << endl;
    for(unsigned int i=0; i<arr.size(); i++)
		cout << "arr[" << i << "] = " << arr.at(i) << endl;

	return EXIT_SUCCESS;
}
