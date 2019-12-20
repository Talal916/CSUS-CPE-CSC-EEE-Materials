// -------------------------------------------------------------------
// Homework 8: Basics of C++
// --
// Write a program that asks for your full name, the date, and the
// answer to 2+2, and then prints
//    Hello, "full name!"
//    Today is "date".
// where "full name" and "date" are replaced by the answers provided
// by the user, followed by a message that depends on whether the
// answer for 2+2 was correct or not.
// -------------------------------------------------------------------

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cmath>
#include <limits>

using std::cin;
using std::cout;
using std::endl;
using std::acos;
using std::sqrt;
using std::string;
using std::setprecision;

int main(int argc, char** argv)
{
    cout << "Problem 2\n" << endl;

    string full_name, date;
    int answer;
    
    cout << "Enter your full name: ";
    getline(cin, full_name); // Get the first and last name.

    cout << "Enter today's date: ";
    getline(cin, date); // Get the full date.

    cout << "What is the answer to 2 + 2?: ";
    cin >> answer;

    cout << "\nHello, " << full_name << "!" << endl;
    cout << "Today is " << date << "." << endl;
    if(answer == 4)
    {
        cout << "2 + 2 = " << answer << " is correct." << endl;
    }
    else
    {
        cout << "2 + 2 = " << answer << " is incorrect." << endl;
    }
    
    return EXIT_SUCCESS;
}



