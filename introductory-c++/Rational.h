
// cpp/cos/cs/256/01/w18/Rational tvnguyen7

//#pragma once

#ifndef _INC_RATIONAL
#define _INC_RATIONAL

#include <iostream>

class Rational {
private:
	int	p, q;

public:
	Rational(int numerator = 0, int denominator = 1);

	Rational operator*(const Rational& rhs) const;	// r3 = r1 * r2
	Rational operator/(const Rational& rhs) const;
	Rational operator/(int rhs) const;	// r4 = r3 / 5
	//Rational operator+(const Rational& rhs) const;

	operator double() const;  // 1.0 + r1  auto convert r1 to double

	friend std::istream& operator>>(std::istream& lhs, Rational& rhs);	// cin >> r5
	friend std::ostream& operator<<(std::ostream& lhs, const Rational &rhs); // cout << r5
};

#endif