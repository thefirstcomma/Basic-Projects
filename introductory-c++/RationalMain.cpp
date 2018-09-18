
// cpp/cos/cs/256/01/w18/Rational tvnguyen7

#include <iostream>
#include "Rational.h"

using namespace std;

int main()
{
	Rational r1(1, 2);
	Rational r2(1, 2);

	Rational r3 = r1 / r2;
	Rational r4 = r1 + r2;

	cout << r3 << endl;
	cout << static_cast<double>(r3) << endl;

	r3 = 2 / r2;

	cout << 1.0 + r3 << endl;	// automatic convert r3 to double
	cout << r4 << endl;
}