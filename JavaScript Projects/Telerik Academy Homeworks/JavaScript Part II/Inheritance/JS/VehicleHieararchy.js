/**
 * Created by Damqnov on 14-2-2.
 */

var vehicleNS=function(){

var Land_Vehicle_Wheels=4;

var AfterBurnerType = {
    "ON" : "ON",
    "OFF" : "OFF"
};

var SpinDirection = {
    "CLOCKWISE" : "CLOCKWISE",
    "COUNTERCLOCKWISE" : "COUNTERCLOCKWISE"
};


Function.prototype.inherit = function(parent){
    this.prototype = new parent();
    this.prototype.constructor = parent;
}

Function.prototype.extend=function(parent){
    for(var i = 0; i < arguments.length; i++){
        var property = arguments[i];
        this.prototype[property] = parent.prototype[property];
    }
}

var PropulsionUnit=function(){

}

PropulsionUnit.prototype.getAcceleration= function(){
    throw new Error("Cannot get acceleration without specifying the propulsion unit type!");
}


var Wheel = function(r){
    if(arguments.length!=1)
    {
        throw new Error("The number of arguments is invalid!");
    }

    if(r<=0){
        throw new Error("Wheel radius must be positive !");
    }
    this.radius = r;

}

Wheel.inherit(PropulsionUnit);


Wheel.prototype.getAcceleration=function(){
        return 2*Math.PI*this.radius;
}



var PropellerNozzles = function(powerInHP,afterBurnerState){

    if(arguments.length != 2){
        throw new Error("The number of arguments is invalid!");
    }

    if(powerInHP < 0){
        throw new Error ("Power must be positive number!");
    }

    if(afterBurnerState != AfterBurnerType.ON && afterBurnerState != AfterBurnerType.OFF){
        throw new Error("Invalid after burner type , it must be ON or OFF");
    }

    this.power = powerInHP;
    this.AfterBurner = afterBurnerState;

}

PropellerNozzles.inherit(PropulsionUnit);

PropellerNozzles.prototype.getAcceleration=function(){
    var acceleration;
    if(this.AfterBurner == AfterBurnerType.OFF){
        acceleration = this.power;
    }
    else{
        acceleration = this.power*2;
    }

    return acceleration;
}



var Propeller = function(finsNumber,spinDirection){

    if(arguments.length != 2){
        throw new Error("The number of arguments is invalid!");
    }

    if(finsNumber < 0){
        throw new Error ("Fins number must be positive number!");
    }

    if(spinDirection != SpinDirection.CLOCKWISE && spinDirection != SpinDirection.COUNTERCLOCKWISE){
        throw new Error ("Invalid argument spin direction!");
    }

    this.fins = finsNumber;
    this.direction = spinDirection;


}

Propeller.inherit(PropulsionUnit);

Propeller.prototype.getAcceleration=function(){
    var acceleration = this.fins;
    if(this.direction.CLOCKWISE = SpinDirection.CLOCKWISE){
        return acceleration;
    }
    else{
        return -1*acceleration;
    }

}


var Vehicle = function(speedInKmH,propulsionUnit){

    if(typeof propulsionUnit != typeof propulsionUnit){
        throw new Error("Invalid argument propulsion unit!");
    }
        this.unit=propulsionUnit;
        this.speed=speedInKmH;
}


Vehicle.prototype.accelerate=function(){
    var unitLength= this.unit.length;
    for( var i = 0; i < unitLength; i++ ){
        this.speed += this.unit[i].getAcceleration();
    }
}


var LandVehicle = function(speedInKmH,wheels){
    if(wheels.length != Land_Vehicle_Wheels){
        throw new Error ("Invalid number of wheels !");
    }

    Vehicle.call(this,speedInKmH,wheels);
}

LandVehicle.inherit(Vehicle);


    return {
        Vehicle : Vehicle,
        Wheel : Wheel,
        LandVehicle : LandVehicle
    };


}();