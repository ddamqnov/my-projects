/**
 * Created by Damqnov on 14-2-11.
 */


var Class = (function(){

    function createClass (properties) {
        var theClass = function () {
            if(this._superConstructor){
                this._super = new this._superConstructor(arguments);
            }
            this.init.apply(this,arguments);
        }

        theClass.prototype = {};
        for(var props in properties){
            theClass.prototype[props] = properties[props];
        }

        if (!theClass.prototype.init) {
            theClass.prototype.init = function() {}
        }
        return theClass;
    }

    Function.prototype.inherit = function(parent) {
        var oldPrototype = this.prototype;
        this.prototype = new parent();
        this.prototype._superConstructor = parent;
        for (var prop in oldPrototype) {
            this.prototype[prop] = oldPrototype[prop];
        }
    }

    return {
        create : createClass
    };

}());


var Person = Class.create({
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

});


var Student = Class.create({

    init : function(fName,lName,age,grade){
        this._super.init(fName,lName,age);
        this.grade = grade;
    },

    toString : function(){
        return this._super.toString() + " Grade : " + this.grade;
    }
});

var Teacher = Class.create({

    init : function(fName,lName,age,speciality){
        this._super.init(fName,lName,age);
        this.speciality = speciality;
    },

    toString : function(){
        return this._super.toString() + " Speciality : " + this.speciality;
    }

});

Student.inherit(Person);
Teacher.inherit(Person);


//Classes have name, capacity of students, a set of students and a form-teacher (класен ръководител)


var SchoolClass = Class.create({

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

        if(formTeacher instanceof  Teacher){
            this.formTeacher = formTeacher;
        }
        else{
            throw new Error("Invalid input for variable form teacher !");
        }
    },

    addStudent : function(student){
        if(this.students.length < this.capacity && student instanceof Student){
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



});


// Each school have a name, town and classes of students

var School = Class.create({

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
        if(c != undefined && c instanceof SchoolClass){
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


});


window.onload = function(){


    var ivan = new Student("Ivan","Ivanov",21,6);
    var gosho = new Student("Gosho","Goshev",20,4);

    var array = [];
    array.push(ivan);
    array.push(gosho);

    var Sara = new Teacher("Sara","Gosheva",35,"English");
    var myClass = new SchoolClass("7B",20,array,Sara);

    console.log(array instanceof Student);
    myClass.printAllStudents();
    console.log(myClass.toString());

    var classes = [];
    classes.push = (myClass);

    var mySchool = new School("Kliment Ohridski","Yambol",classes);
    console.log(mySchool.toString());
    mySchool.showAllClasses();




}
