using namespace std;
#include <iostream>
#include <fstream>
#include "PersonsPossessions.h"
#ifndef Operators_H
#define Operators_H

//������������� �� ��������� < , << , >> ��������� �� ��������� , ��������� � ������ �� ����
ostream& operator<(ostream &cos, PersonsPossessions &pp);

ofstream& operator<< (ofstream &os, PersonsPossessions &pp);

ifstream& operator>> (ifstream &is, PersonsPossessions &pp);
#endif