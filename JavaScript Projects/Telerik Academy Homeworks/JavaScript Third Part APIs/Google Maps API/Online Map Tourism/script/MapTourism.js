/**
 * Created by Damqnov on 14-2-21.
 */


var Capital = Class.create({
    initialize: function(name,x,y,info){
        this.name = name;
        this.xCord = x;
        this.yCord = y;
        this.info = info;
    }
});

var CapitalMap = Class.create({
    initialize : function (capitals){
        this.capitals = capitals;
        this.map;
        this.count = 0;
        this.marker;
        this.infowindow;




    },

    createMap : function(xCord,yCord,info){

        var self = this;

        function initialize() {
            var mapOptions = {
                zoom: 10,
                center: new google.maps.LatLng(xCord,yCord)

            };

            self.map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);

            self.infowindow = new google.maps.InfoWindow({
                content: self.capitals[0].info
            });

            self.marker = new google.maps.Marker({
                position :  new google.maps.LatLng(self.capitals[0].xCord, self.capitals[0].yCord),
                map: self.map,
                title: self.capitals[0].name
            });

            google.maps.event.addListener(self.marker, 'click', function() {
                self.infowindow.open(self.map,self.marker);
            });

        }
        google.maps.event.addDomListener(window, 'load', initialize);
    },

    initMap : function(){
        this.createMap(this.capitals[0].xCord,this.capitals[0].yCord,this.capitals[0].info);
        this.createButtonPrev();
        this.createButtonNext();
    },

    createButtonNext : function(){
        var self = this;
        var nextBtn = document.createElement('button');
        nextBtn.innerHTML = 'Next!';
        nextBtn.addEventListener('click',function(){
            if(self.count < self.capitals.length -1 ){
                self.count++;
                var latLng = new google.maps.LatLng(self.capitals[self.count].xCord, self.capitals[self.count].yCord);
                self.map.panTo(latLng);
                self.infowindow.setContent(self.capitals[self.count].info);
                self.marker.setPosition(latLng);
                self.map.setZoom(10);
            }


        },false);
        document.body.appendChild(nextBtn);
    },

    createButtonPrev : function(){
        var self = this;
        var prevBtn = document.createElement('button');
        prevBtn.innerHTML = 'Prev!';
        prevBtn.addEventListener('click',function(){
            if(self.count != 0){
                self.count--;
                var latLng = new google.maps.LatLng(self.capitals[self.count].xCord, self.capitals[self.count].yCord);
                self.map.panTo(latLng);
                self.infowindow.setContent(self.capitals[self.count].info);
                self.marker.setPosition(latLng);
            }
        },false);
        document.body.appendChild(prevBtn);
    }


});



