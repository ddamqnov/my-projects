#include <iostream>
#include <string>
#include "Person.h"

using namespace std;


	Person::Person(string n,string adr,string e){ // Конструктор за попълване на данните 
		name = n;
		address = adr;
		egn = e;
	} 



	string Person::toString(){  // Връща информацията за един човек
		std::stringstream ss;
		ss << "Persons name: " << name << endl <<"Address: "<< address<<endl<< "EGN:" << egn << endl;
		return ss.str();
	}

	Person::~Person(){ // Деструктор на класа Person
	}


