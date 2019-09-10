#include <iostream>
/*
Author: Talal Jawaid
Date: 9/13/2018
Program Details:
Prints all positive Ints from N to 0
Then prints all positive EVEN Ints from 0 to N
*/
using namespace std;

int printLetters(int N)
{
	if(N==0)
	{
		cout << N << endl;
		return 0;
	}
	else if(N>=1)
	{
		cout << N << endl;
		printLetters(N-1);
		if(N%2==0)
		{
			cout << N << endl;
			return 0;
		}	
	}
	return 0;
}
int main() {
	int N;
	cout << "Enter a positive integer: ";
	cin >> N;
	printLetters(N);
}