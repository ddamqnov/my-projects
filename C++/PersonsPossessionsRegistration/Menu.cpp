 // ���� ���� 
#include "Menu.h"

	void menu::showMenuDialog(){
		cout<<"#####################################################"<<endl;
		cout<<"#                                                   #"<<endl;
		cout<<"# 1. Add new person.                                #"<<endl;
		cout<<"# 2. View all                                       #"<<endl;
		cout<<"# 3. Search person by EGN.                          #"<<endl;
		cout<<"# 4. View persons living in their property.         #"<<endl;
		cout<<"# 5. Exit                                           #"<<endl;
		cout<<"#####################################################"<<endl;
	}


	void menu::getUserChoice(){
		while(true){
			int choice;
			showMenuDialog();
			cout<<"Enter number:"<<endl;
			cin>>choice;
			switch(choice){
			case 1:  addNewPerson();// �������� �� ��� �����
				break;  
			case 2:  viewAll();  // ����������� �� ������ ������
				break;		 
			case 3:  findByEgn(); // ������� �� ����� �� ���
				break;		 
			case 4:  viewPersons();  //	�������� �� ���� ������� � ����� ������ 
				 break;
			case 5:  exit(1); break; //�������� �� ���������
			}
			getUserChoice();
		}

	}



 