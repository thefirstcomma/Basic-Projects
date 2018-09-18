
// cpp/cos/cs/256/01/w18/Rational tvnguyen7

#include <iostream>

#include "Rational.h"

Rational::Rational(int p, int q)
{
	this->p = p;
	this->q = q;
}

Rational Rational::operator*(const Rational& rhs) const
{
	return Rational(p * rhs.p, q * rhs.q);
}

Rational Rational::operator/(const Rational& rhs) const
{
	return Rational(p * rhs.q, q * rhs.p);
}

Rational Rational::operator/(int rhs) const
{
	return *this / Rational(rhs);
}

Rational::operator double () const
{
	return static_cast<double>(p) / q;
}

std::istream& operator>>(std::istream& lhs, Rational& rhs)
{
	lhs >> rhs.p >> rhs.q;

	return lhs;
}

std::ostream& operator<< (std::ostream& lhs, const Rational &rhs)
{
	lhs << rhs.p << '/' << rhs.q;

	return lhs;
}

