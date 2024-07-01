#include "timecard.h"

static int N;

void init(int n) {
	N = n;
}

std::string convert(std::string s) {
	for(int i = 0; i<s.length(); i++){
           if(s[i] < 97) s[i] = s[i] + 32;
        }
	return s;
}