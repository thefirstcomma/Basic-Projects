#include <iostream>
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

    cout<<"sum: " << sum << endl;
    cout << "average: " << average << endl;
    return 0;
}