//Предифиниране на символите < , << , >> съответно за извеждане , записване и четене от файл
#include <iostream>
#include <fstream>
#include "PredefinedOperators.h"

ostream& operator<(ostream &cos, PersonsPossessions &pp){
	cos<<pp.toString();
	return cos;
}

ofstream& operator<< (ofstream &os, PersonsPossessions &pp){
	os <<pp.getName() << endl << pp.getAddress() << endl << pp.getEgn() << endl << pp.addr[0] << endl << pp.addr[1]	 << endl <<pp.addr[2]<<endl << pp.addr[3] << endl << pp.addr[4] << endl;
	return os;
}


ifstream& operator>> (ifstream &is, PersonsPossessions &pp){   

	string name;
	string egn;
	string address;
	string property[5];

	getline(is,name);
	getline(is,address);
	getline(is,egn);

	for(int i = 0;i < 5;i++){
		getline(is,property[i]);
	}
	pp.setAddresses(property);
	pp.setName(name);
	pp.setAddress(address);
	pp.setEgn(egn);
	return is;
}

