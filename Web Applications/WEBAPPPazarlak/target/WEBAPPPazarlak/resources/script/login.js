/**
 * Created by Damqnov on 14-4-7.
 */

$(document).ready(function(){

    isLogged();

    //Login form validation script

    $("#login-form").validate({

        lang: 'en',

        rules : {
            "email" : {
                required : true,
                email : true
            },

            "password" : {
                required : true,
                minlength: 5
            }
        },

        submitHandler : function(){

            var userName = $('#login-email').val();
            var userPassword = $('#login-password').val();

            $.post( "j_spring_security_check", { j_username: userName, j_password: userPassword },function(data){
                if(data == ""){
                   isLogged();

                }else{
                    $('#errorsDiv').addClass('alert alert-danger').html("Невалидно име или парола !");
                }
            });
        },
        invalidHandler : function(){
            alert("not submitted");
        },

        errorPlacement : function(error,element){
            error.appendTo($("#errorsDiv"));
        },

        messages : {
            "еmail" : {
                required : "Моля, въведете имейл адрес."
            },
            "password" :{
                required : "Моля, въведете вашата парола.",
                minlength: "Вашата парола трябва да е по-голяма от 5 символа."
            }
        }

    });

});




function addUserMenu(mail,numberOfAds){
    $("#nav-login").hide();
    $("#main-nav-container").removeClass('col-md-2 col-md-offset-5').addClass('col-md-5 col-md-offset-3');
    $("#nav-login").parent().html(
        '<nav>'+
            '<ul class="nav  nav-pills">'+
            '<li>'+
            '<a href="#"><span class="glyphicon glyphicon-user"></span> ' + mail + '</a>'+
            '</li>'+
            '<li>'+
            '   <a href="#"><span class="glyphicon glyphicon-envelope"></span> Съобщения' +
            '       <span class="badge">0</span>' +
            '   </a>' +
            '   </li>' +
            '   <li>' +
            '       <a href="#"><span class="glyphicon glyphicon-bullhorn"></span>  Обяви' +
            '           <span class="badge">' + numberOfAds + '</span>' +
            '       </a>' +
            '   </li>' +
            '   <li>' +
            '   <a href="/j_spring_security_logout"><span class="glyphicon glyphicon-log-out"></span>  Излез</a>' +
            '</li>' +
            '</ul>' +
            '</nav>'
    );
}

function isLogged(){
    $.getJSON('/login/user/information',{
        ajax:true
    },function(data){
        if(data != ""){
            console.log(data);
            var mail = data.mail;
            var numberOfAds = data.numberOfAds;
            addUserMenu(mail,numberOfAds);
        }
    });
}

$('#login-email').focus(function(){
    $('#errorsDiv').removeClass('alert alert-danger').html("");
});