/**
 * Created by Damqnov on 14-2-12.
 */


if (!Object.prototype.extend) {
    Object.prototype.extend = function(properties) {
        function f() {};
        f.prototype = Object.create(this);
        for (var prop in properties) {
            f.prototype[prop] = properties[prop];
        }
        f.prototype._super = this;
        return new f();
    }
}


var Person = {
    // Init is the constructor of the class
    init : function(fName,lName,age){
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    },

    toString : function(){
        return "First name: " + this.fName + " Last name: " + this.lName + " Age : " + this.age ;
    },

    introduce : function(){
        console.log(this.toString());
    }

};

var Student = Person.extend({

    init : function(fName,lName,age,grade){
        Person.init.apply(this,arguments);
        this.grade = grade;
    },

    toString : function(){
        return Person.toString.apply(this) + " Grade : " + this.grade;
    }

});


var Teacher = Person.extend({

    init : function(fName,lName,age,speciality){
        Person.init.apply(this,arguments);
        this.speciality = speciality;
    },

    toString : function(){
        return Person.toString.apply(this) + " Speciality : " + this.speciality;
    }

});


var SchoolClass = {

    init : function(name,capacity,students,formTeacher){

        this.name;
        this.capacity;
        this.students = [];

        if( typeof name == 'string' && name.length < 30){
            this.name = name;
        }
        else{
            throw new Error("Invalid argument input for variable name!");
        }

        if(typeof capacity ==  'number' && capacity < 32 && capacity > 0){
            this.capacity = capacity;
        }

        else{
            throw new Error("Capacity must be positive number ! ");
        }


        for(var i = 0 , len = students.length ; i < len ; i++ ){
            this.addStudent(students[i]);
        }


        this.formTeacher = formTeacher;

    },

    addStudent : function(student){
        if(this.students.length < this.capacity ){
            this.students.push(student);
        }
        else{
            throw new Error("Invalid input of object student !");
        }
    },

    printAllStudents : function(){
        var i=0;
        var len;
        for(i, len = this.students.length ; i < len ; i++ ){
            console.log(this.students[i].introduce());
        }
    },


    toString : function(){
        return "Class name : " + this.name + " capacity: " + this.capacity
            + " Form-teacher: " + this.formTeacher.toString() ;
    }



};

var School = {

    init : function(name,townName,classes){
        this.name;
        this.townName;
        this.classes = [];

        if( typeof name == 'string' && name.length < 30){
            this.name = name;
        }
        else{
            throw new Error("Invalid argument input for variable name!");
        }

        if( typeof townName == 'string' && townName.length < 30){
            this.townName = townName;
        }
        else{
            throw new Error("Invalid argument input for variable townName!");
        }

        for(var i = 0 , len = classes.length ; i < len ; i++ ){
            this.addClass(classes[i]);
        }


    },

    toString : function(){
        return "School name : " + this.name + " Town: " + this.townName ;
    },

    addClass : function(c){
        if(c != undefined){
            this.classes.push(c);
        }
        else{
            throw new Error("Invalid input of object SchoolClass !");
        }
    },

    showAllClasses : function(){
        for(var c in this.classes ){
            console.log(this.classes[c].toString());
        }
    }

};


window.onload = function(){

    var mitko = Object.create(Person);
    mitko.init("Dimityr","Ivanov",21);
    mitko.introduce();

    var sasho = Object.create(Student);
    sasho.init("Sasho","Snegorina",23,6);
    sasho.introduce();


    var poncho = Object.create(Teacher);
    poncho.init("Poncho","Ponichkata",43,"Chemistry");
    poncho.introduce();

    var array = [];
    array.push(mitko);
    array.push(sasho);

    var myClass = Object.create(SchoolClass);
    myClass.init("12Z",30,array,poncho);
    console.log(myClass.toString());

    //...


}