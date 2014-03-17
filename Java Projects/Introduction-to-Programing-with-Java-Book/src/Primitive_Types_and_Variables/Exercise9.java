package Primitive_Types_and_Variables;

/**
 * Created by Damqnov on 14-3-17.
 */

// Фирма, занимаваща се с маркетинг, иска да пази запис с данни на
//нейните служители. Всеки запис трябва да има следната характе-
//        ристика – първо име, фамилия, възраст, пол (м или ж), ID номер и
//        уникален номер на служителя (27560000 до 27569999). Декларирайте
//        необходимите променливи, нужни за да се запази информацията за
//        един служител, като използвате подходящи типове данни и описателни
//        имена.



public class Exercise9 {

    enum sex {MALE,FEMALE};

    class Employee{

        int id;
        String firstName;
        String lastName;
        sex sex;

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Exercise9.sex getSex() {
            return sex;
        }

        public void setSex(Exercise9.sex sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", sex=" + sex +
                    '}';
        }
    }





}
