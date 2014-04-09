//Класа PersonsPosseions наследява Person
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include "PersonsPossessions.h"

// toString() метод - връща стойностите на всички променливи
string PersonsPossessions::toString(){   
	std::stringstream ss;
	ss << "Persons name: " << Person::getName()<< endl << "Address: " << Person::getAddress() << endl << "EGN:" <<			Person::getEgn()      <<endl<<"Properties: "<<endl;

	for(int i = 0;i < 5;i++){
		if(addr[i] != "null"){
			ss << addr[i] << endl;
		}
		else ss << endl;
	}
	return ss.str();
}


















