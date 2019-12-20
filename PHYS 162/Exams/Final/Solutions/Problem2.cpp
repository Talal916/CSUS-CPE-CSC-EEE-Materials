// Problem 2 on Final Exam (2019)

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char** argv)
{
	std::string trash;
 
    std::ifstream dataFile("dataFile.dat");
    if(!dataFile.is_open())
    {
        cout << "Error opening data file... exiting..." << endl;
        return EXIT_FAILURE;
    }
    
    int numpoints = 0;
    while(getline(dataFile, trash))
        numpoints++;
    dataFile.close();
    
    cout << "The data file has " << numpoints << " data points." << endl;
	
	return EXIT_SUCCESS;
}
