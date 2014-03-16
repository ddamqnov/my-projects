/**
 * Created by Damqnov on 14-2-4.
 */


var Timer = function(){
    var startTime;
    var stopTime;
    var date;

    function startTimer(){
        date= new Date();
        startTime= date.getTime();
        console.log(startTime);
    }

    function stopTimer(){
        date= new Date();
        stopTime = date.getTime();
        console.log(stopTime);
    }

    function getResultTime(){
        console.log(stopTime - startTime);
        return stopTime - startTime;
    }

    return {
        startTimer : startTimer,
        stopTimer  : stopTimer,
        getResultTime : getResultTime
    };

}();