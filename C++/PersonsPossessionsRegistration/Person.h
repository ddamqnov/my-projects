#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
using namespace std;
#ifndef Person_H
#define Person_H

class Person  {
private:		
	string name;     // ���
	string address;  //�����
	string egn;      // ���

public:
	Person(string n,string adr,string e);

	virtual string toString();
	// Get and Set ������

	string getName(){return name;}
	string getAddress(){return address;}
	string getEgn(){return egn;}

	void setName(string n){
		name=n;
	}

	void setAddress(string d){
		address=d;
	}

	void setEgn(string e){
		egn=e;
	}

	~Person();

};

#endif