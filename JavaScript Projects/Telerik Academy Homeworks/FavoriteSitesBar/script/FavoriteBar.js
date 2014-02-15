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

var URL = Class.create({

    init : function(title,url){
        this.title = title;
        this.url = url;
    },

    createLiElement : function(){
        var a = document.createElement('a');
        var li = document.createElement("li");
        var linkText = document.createTextNode(this.title);
        a.appendChild(linkText);
        a.href = this.url;
        a.target = '_blank' ;
        li.appendChild(a);
        return li;
    }

});

var URLFolder  = Class.create({

    init : function(title,urlSet){
        this.title = title ;
        this.urlSet = urlSet;
    },

    createDiv : function(){
        var firstClick = true;
        var div = document.createElement("div");
        div.innerText = this.title;
        console.log(this.urlSet);
        var ul = document.createElement("ul");
        var uSet= this.urlSet;
        div.appendChild(ul);


        div.addEventListener("click",function(){
            if(firstClick == true){
                for(var i in uSet){
                    ul.appendChild(uSet[i].createLiElement());
                }

                firstClick = false;
            }
            else{

                if(firstClick == false){
                    while(ul.firstChild){
                        ul.removeChild(ul.firstChild);
                    }

                    firstClick = true;
                }
            }






        },false);

        return div;
    }

});

window.onload  = function(){

    var myURL = new URL("Google!","http://google.com");
    var urlSet = [];
    urlSet.push(myURL);
    urlSet.push(myURL);
    urlSet.push(myURL);
    urlSet.push(myURL);
    urlSet.push(myURL);


    var myFolder = new URLFolder("My Folder",urlSet);
    var myFolder2 = new URLFolder("My Folder 2 ",urlSet);
    var myFolder3 = new URLFolder("My Folder 3 ",urlSet);

     document.body.appendChild(myFolder.createDiv());
    document.body.appendChild(myFolder2.createDiv());
    document.body.appendChild(myFolder3.createDiv());
//    document.body.appendChild(myURL.createAElement());

}