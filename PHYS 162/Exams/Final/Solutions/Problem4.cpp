// Problem 4 on Final Exam (2019)

#include <cstdlib>
#include <iostream>
#include <string>
#include <limits>

using std::cout;
using std::cin;
using std::endl;

void capScore(double& score)
{
    if(score > 100)
        score = 100;
}

int main(int argc, char** argv)
{
	double score;
    std::string letter;
 
    cout << "Please enter the student's score: ";
    cin >> score;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    
    capScore(score);
    
    if(score >= 84)
        letter = "A";
    else if(score >= 69)
        letter = "B";
    else if(score >= 53)
        letter = "C";
    else if(score >= 40)
        letter = "D";
    else if(score >= 0)
        letter = "F";
    else
    {
        cout << "Score can't be negative!" << endl;
        return EXIT_FAILURE;
    }
    
    cout << "The score of " << score << "% should be assigned a letter grade of " << letter << "." << endl;
	
	return EXIT_SUCCESS;
}
