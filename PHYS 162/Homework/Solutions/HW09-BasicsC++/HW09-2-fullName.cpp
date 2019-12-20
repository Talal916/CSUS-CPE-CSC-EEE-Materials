/*
 A program that prompts the user for their full name and 
 then prints a phrase as output to the screen.
 */

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
    string fullname, date;
    int answer;
	
    cout << "Please enter your full name: ";
    getline(cin, fullname);
	
    cout << "What is today's date? ";
    getline(cin, date);
 
	cout << "What is 2+2? ";
	cin >> answer;
	cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
	
    cout << endl;
 
    cout << "Hello, " << fullname << "!" << endl;
	
    cout << "Today is " << date << "." << endl;
	
	if (answer == 4)
	{
		cout << "Indeed, 2+2 = 4!\n";
	}
	else
	{
		cout << "Your answer is incorrect; 2+2 = 4, not " << answer << "!\n";
	}
	return EXIT_SUCCESS;
}
