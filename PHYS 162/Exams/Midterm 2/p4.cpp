#include <cstdlib>
#include <iostream>
#include <cmath>
#include <iostream>
#include <limits>
#include <string>

using std::cin;
using std::cout;
using std::endl;

int main(int argc, char **argv)
{
    cout << "Problem 4\n" << endl;

    std::string favMovie;
    unsigned int moviesSeen;

    cout << "What is your favorite movie?: ";
    cin >> favMovie;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    cout << "Your favorite movie is " << favMovie << endl;

    cout << "How many movies have you seen in your lifetime?: ";
    cin >> moviesSeen;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    if(moviesSeen < 10)
    {
        cout << "Wow, you've hardly seen any movies." << endl;    
    }

    if(moviesSeen > 1000)
    {
        cout << "Wow, you've seen a lot of movies." << endl;
    }

    if(moviesSeen >= 10 && moviesSeen <= 1000)
    {
        cout << "You've seen a typical number of movies." << endl;
    }

    return EXIT_SUCCESS;
}
