/**
 * Created by Damqnov on 14-5-16.
 */

var Game = {
    //constructor
    init : function(gameSize,container){
        this.array = [];
        this.ROWS_COUNT = gameSize;
        this.FIRST_P_NUMBER = 1;
        this.SECOND_P_NUMBER = 2;
        this.CONTAINER = container;
        this.firstPlayer = true;
    },
    createNewGame : function(){
        this.array = [];
        var gameBoard = Object.create(GameBoard);
        gameBoard.init(this.ROWS_COUNT,this.FIRST_P_NUMBER,this.SECOND_P_NUMBER,this.CONTAINER);
        gameBoard.clear();
        gameBoard.generate();
        this.addListeners();

    },
    addListeners : function(){
        var self = this;

        $('.play-cell').on('click',function(e){
            var element =  $('#'+ e.target.id);
            var elementId = e.target.id;
            var elementValue = self.array[elementId];

            if(elementValue == undefined){
                if(self.firstPlayer == true){
                    self.array[elementId] = self.FIRST_P_NUMBER;
                    element.addClass('selected-f');
                    if(self.checkForWinner(self.FIRST_P_NUMBER)){
                        alert("First player wins !");
                    }
                    self.firstPlayer = false;
                }
                else{
                    self.array[elementId] = self.SECOND_P_NUMBER;
                    element.addClass('selected-s');

                    if(self.checkForWinner(self.SECOND_P_NUMBER)){
                        alert("Second player wins !");
                    }
                    self.firstPlayer = true;
                }
            }
            else{
                alert("Already clicked!");
            }
        });

    }, checkAllRows : function (P_NUMBER){
        var c = 0;
        for(var i = 0 ; i < this.ROWS_COUNT ; i++){
            if(this.checkRow(c,this.ROWS_COUNT,P_NUMBER)){
                return true;
            }
            else{
                c += this.ROWS_COUNT;
            }
        }
        return false;
    },
    checkRow : function(start ,rowLength , value){
        var r = 0;
        var v = value;
        var i = start;
        var end = start + rowLength;
        for( ; i < end ; i++){
            if(this.array[i] != value){
                return false;
            }
            else{
                r++;
            }
        }
        if(r == rowLength){
            return true
        }
        else{
            return false;
        }
    },
    checkColumn : function (_start,value){
        var r = 0 ;
        var start = _start;
        for(var i = 0 ; i < this.ROWS_COUNT  ; i++){
            if(this.array[start] != value){
                return false;
            }
            else{
                r++;
            }
            start += this.ROWS_COUNT;
        }
        if(r == this.ROWS_COUNT){
            return true;
        }
        else{
            return false;
        }
    },
    checkAllColumns : function (P_NUMBER){
        for(var i = 0 ; i < this.ROWS_COUNT ; i++){
            if(this.checkColumn(i,P_NUMBER)){
                return true;
            }
        }
        return false;
    },
    checkDiagonal : function (_start,num,value){
        var r = 0
        var start = _start;

        for(var i = 0 ; i < this.ROWS_COUNT ; i++){
            if(this.array[start] != value){
                return false;
            }
            else{
                r++;
            }
            start += num;
        }
        if(r == this.ROWS_COUNT){
            return true;
        }
        else{
            return false;
        }
    },


    checkDiagonals : function (P_NUMBER){

        if(this.checkDiagonal(0,this.ROWS_COUNT+1,P_NUMBER) || this.checkDiagonal(this.ROWS_COUNT-1,this.ROWS_COUNT-1,P_NUMBER)){
            return true;
        }
        else{
            return false;
        }
    },

    checkForWinner : function (P_NUMBER){
        if(this.checkAllRows(P_NUMBER) || this.checkAllColumns(P_NUMBER) || this.checkDiagonals(P_NUMBER)){
            return true;
        }
        else{
            return false;
        }
    }
}

var GameBoard = {
    //constructor
    init : function(ROWS_COUNT,FIRST_P_NUMBER,SECOND_P_NUMBER,CONTAINER){
        this.ROWS_COUNT = ROWS_COUNT;
        this.FIRST_P_NUMBER = FIRST_P_NUMBER;
        this.SECOND_P_NUMBER = SECOND_P_NUMBER;
        this.CONTAINER = CONTAINER;
    },
    generate : function(){
        this.html = '';
        this.id = 0;
        this.end = this.ROWS_COUNT;
        for(var j = 0 ; j < this.ROWS_COUNT ; j++){
            this.html += '<div class="row">'
            for(var i = this.id ; i < this.end; i++){
                this.html += '<div id="'+ i + '" class = "col-md-1 play-cell"> </div>';
            }
            this.html += '</div>';
            this.id += this.ROWS_COUNT;
            this.end = this.id + this.ROWS_COUNT;
        }
        $('#' + this.CONTAINER).append(this.html);
    },
    clear : function (){
        $('#' + this.CONTAINER).html('');
    }
}

$(document).ready( function(){
    var myGame = Object.create(Game);
    myGame.init(3,'main-cnt');
    myGame.createNewGame();
});



