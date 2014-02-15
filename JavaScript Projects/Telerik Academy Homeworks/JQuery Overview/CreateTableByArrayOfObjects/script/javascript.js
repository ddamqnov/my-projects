/**
 * Created by Damqnov on 14-2-13.
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


var Student = Class.create({

    init : function(fName,lName,grade){

        this.lName = lName;
        this.fName = fName;
        this.grade = grade;

    }

});


    var StudentDynamicTable = Class.create({

        init : function(studentsSet ){
            this.studentsSet = studentsSet;
            this.createTable();
            this.fillTheTable();
        },

        createTable : function(){

            var table = $('<table border="1px solid">' +
                '<tr>' +
                '<td><strong>First Name</strong></td>' +
                '<td><strong>Last Name</strong></td>' +
                '<td><strong>Grade</strong></td>' +
                '</tr>' +
                '</table>');

            table.attr("id","myTable");
            $('body').append(table);

        },

        addNewRow :  function(fName,lName,grade){
            var newRow = $('<tr>' +
                '<td>' + fName + '</td>' +
                '<td>' + lName + '</td>' +
                '<td>' + grade  + '</td>' +
                '</tr>');
            $('#myTable').append(newRow);
        },

        fillTheTable : function(){
            for(var i in this.studentsSet){
                this.addNewRow(this.studentsSet[i].fName,this.studentsSet[i].lName,this.studentsSet[i].grade);
            }
        }

    });



