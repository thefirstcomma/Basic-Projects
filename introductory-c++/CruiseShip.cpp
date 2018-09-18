//
// Name:                Kim, Andrew
// Project:             #FINAL
// Due:                 03.12.2018
// Course:              cs-256-02-w18
//
// Description:
//                              C++ Ship Inheritance and Operator Overloading
// 

#include "CruiseShip.h"
#include "Ship.h"
#include <iostream>
#include <string>

using namespace std;

CruiseShip::CruiseShip(string na, string ye, int pass) : Ship(na, ye){
    passengers = pass;
}

void CruiseShip::setPassengers(int pass) {
    passengers = pass;
}

int CruiseShip::getPassengers() {
    return passengers;
}

void CruiseShip::printInfo() {
    cout << "Name: " << Ship::getName() << endl;
    cout << "Year Built: " << Ship::getYearBuilt() << endl;
    cout << "Max passengers: " << passengers << endl;
}

void CruiseShip::operator+(const int &rhs) {
    passengers = passengers + rhs;
}

istream &operator>>(istream &lhs, CruiseShip &rhs) {
    String name, year;
    int passenger;

   	lhs >> name >> year >> passenger;
   	rhs.setName(name);
   	rhs.setYear(year);
   	rhs.setPassengers(passenger);

   	return rhs
}

ostream &operator<<(ostream &lhs, CruiseShip &rhs) {
	lhs << "Name: " << rhs.getName() << endl;
	lhs << "Year: " << rhs.getYearBuilt() << endl;
	lhs << "Passengers: " << rhs.getPassengers() << endl;
	return lhs;
}