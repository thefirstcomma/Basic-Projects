#include <iostream>

using namespace std;

int main() {
	int hi(int seconds);
	hi(30);

	return 0;
}

int hi(int seconds) {
	for(int i = seconds; i > 0; i--) {
		cout << i << endl;
	}

	cout << "Launching" << endl;

	return 0;
}