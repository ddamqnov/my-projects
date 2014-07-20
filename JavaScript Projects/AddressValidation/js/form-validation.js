/**
 * Created by Damqnov on 19.7.2014 г..
 */

jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-z\s\u0400-\u04FF]+$/i.test(value);
}, "Letters only please");


jQuery.validator.addMethod("notEqual", function(value, element, param) {
    return this.optional(element) || value != param;
}, "Please choose a value!");


$(document).ready(function(){

    loadCountries();
    loadTypes();

    $('#address-form').validate({
        rules : {
            "country" : {
                required : true,
                minlength: 2,
                maxlength: 15,
                lettersonly: true
            },
            "city" : {
                required : true,
                minlength: 2,
                maxlength: 15,
                lettersonly: true
            },
            "type" : {
                notEqual: "Type"
            },
            "district" : {
                required:true,
                minlength: 2,
                maxlength: 15,
                lettersonly: true
            },
            "building" : {
                required : true,
                minlength: 1,
                maxlength: 10,
                number: true
            },
            "entrance" : {
                minlength: 1,
                maxlength: 3,
                lettersonly: true
            },
            "street" : {
                required : true,
                minlength: 2,
                maxlength: 15,
                lettersonly: true
            },
            "number" : {
                required : true,
                minlength: 1,
                maxlength: 10,
                number: true
            }

        },
            submitHandler: function(form) {
                alert("successfully submitted");
                //calling the main function right
                var address = generateAddressObject();
                GetLocation(address);
            },
            invalidHandler : function(){
                alert("not submitted");

            }
    });
});


