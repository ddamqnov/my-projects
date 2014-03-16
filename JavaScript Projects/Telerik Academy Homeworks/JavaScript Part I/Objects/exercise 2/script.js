/**
 * Created by Damqnov on 14-2-24.
 */




Array.prototype.removeItemsByValue =  function(value){
    for(var i = 0 ; i < this.length ; i++){

        if(this[i] == value ){
            this.splice(i,1);
        }

    }

    return this;

}


var a = [1,2,3,4,1,2,"1",5,1];
console.log(a.removeItemsByValue(1));
