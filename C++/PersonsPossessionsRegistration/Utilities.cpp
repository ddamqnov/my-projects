using namespace std;
#include <fstream>
#include <iostream>
#include <string>
#include "Utilities.h"


void viewPersons(){
	bool found = false;
	ifstream is("personslist.txt");
	PersonsPossessions pp;
	while(!is.eof()){
		is >> pp;
		for(int i = 0;i < 5;i++){
			if(pp.getAddress() == pp.addr[i] && pp.getAddress() != ""){  
				cout << pp.toString();
				found = true;
				break;
			}
		}
	}
	if(found == false){
		cout << "No results found !" << endl << endl << endl;
	}
}

void findByEgn(){
	bool found = false;
	string egn;
	cout << "Enter egn:" <<endl;
	cin >> egn;
	cout << endl;
	ifstream is("personslist.txt");
	PersonsPossessions pp;
	while(!is.eof()){
		is >> pp;
		if(pp.getEgn() == egn){
			cout << pp.toString();
			found = true;
			break;
		}
	}
	if(found == false){
		cout << "No results found!"<< endl << endl << endl;
	}

}


void viewAll(){

	ifstream is("personslist.txt");
	PersonsPossessions pp;
	while(!is.eof()){
		is >> pp;
		if(pp.getName() != "")
			cout << pp.toString();
	}

}

void addNewPerson(){

	string temp;
	string name;
	string egn;
	string address;
	string properties[5];
	for(int i = 0;i < 5;i++){
		properties[i] = "null";
	}
	int nProperty;
	getline(cin,temp);
	cout << "Enter name: " << endl;
	getline(cin,name);
	cout << "Enter address:" << endl;
	getline(cin,address);
	cout << "Enter egn: "<< endl;
	getline(cin,egn);
	cout << "Enter the number of propperties:"<<endl;
	cin >> nProperty;
	getline(cin,temp);
	for(int i = 0;i < nProperty;i++){
		cout << "Enter address" << (i+1) <<endl;
		getline(cin,properties[i]);
	}

	PersonsPossessions pp(name,address,egn,properties);

	ofstream os("personslist.txt",ios::app);

	os << pp;
}