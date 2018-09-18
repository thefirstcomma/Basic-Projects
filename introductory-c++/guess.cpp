//
// Name: 		Kim, Andrew
// Project: 	1
// Due: 		1/31/2018
// Course: 		cs-256-02-w18
//
// Description: 
//				A random number guessing game, that validates user input.
//
#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main() {
	srand((int) time(NULL));
	
	cout << "A. Kim's Number Guessing Game\n\n" << endl;
	cout << "A secret number between 1-100 generated...\n\n" << endl;

	
	int randomNumber = (rand() % 100) + 1;
	int guess, counter = 1;

	do {
		cout << "Please enter your guess? ";
		cin >> guess;

		
		if(guess > randomNumber && guess <= 100) {
			cout << "Guess is high..." << endl;
			++counter;
		} else if(guess < randomNumber && guess >= 1) {
			cout << "Guess is low..." << endl;
			++counter;
		} else if(guess == randomNumber) {
			cout << "Correct in " << counter << " guesses." << endl;
		} else if(guess < 0 || guess > 100){
			cout << "Invalid input" << "." << endl;
			continue;
		}
	}

	while(guess != randomNumber && guess != 0 && counter <= 8);

	if(counter >= 9) {
		cout << "\n\nToo many guesses, the secret number is " << randomNumber << "." << endl;
	} else if(guess == 0) {
		cout << "\n\nThe secret number is " << randomNumber << "." << endl;
	}
	
	
	return 0;
}