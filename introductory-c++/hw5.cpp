#include <string>
#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;


int jesus() {

    int n=0;
    int sum=0,total=0;

    fstream file("test.txt");
    while(file >> n) // or while(cin >> n) to read from stdin, commandline
    {
        sum += n;
        total++;
    }

    int average = (float) sum/total;

    cout<<"  " << sum;
    cout << "  " << average << endl;
    return 0;
}

int main(int argc, char** argv) {

	ifstream inFile;

	inFile.open("test.txt");

	long long int i = 0; 

	if(!inFile) {
		cout << "File not opened." << endl;
		exit(1);
	}

	cout.width(10);
	cout << "  Count  ";
	cout.width(20);
	cout << "  Sum  ";
	cout.width(20);
	cout << "  Ave  \n";
	cout << "===================================================================\n";
	

	int num, sum = 0, counter = 0;
	double average = 0.0;

	while(inFile >> i) {
		//Condition to stop looking for numbers from test.txt
		if(i == -999) {
			break;
		}

		//print out
		cout << i << " ";
		int a = jesus();
	}


	inFile.close();
	return 0;

}

