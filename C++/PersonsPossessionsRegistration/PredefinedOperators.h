using namespace std;
#include <iostream>
#include <fstream>
#include "PersonsPossessions.h"
#ifndef Operators_H
#define Operators_H

//Предифиниране на символите < , << , >> съответно за извеждане , записване и четене от файл
ostream& operator<(ostream &cos, PersonsPossessions &pp);

ofstream& operator<< (ofstream &os, PersonsPossessions &pp);

ifstream& operator>> (ifstream &is, PersonsPossessions &pp);
#endif