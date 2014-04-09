//����� PersonsPosseions ��������� Person
using namespace std;
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include "Person.h"
#ifndef PersonPossessions_H
#define PersonPossessions_H
const int POSSESSIONS= 5;


class PersonsPossessions :  public Person {      
public:

	string addr[5];

	PersonsPossessions(string n="null",string adr="null",string e="null",string adArray[POSSESSIONS]=NULL) : Person(n,adr,e){
		if (adArray){

			for(int i = 0; i < POSSESSIONS; i++) {
				addr[i] = adArray[i];
			}
		}
	}

	void setAddresses(string adr[5]){
		for(int i=0;i<5;i++){
			addr[i]=adr[i];
		}
	}

	// toString() ����� - ����� ����������� �� ������ ����������
	string toString();

	// ���������� ������� �� ���������-������ �� ���� � ��������� �� ����������
	friend ofstream& operator<< (ofstream &os, PersonsPossessions  &pp);
	friend ifstream& operator>> (ifstream &is, PersonsPossessions  &pp);
	friend ostream& operator<(ostream &cos, PersonsPossessions &pp);

};

#endif