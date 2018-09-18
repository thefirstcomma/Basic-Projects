#include <iostream>
#include <string>
using namespace std;

const int WIDTH = 70;
const int HEIGHT = 50;

void init(char[HEIGHT][WIDTH]);
char set_char(string);
void place_char(int, int, char, char[HEIGHT][WIDTH]);
void printout(char[HEIGHT][WIDTH]);

int main() {

	int row = 0, col = 0;
	char c = (char) 0;
	char grid[HEIGHT][WIDTH];
	string word = "";

	while(row >= 0) {
		cin >> col;
		cin.ignore();
		getline(cin, word);

		c = set_char(word);
		place_char(row, col, c, grid);
		cin >> row;
	}

	printout(grid);

	return 0;
}

void init(char grid[HEIGHT][WIDTH]) {

	for(int row = 0; row < HEIGHT; row += 1) {
		for(int col = 0; col < WIDTH; col += 1) {
			grid[row][col] = ' ';
		}
	}

}

char set_char(string s) {
	if (s == "SPACE")
		return ' ';
	return s[0];
}

void place_char(int row, int col, char c, char grid[HEIGHT][WIDTH]) {
	if(0 <= row && row <= HEIGHT && 0 <= col && col <= WIDTH) 
		grid[row][col] = c;
}

void printout(char grid[HEIGHT][WIDTH]) {
	cout << clear();

	for (int row = 0; row < HEIGHT; row += 1) {
		for (int col = 0; col < WIDTH; col += 1) {
			cout << gotorc(row, col) << grid [row][col];
		}
	}

	cout << endl;
	cout << flush;
}


