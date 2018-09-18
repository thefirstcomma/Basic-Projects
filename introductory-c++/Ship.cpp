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
#include <string>
#include "Ship.h"

using namespace std;

Ship::Ship(string na, string ye) {
    name = na;
    year = ye;
}

string Ship::getName() {
    return name;
}

void Ship::setName(string na) {
    name = na;
}

string Ship::getYearBuilt() {
    return year;
}

void Ship::setYear(string ye) {
    year = ye;
}

void Ship::printInfo() {
    cout << "Name: " << name << endl;
    cout << "Year built: " << year << endl;
}

ostream &operator << (ostream& lhs, const Ship &rhs) {
	return lhs << "Name: " << getName() << "Year: " << getYearBuilt();
        
}