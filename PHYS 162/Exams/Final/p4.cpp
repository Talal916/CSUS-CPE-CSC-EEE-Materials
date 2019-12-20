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
using std::string;

// Cap the score if user scored above 100
int cap(int score)
{
    int cap = 100;
    return cap;
}

int main(int argc, char** argv)
{
	int numericalScore;
	string grade;
	
	cout << "What is your numerical score? ";
	cin >> numericalScore;
	cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    cout << endl;
	
	if(numericalScore >= 84 && numericalScore <= 100)
		cout << "The score of " << numericalScore << "% should be assigned a letter grade of A." << endl;
	else if(numericalScore >= 69 && numericalScore <= 83)
		cout << "The score of " << numericalScore << "% should be assigned a letter grade of B." << endl;
	else if(numericalScore >= 53 && numericalScore <= 68)
		cout << "The score of " << numericalScore << "% should be assigned a letter grade of C." << endl;
    else if(numericalScore >= 40 && numericalScore <= 52)
		cout << "The score of " << numericalScore << "% should be assigned a letter grade of D." << endl;
    else if(numericalScore >= 0 && numericalScore <= 39)
		cout << "The score of " << numericalScore << "% should be assigned a letter grade of D." << endl;
    else if(numericalScore > 100)
		cout << "The score of " << numericalScore << "% is capped to " << cap(numericalScore) << "% should be assigned a letter grade of A." << endl;
    else
        cout << "Score invalid and out of range." << endl;
	
	return EXIT_SUCCESS;
}
