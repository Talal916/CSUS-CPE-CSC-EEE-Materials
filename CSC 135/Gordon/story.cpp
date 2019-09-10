#include <iostream>
/*
Team Name: BROGRAMMERS

Talal Jawaid
Gerardo Ocon
Roberto Ochoa
Amrit Singh
*/

using namespace std;

string animal[10] = {"little girl","giraffe","fox","elephant","puppy","field mouse","pony"};
string attr[10] = {"big red blanket","long long neck","big bushy tail","big big trunk","floppy ears","long skinny tail","thick black mane"};
string sleepy[10] = {"just a tiny bit sleepy","tiny bit sleepy","beginning to be very sleepy","beginning to be just a little bit sleepy","sleepy","very sleepy","asleep"};

void story(int i)
{
    if(i <  7)
    {
        cout << "Once upon a time, there was a " << animal[i] << " with " << attr[i] << endl;
        if(sleepy[i] != "asleep")
            cout << "They were " << sleepy[i] << endl;
        if(animal[i] != "pony")
            cout << "They asked mother for a story.\n" << endl;
        else
            cout << "then he said to his mother, tell....me...a...story\n Once upon a time, but the " << animal[i] << " did not hear, they were asleep." << endl;
        story(i+1);
        cout << "So was the " << animal[i] << " with the " << attr[i] << endl;
    }
}\

int main()
{
    story(0);

}
