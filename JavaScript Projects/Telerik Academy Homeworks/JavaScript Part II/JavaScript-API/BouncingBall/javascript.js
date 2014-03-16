/**
 * Created by Damqnov on 14-2-4.
 */

// ball properties
var Ball = function(){

 var ballRadius;
 var ballSpeedX;
 var ballSpeedY;
 var ballXCoordinate;
 var ballYCoordinate;
 var ballColor;

function setBallParams(r,speed,xCord,yCord,color){
    // must be added validation here
    ballRadius = r;
    ballSpeedX = speed;
    ballSpeedY = speed;
    ballXCoordinate = xCord;
    ballYCoordinate = yCord;
    ballColor = color;
}

    function getRadius(){
        return ballRadius;
    }

    function getSpeedX(){
        return ballSpeedX;
    }

    function getSpeedY(){
        return ballSpeedY;
    }

    function getXCoordinate(){
        return ballXCoordinate;
    }

    function getYCoordinate(){
        return ballXCoordinate;
    }

    function getColor(){
        return ballColor;
    }

    return{
        setBallParams : setBallParams,
        getCordX : getXCoordinate,
        getCordY : getYCoordinate,
        getSpeedY : getSpeedY,
        getSpeedX : getSpeedX,
        getRadius : getRadius,
        getColor : getColor
    };

}();



function createAndDrawCanvas(myBall){

    // Canvas parameters
    var canvas;
    var context;
    var canvasWidth=1000;
    var canvasHeight=500;


    // Temporary ball parameters

    var ball = myBall
    var tempX = ball.getCordX();
    var tempY = ball.getCordY();
    var r = ball.getRadius();
    var speedX = ball.getSpeedX();
    var speedY = ball.getSpeedY();


    window.onload = createCanvas();

    function createCanvas(){
        var c = document.createElement("canvas");
        c.id="canvas-frame";
        c.width=canvasWidth;
        c.height=canvasHeight;
        c.style.border = "3px solid";
        c.borderColor= "#0094ff";
        document.body.appendChild(c);
        load("canvas-frame");

    }


function load(canvasID){
    canvas = document.getElementById(canvasID);
    context = canvas.getContext("2d");

    setTimeout(drawFrame(),24);
}


function drawFrame(){
    context.clearRect(0,0,canvas.width,canvas.height);
    drawBall();
    move();
    setTimeout(drawFrame, 24);

}

    function drawBall(){

        context.beginPath();
        context.fillStyle = ball.getColor() ;
        context.arc(tempX,tempY,r,0,2*Math.PI,true);
        context.fill();
        context.closePath();

    }

    function move(){


        tempX += speedX;
        tempY += speedY;

        if ((tempX + r > canvas.width) || (tempX - r < 0)) {
            speedX = -speedX;
        }

        if ((tempY + r > canvas.height) || (tempY - r < 0)) {
            speedY = -speedY;
        }
    }


    function stopTheBall(){
       speedX=0;
       speedY=0;
    }

    function startTheBall(){
        speedX=ball.getSpeedX();
        speedY=ball.getSpeedY();
    }

    return {
        stopTheBall : stopTheBall,
        startTheBall : startTheBall
    };

}




