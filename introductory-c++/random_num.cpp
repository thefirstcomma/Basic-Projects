#include <cstdlib>
#include <string>
using namespace std;

string cmdline_string( char* cmdline_a[], int n ) {
  string S = cmdline_a[ n ];
  return S;
}

char cmdline_char( char* cmdline_a[], int n ) {
  char c = cmdline_a[ n ][0];
  return c;
}

int cmdline_int( char* cmdline_a[], int n ) {
  return atoi( cmdline_a[ n ] );
}

float cmdline_float( char* cmdline_a[], int n ) {
  return atof( cmdline_a[ n ] );
}
