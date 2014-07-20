/**
 * Created by Damqnov on 20.7.2014 г..
 */

function initMap(output){

    $('#map-canvas').addClass('green-border');

    var mapOptions = {
        zoom: 50,
        center: new google.maps.LatLng(output.location.latitude,output.location.longitude)
    };

    var map = new google.maps.Map(document.getElementById('map-canvas'),
        mapOptions);

    var marker = new google.maps.Marker({
        position :  new google.maps.LatLng(output.location.latitude,output.location.longitude),
        map: map,
        title: output.address
    });

}
