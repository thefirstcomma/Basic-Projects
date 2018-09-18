//
// Name:                Kim, Andrew
// Project:             #FINAL
// Due:                 03.12.2018
// Course:              cs-256-02-w18
//
// Description:
//                      C++ Ship Inheritance and Operator Overloading
// 

#ifndef CARGOSHIP_H
#define CARGOSHIP_H
#include "Ship.h"

class CargoShip : public Ship {

private:
    int capacity;

public:
    CargoShip(string na, string ye, int cap);
    void setCapacity(int cap);
    int getCapacity();
    void printInfo();

    friend ostream &operator<<(ostream &lhs, CargoShip &rhs);

};
#endif