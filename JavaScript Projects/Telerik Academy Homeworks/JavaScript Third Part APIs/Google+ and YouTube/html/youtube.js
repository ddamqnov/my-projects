

var ControlPanel = Class.create({
    initialize : function(selector,youtubeInstance){
        this.container = $('#'+selector);
        this.player = youtubeInstance;
    },


    addAllButtons : function(){
        this.pause();
        this.stop();
        this.next();
        this.previous();
        this.mute();
        this.unmute();
        this.setVolume();
        this.loadById();
        this.loadPLaylist();

    },

    createButton : function(text,f){
        var button = $('<button></button>');
        button.text(text);
        this.container.append(button);
        return button;
    },

    createField : function(){

        var field = $('<input>').attr('type','text');
        this.container.append(field);
        return field;

    },

    createRangeInput : function(){

        var input = $('<input>')
            .attr('type','range')
            .attr('value',50)
            .attr('min',0)
            .attr('max',100)
            .attr('step',1);

        this.container.append(input);
        return input;

    },

    pause : function(){
        var self = this;
        this.createButton("Pause").on('click',function(){
            self.player.pauseVideo();
        });

    },

    stop : function(){
        var self = this;
        this.createButton("Stop").on('click',function(){
            self.player.stopVideo();
        });

    },


    loadById : function(){
         var self = this;
         var field =   this.createField().attr('placeholder','Enter Id');
         var button = this.createButton('Load Video');
         button.on('click',function(){
             self.player.loadVideoById(field.val(),0,'large');
             self.player.playVideo();
         });
    },



    loadPLaylist : function(){
        var self = this;
        var field =   this.createField().attr('placeholder',"Enter All ID's").attr('size',50);
        var button = this.createButton('Load Playlist');

        button.on('click',function(){
            var videos =  field.val().split(',');
            self.player.cuePlaylist(videos, 0, 0, "large");
            self.player.loadVideoById(videos,0,0,'large');

        });

    },

    next : function(){
        var self = this;
        this.createButton("Next").on('click',function(){
            self.player.nextVideo();
        });
    },


    previous : function(){
        var self = this;
        this.createButton("Previous").on('click',function(){
            self.player.previousVideo();
        });
    },



    mute : function(){
        var self = this;
        this.createButton("Mute").on('click',function(){
            self.player.mute();
        });
    },


    unmute : function(){
        var self = this;
        this.createButton("Unmute").on('click',function(){
            self.player.unMute();
        });
    },


    setVolume : function(){
       var range = this.createRangeInput();
        range.on('change',function(){
            self.player.setVolume(this.value);
        });
    }

});



