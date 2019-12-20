// ----------------------------------------------
// Final
// ----------------------------------------------

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <fstream>
#include <string>
#include <limits>
#include <iomanip>
#include <vector>
#include <numeric>
#include <algorithm>
#include <iterator>
#include <sstream>

using std::begin;
using std::cin;
using std::copy;
using std::cout;
using std::endl;
using std::ostream_iterator;
using std::ostringstream;
using std::prev;
using std::vector;

int main(int argc, char** argv)
{
    std::ifstream f("File.txt");
    std::string line;
    long i;
    for (i = 0; std::getline(f, line); ++i)
        // cout << line << endl
        ;
    cout << i << " data points found." << endl;
}

