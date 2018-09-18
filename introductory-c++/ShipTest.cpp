//
// Name:                Kim, Andrew
// Project:             #FINAL
// Due:                 03.12.2018
// Course:              cs-256-02-w18
//
// Description:
//                              C++ Ship Inheritance and Operator Overloading
// 

#include <iostream>
#include "CruiseShip.h"
#include "CargoShip.h"
#include "Ship.h"

using namespace std;

int main() {    

    const int SIZE = 3;
    Ship *ships[SIZE] = { new Ship("StarMary", "1901"), new CargoShip("ToyotaShip", "1999", 200), 
                        new CruiseShip("Titanic", "2000", 3000)};

    cout << "A. Kim's Ship" << endl << endl;
    cout << "Program I/O" << endl;

    for(int i = 0; i < 3; i++) {
        ships[i] -> printInfo();
        cout << endl;
    }

    Ship ship("Boat", "1999");
    CruiseShip cruise("Cruiser", "2222", 100);
    CargoShip cargo("Cargo", "1336", 300);

    cout << ship << endl << cruise << endl << cargo << endl;

    cout << "Enter cruise name, year and capacity here" << endl;
    cin >> cruise;

    cout << "New cruise ship:" << endl << cruise;

    cout << endl;
    cout << "sss" << endl;
    cruise + 10;
    cout << cruise;

    return 0;
}
