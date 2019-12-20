/*
 A program that prompts the user for their age in years,
 their weight in kilograms, and their height in centimeters.
 Then it uses conditional structures to print various
 outputs to the screen.
 */

#include <cstdlib>
#include <iostream>
#include <limits>

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char** argv)
{
    unsigned int age; // age in years
    
    float weight; // weight in kilograms
    
    float height; // height in centimeters
    
    cout << "Please enter your age in years: ";
    cin >> age;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
	
    cout << "Please enter your weight in kilograms: ";
    cin >> weight;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    cout << "Please enter your height in centimeters: ";
    cin >> height;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    
    cout << endl;
    
    // Here the presumption is that we are talking about
    // independent driving and the legal driving age is assumed
    // to be 16.
    if (age>=16)
        cout << "(a) Since you are at least 16 years old, you are old enough to drive." << endl;
    else
        cout << "(a) Since you are younger than 16 years, you are not old enough to drive." << endl;
    
    // Test if age is between 20 and 29 inclusive
    if (age>=20 && age<=29)
        cout << "(b) You are in your twenties." << endl;
    else
        cout << "(b) You are not in your twenties." << endl;
    
    // Test if age is less than 22 and weight is less than 65 kg OR
    // if age is greater than 26 and height is greater than 180 cm
    if ((age<22 && weight<65) || (age>26 && height>180))
        cout << "(c) You are either younger than 22 years and less than 65 kg or you are older\n than 26 years and taller than 180 cm." << endl;
    else
        cout << "(c) You are neither younger than 22 years and less than 65 kg nor older than 26\n years and taller than 180 cm." << endl;
    
    // Test if age is less than 18, height is less than 150 cm,
    // and weight is outside the range 60-64 kg.
    if (age<18 && height<150 && (weight<60 || weight>64))
        cout << "(d) You are neither old enough to vote, tall enough to hit your head on a 150 cm\n door frame, nor the right weight to box in the 60-64 kg division." << endl;
    else
        cout << "(d) You are either old enough to vote, tall enough to hit your head on a 150 cm\n door frame, or the right weight to box in the 60-64 kg division (could be more\n than one)." << endl;
    
	return EXIT_SUCCESS;
}
