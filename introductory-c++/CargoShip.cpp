/
// Name:                Kim, Andrew
// Project:             #FINAL
// Due:                 03.12.2018
// Course:              cs-256-02-w18
//
// Description:
//                      C++ Ship Inheritance and Operator Overloading
// 

#include "CargoShip.h"
#include <string>
#include <iostream>
#include "Ship.h"

using namespace std;

CargoShip::CargoShip(string na, string ye, int cap):Ship(na, ye) {
    capacity = cap;
}

void CargoShip::setCapacity(int cap) {
    capacity = cap;
}

int CargoShip::getCapacity() {
    return capacity;
}
void CargoShip::printInfo() {
    cout << "Name: " << Ship::getName() << endl;
    cout << "Year Built: " << Ship::getYearBuilt() << endl;
    cout << "Capacity: " << capacity << endl;
}

ostream &operator << (ostream &lhs, CargoShip &rhs) {
	lhs << "Name: " << rhs.getName() << endl;
	lhs << "Year: " << rhs.getYearBuilt() << endl;
	lhs << "Capacity: " << rhs.getCapacity() << endl;
	return lhs;
}

