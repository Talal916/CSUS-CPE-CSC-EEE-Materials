// -------------------------------------------------------------------
// Homework 8: Basics of C++
// --
// Write a program that asks for your age in years, your weight in
// kilograms, and your height in centimeters and then tells you
// the following based on the values provided:
//     (a) If you are old enough to drive;
//     (b) Whether or not you are in your twenties.
//     (c) If you are either younger than 22 and less than 65 kg,
//         or older than 26 and taller than 180 cm.
//     (d) If you are neither old enough to vote, tall enough to hit
//         your head on a 150 cm door frame, nor the right weight to
//         box in the 60-64 kg division (all or none).
// Each item should be a single test leading to a printed statement
// indicating that the test was passed ("You are old enough to drive")
// or that the test was failed ("You are not old enough to drive.").
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
    cout << "Problem 3\n" << endl;

    int age, weight, height;

    cout << "Enter your age (years): ";
    cin >> age;

    cout << "Enter your weight (kg): ";
    cin >> weight;

    cout << "Enter your height (cm): ";
    cin >> height;

    cout << "\n";

    if(age >= 16)
    {
        cout << "You are old enough to drive." << endl;    
    }
    else if(age < 16)
    {
        cout << "You are not old enough to drive." << endl;
    }

    if(age >= 20 && age <= 29)
    {
        cout << "You are in your twenties." << endl;
    }
    else if(age < 20 || age > 29)
    {
        cout << "You are not in your twenties." << endl;
    }

    if(age < 22 && weight < 65)
    {
        cout << "You are younger than 22 and less than 65 kg." << endl;
    }
    else if(age > 22 && weight > 65)
    {
        cout << "You not younger than 22 and more than 65 kg." << endl;
    }

    if(age > 26 && height > 180)
    {
        cout << "You are older than 26 and taller than 180 cm." << endl;
    }
    else if(age < 26 && height < 180)
    {
        cout << "You are younger than 26 and shorter than 180 cm." << endl;
    }

    if(age >= 18)
    {
        cout << "You are old enough to vote." << endl;
    }
    else if(age < 18)
    {
        cout << "You are not old enough to vote." << endl;
    }

    if(height >= 150)
    {
        cout << "You are tall enough to hit your head on a 150 cm door frame." << endl;
    }
    else if(height < 150)
    {
        cout << "You are not tall enough to hit your head on a 150 cm door frame." << endl;
    }

    if(weight >= 60 && weight <= 64)
    {
        cout << "You are the right weight to box in the 60-64 kg division." << endl;
    }
    else if(weight < 60 || weight > 64)
    {
        cout << "You are not the right weight to box in the 60-64 kg division." << endl;
    }

    return EXIT_SUCCESS;
}



