//
// Name:                Kim, Andrew
// Project:             #FINAL
// Due:                 03.12.2018
// Course:              cs-256-02-w18
//
// Description:
//                              C++ Ship Inheritance and Operator Overloading
// 

#ifndef SHIP_H
#define SHIP_H
#include <string>
#include <iostream>

using namespace std;

class Ship {

private:
	string name;
    string year;

public:
       	Ship(string na, string ye);
        string getName();
        void setName(string na);
        string getYearBuilt();
        void setYear(string ye);
        virtual void printInfo();
        
       	friend ostream &operator<<(ostream &lhs, const Ship &rhs); // cout << 

};
#endif