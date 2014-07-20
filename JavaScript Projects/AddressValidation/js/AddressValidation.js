/**
 * Created by Damqnov on 19.7.2014 г..
 */


function generateAddressObject(){
    var address = '';
    var country = $('#country-select').val();
    var city = $('#city-txt').val();
    if($('#type-select').val() == "Street"){
        var street = $('#street-txt').val();
        var number = $('#number-txt').val();
        address = country + " " + city + " " + street + " " + number;
    }
    else{
        if($('#type-select').val() == "District"){
            var district = $('#district-txt').val();
            var building = $('#building-txt').val();
            var entrance = $('#entrance-txt').val();
            var number = $('#number-txt').val();
                address = country + " " + city + " " +  district + " " + building  ;
        }
    }
    console.log(address);
    return address;
}

function loadTypes(){
    var types = ['District','Street'];
    var options = '<option selected="selected">Type</option>';
    for(var i = 0 ; i < types.length ;i++){
        options += '<option value="' + types[i] + '">' + types[i] + '</option>';
    }
    $('#type-select').html(options);
}


function loadCountries() {
    var len = countries.length;
    var options = '<option value="Bulgaria" selected="selected">Bulgaria</option>';
    for(var i = 0 ;i < len; i++){
        options += '<option value="' + countries[i].name + '">'+ countries[i].name + '</option>';
    }
    $('#country-select').html(options);
}


var type = $('#type-select');
var typeCnt = $('#type-cnt');

type.on('change',function(){
    typeCnt.empty();
    switch (type.val()){
        case "Street" : generateStreetForm(); break;
        case "District" : generateDistrictForm(); break;
    }
})


//Searching for geolocation with Google Maps Geocoding API

function GetLocation(address) {
    $('#output-cnt').empty();
    $('#map-canvas').empty();
    var output = "";
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({ 'address': address }, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            output = generateOutputObject(results);
            console.log(output);
            generateOutputView(output);
            initMap(output);
        }
        else {
            console.log('fail!');
            alert("Request failed.")
        }
    });

};



//Generating


function generateOutputView(output){
    var html = '<div class="col-md-6" id="result">' +
        '<h3 class="text-success">Address:</h3>' +
        '<h4>Formatted Address: <strong class="text-success">' +  output.address + '</strong></h4>' +
        '<h4>Post Code: <strong class="text-success">' +  output.postCode + '</strong></h4>' +
        '<hr>' +
            '<h3 class="text-success">Location: </h3>' +
                '<p><h4>Latitude: <strong class="text-success">' + output.location.latitude + '</strong></h4></p>' +
                '<p></p><h4>Longitude: <strong class="text-success">' +  output.location.longitude + '</strong></h4></p>' +
        '</div>';

    $('#output-cnt').html(html);
}


function generateOutputObject(result){
    var postCode = 'undefined';
    if(result[0].address_components.length == 6){
        postCode =   result[0].address_components[5].long_name;
    }
    else{
        postCode =   result[0].address_components[6].long_name;
    }

console.log(result);
    var obj = {
        "address" : result[0].formatted_address,
        "postCode" :  postCode,
        "location" : {
            "latitude" : result[0].geometry.location.lat(),
            "longitude" : result[0].geometry.location.lng()
        }
    }
    return obj;
}

function generateStreetForm(){

    var html = '<div class="form-group">' +
        '<label for="street-txt" class="col-sm-3 control-label">Street:</label>' +
        '<div class="col-md-8">' +
        '    <input type="text" class="form-control" id="street-txt" name="street" placeholder="Street">' +
        '    </div>' +
        ' </div>' +
        '<div class="form-group">' +
        '    <label for="number-txt" class="col-sm-3 control-label">Number: </label>' +
        '    <div class="col-md-8">' +
        '        <input type="text" class="form-control" id="number-txt" name="number" placeholder="Number">' +
        '     </div>' +
        '</div>';

    $('#type-cnt').html(html);

}


function generateDistrictForm(){

    var html = '<div class="form-group">' +
        '<label for="district-txt" class="col-sm-3 control-label">District:</label>' +
        '<div class="col-md-8">' +
        '    <input type="text" class="form-control" id="district-txt" name="district" placeholder="District">' +
        '    </div>' +
        ' </div>' +
        '<div class="form-group">' +
        '<label for="building-txt" class="col-sm-3 control-label">Building:</label>' +
        '<div class="col-md-8">' +
        '    <input type="text" class="form-control"  id="building-txt" name="building" placeholder="Building">' +
        '    </div>' +
        ' </div>' +
        '<div class="form-group">' +
        '<label for="entrance-txt" class="col-sm-3 control-label">Entrance:</label>' +
        '<div class="col-md-8">' +
        '    <input type="text" class="form-control" id="entrance-txt" name="entrance" placeholder="Entrance">' +
        '    </div>' +
        ' </div>' +
        '<div class="form-group">' +
        '    <label for="number-txt" class="col-sm-3 control-label">Number: </label>' +
        '    <div class="col-md-8">' +
        '        <input type="text" class="form-control" id="number-txt" name="number" placeholder="Number">' +
        '     </div>' +
        '</div>';

    $('#type-cnt').html(html);
}


