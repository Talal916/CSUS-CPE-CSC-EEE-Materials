#include <iostream>
/*
 * Team Name: BROGRAMMERS
 * Talal Jawaid
 * Gerardo Ocon
 * Roberto Ochoa
 * Amrit Singh
 * minor modifications by Scott Gordon
 * */

using namespace std;

const string animal[10] = {"little girl","giraffe","fox","elephant","puppy","field mouse","pony"};
const string attr[10]   = {"big red blanket","long long neck","big bushy tail","big big trunk",
                     "floppy ears","long skinny tail","thick black mane"};
const string sleepy[10] = {"just a tiny bit sleepy","tiny bit sleepy","beginning to be very sleepy",
                     "beginning to be just a little bit sleepy","sleepy","very sleepy","sleepy sleepy"};

void story(const int i)
{
  cout << "Once upon a time, there was a " << animal[i] << " with a " << attr[i] << endl;
  cout << "She was " << sleepy[i] << endl;
  cout << "She asked her mother - Tell me a story." << endl;
  cout << "So her mother said," << endl << endl;

  if(animal[i] == "pony")
    cout << "but the " << animal[i] << " did not hear, she was asleep." << endl << endl;
  else
  { story(i+1);
    cout << "So was the " << animal[i] << " with the " << attr[i] << endl;
  }
}

int main()
{
    story(0);
}

