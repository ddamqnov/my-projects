/**
 * Created by Damqnov on 14-2-4.
 */



var TrashGame = function(){

    var trashCount = 2;
    var tempId;
    var myTimer = Timer;
    var trashPic = "../img/trash.jpg";
    var binFullPic = "../img/full.jpg";
    var binEmptyPic =  "../img/empty.png"

    function createTrashContainer(){
        var trashContainer = document.createElement("div");
        trashContainer.style.position="absolute";
        trashContainer.style.left="100px";
        trashContainer.style.top="100px";
        trashContainer.style.height="400px";
        trashContainer.style.width="1000px";
        trashContainer.id="trash-container";
        document.body.appendChild(trashContainer);
    }

    function prepareToStart(){
        if(confirm("Are u ready to play ? ? ?")){
            generateAllImg();
            myTimer.startTimer();
        }

        else{
            alert("Refresh the page when u wanna start the game !");
        }
    }

    function finished(){

        alert("You finished the game !");
        myTimer.stopTimer();
        alert("Your time is : " + myTimer.getResultTime()/1000 + "seconds");
        var name = prompt("Enter your name :");
        savePlayerResult(myTimer.getResultTime()/1000,name);
        showTopFive();


    }




    function generateAllImg(){
        var recBin = document.createElement("img");
        recBin.addEventListener('drop',drop,false);
        recBin.addEventListener('dragover',allowDrop,false);
        recBin.id = "recycle-bin";
        recBin.style.height = "100 px";
        recBin.style.width = "100px";
        recBin.src = binEmptyPic;
        document.body.appendChild(recBin);

        createTrashContainer();


        var temp;
        for(var i = 0; i < trashCount ; i++){
            temp = generateRandomImg();
            if(temp != null){
                temp.id=i;
                document.getElementById("trash-container").appendChild(temp);
            }
            else{
                throw new Error("The generated picture is null!");
            }
        }
    }

    function allowDrop(e){
        e.preventDefault();
    }

    function handleDragStart(e){
        tempId=this.id;
    }


    function drop(e){
        e.preventDefault();
        e.target.src = binFullPic;
        document.getElementById("trash-container").removeChild(document.getElementById(tempId));
        trashCount--;

        var timeout = window.setTimeout(function(){
            e.target.src = binEmptyPic;
        },1200);


        if(trashCount == 0){
            window.clearTimeout(timeout);
            finished();
        }
    }

    function generateRandomNumber(db,ub){
        return Math.floor(Math.random()*ub)+db;
    }

    function generateRandomImg(){
        var pic = document.createElement("img");
        pic.src = trashPic;
        pic['draggable'] = true;
        pic.addEventListener('dragstart',handleDragStart,false);
        pic.style.width = 80+"px";
        pic.style.height = 80+"px";
        pic.style.position = "absolute";
        pic.style.top=generateRandomNumber(100,200) + "px";
        pic.style.left=generateRandomNumber(100,900) + "px";
        return pic;
    }

    function savePlayerResult(r,name){
        var result = {
            "name" : name,
            "result" : r
        }

        var array=[];

        if(window.localStorage.getItem("TrashGame") != null){
            array =  JSON.parse(window.localStorage.getItem("TrashGame"));
        }
        array.push(result);
        window.localStorage.setItem("TrashGame",JSON.stringify(array));


    }

    function showTopFive(){
        var array = JSON.parse(window.localStorage.getItem("TrashGame"));

        array.sort(function(a,b){
            return a.result - b.result;
        });

        var tempString="";
        for(var i = 0 ; i < 5 ; i++){
            tempString += " " + i +" " + array[i].name +  " " + array[i].result + " ";
        }

        alert(tempString);
    }

    window.onload = prepareToStart();

}();
