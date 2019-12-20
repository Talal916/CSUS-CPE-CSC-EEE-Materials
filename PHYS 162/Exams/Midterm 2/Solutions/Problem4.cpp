// Problem 4 on Midterm 2 (2019)

#include <cstdlib>
#include <iostream>
#include <string>
#include <limits>

using std::cout;
using std::cin;
using std::endl;
using std::string;

int main(int argc, char** argv)
{
	int numMovies;
	string movieName;
	
	cout << "What is your favorite movie? ";
	getline(cin,movieName);
	
	cout << movieName << " is a really great movie." << endl << endl;
	
	cout << "How many movies have you seen? ";
	cin >> numMovies;
	cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
	
	if(numMovies < 10)
		cout << "Wow, you've hardly seen any movies!" << endl;
	else if(numMovies > 1000)
		cout << "Wow, you've seen a lot of movies!" << endl;
	else
		cout << "You've seen a typical number of movies." << endl;
	
	return EXIT_SUCCESS;
}
