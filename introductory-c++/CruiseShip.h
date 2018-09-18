//
// Name:                Kim, Andrew
// Project:             #FINAL
// Due:                 03.12.2018
// Course:              cs-256-02-w18
//
// Description:
//                              C++ Ship Inheritance and Operator Overloading
// 

#ifndef CRUISESHIP_H
#define CRUISESHIP_H
#include "Ship.h"

using namespace std;

class CruiseShip : public Ship {

private:
    int passengers;

public:
    CruiseShip(string na, string ye, int pass);
    void setPassengers(int pass);
    int getPassengers();
    void printInfo();

    void operator+(const int &rhs);
    friend istream &operator>>(istream &lhs, CruiseShip &rhs); 
    friend ostream &operator<<(ostream &lhs, CruiseShip &rhs);

};

#endif