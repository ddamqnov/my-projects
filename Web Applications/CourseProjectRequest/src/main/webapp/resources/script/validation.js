/**
 * Created by Damqnov on 14-4-16.
 */

$(document).ready(function(){

    isLogged();

    jQuery.validator.addMethod("exactlength", function(value, element, param) {
        return this.optional(element) || value.length == param;
    }, jQuery.format("Please enter exactly {0} characters."));


    jQuery.validator.addMethod("notEqual", function(value, element, param) {
        return this.optional(element) || value != param;
    }, "Please choose a value!");


    //Login form validation script

    $("#login-form").validate({

        lang: 'en',

        rules : {
            "username" : {
                required : true,
                number: true,
                exactlength: 9
            },

            "password" : {
                required : true,
                minlength: 5
            }
        },

        submitHandler : function(){
            var userName = $('#username').val();
            var userPassword = $('#password').val();

            $.post( "j_spring_security_check", { j_username: userName, j_password: userPassword },function(data){
                if(data == ""){
                    isLogged();
                }else{
                    $('#errors-div').html("<strong>Невалиден фак.номер или парола !</strong>");
                }
            });
        },
        invalidHandler : function(){
            alert("not submitted");

        },

        errorPlacement : function(error,element){
            error.appendTo($("#errors-div"));
        },

        messages : {
            "username" : {
                required : "Моля, въведете факултетен номер.",
                exactlength: "Факултетния номер съдържа 9 цифри.",
                number: "Факултения номер съдържа само цифри."
            },
            "password" :{
                required : "Моля, въведете вашата парола.",
                minlength: "Вашата парола трябва да е по-голяма от 5 символа."
            }
        }

    });




});

function generateUserMenu(name){
    $('#login-form').empty().html(

        '<div class="col-md-offset-6">'+
            '<a href="#"  class="btn btn-default"><span class="glyphicon glyphicon-user"></span>'+ name +'</a>'+
            '   <a href="j_spring_security_logout" class="btn btn-default"><span class="glyphicon glyphicon-log-out">' +
                '</span>  Излез</a>' +
            '</div>'

    );
}

function generateSelectionMenu(){



    $.getJSON('/project/existing',function(data){

        var courseWorkName = "Няма избрана";
        var courseProjectName = "Няма избран";
        var CWbtnName = "Избери";
        var CPbtnName = "Избери";

        if(data[0] != 'null'){
            courseWorkName = data[0];
            CWbtnName = 'Промени';
        }

        if(data[1] != 'null'){
            courseProjectName = data[1];
            CPbtnName = 'Промени';
        }

        var html = '<div class="buffer-top col-md-5 " >' +
            '   <div id="course-project-info">' +
            '   <div id="choose-cnt">' +
            '       <div class="row">' +
            '                   <div class="col-md-7">' +
            '                   <strong>Курсова проект</strong> : ' + courseProjectName +
            '               </div>' +
            '               <div  class="col-md-1">' +
            '                   <input type="button"  class="btn btn-success" value="'+ CPbtnName + '" id="cp-btn"/>' +
            '               </div>' +
            '           </div>' +
            '           <div class="row buffer-top">' +
            '               <div class="col-md-7">' +
            '                   <strong>Курсова работа</strong> :' + courseWorkName +
            '               </div>' +
            '               <div  class="col-md-1">' +
            '                   <input type="button"  class="btn btn-success" value="' + CWbtnName + '" id="cw-btn"/>' +
            '               </div>' +
            '           </div>' +
            '           <div id="select-project"></div>'+
            '       </div>' +
            '   </div>' +
            '   </div>';
        $('#section').html(html);


        $('#cp-btn').on('click',function(){

            subjectSelection("project");
        });

        $('#cw-btn').on('click',function(){
            subjectSelection("work");
        });

    });


}

function isLogged(){
    $.getJSON('/login/user',{
        ajax:true
    },function(data){
        if(data != ""){
            console.log(data);
            var name = data;
            addUserMenu(name);
        }
    });
}

function addUserMenu (name){
    generateUserMenu(name);
    generateSelectionMenu();
}


function subjectSelection(type){
    $('#select-project').empty();
    var name;
    if(type == 'work'){
        name = 'Курсова работа:';
    }
    else{
        if(type == 'project'){
            name = 'Курсов проект:';
        }
    }

    var html = '<hr>'+

        '<form id="course-project-form">'+
        '    <h4>' + name + '</h4>'+
        '   <div class="row">'+
        '       <div class="col-md-5">'+
        '           <p> 1. Най-висок приоритет'+
        '           </div>'+
        '           <div class=" col-md-2">'+
        '               <select id="first" name="first">'+
        '               </select>'+
        '           </p>'+
        '       </div>'+
        '       </div>'+
        '   <div class="row">'+
        '       <div class="col-md-5">'+
        '           <p> 2. Среден приоритет'+
        '           </div>'+
        '           <div class=" col-md-2">'+
        '               <select id="second" name="second">' +
        '               </select>'+
        '           </p>'+
        '       </div>'+
        '       </div>'+
        '       </div>'+
        '   <div class="row">'+
        '       <div class="col-md-5">'+
        '           <p> 3.Най-нисък приоритет'+
        '           </div>'+
        '           <div class=" col-md-4">'+
        '               <select id="third" name="third">'+
        '               </select>'+
        '           </p>'+
        '       </div>'+
        '       </div>'+
        '       </div>'+
        '   <div class="row">'+
        '       <div class="col-md-2">'+
        '           <input type="submit" class="btn btn-success" value="Потвърди">'+
        '           </div>'+
        '       </div>'+
        '       </div>' +
        '       <div id="subjectErrDiv"></div>'+
        '    </form>';
    $('#select-project').html(html);


    $.getJSON('/' + type + '/all',function(data){
        var html = '';
        var len = data.length;
        for(var i = 0 ; i < len ; i++){
            html += '<option>'+ data[i] +'</option>'
        }
        $('#first').html(html);
        $('#second').html(html);
        $('#third').html(html);

        $.validator.addMethod("notEqualSubjects", function(value, element) {
            return $('#first').val() != $('#second').val() && $('#second').val() != $('#third').val()
                &&  $('#first').val() != $('#third').val()
        }, "Трябва да изберете различни предмети.");

        $('#course-project-form').validate({
            rules :{
                first : {
                    notEqualSubjects : true
                },
                second : {
                    notEqualSubjects : true
                },
                third : {
                    notEqualSubjects : true
                }
            },
            errorPlacement : function(error,element){
                error.appendTo($("#subjectErrDiv"));
            },
            submitHandler : function(){
                $.ajax({
                    type: "POST",
                    url: "project/course" + type + "/save",
                    data: JSON.stringify({ first: $('#first').val(), second : $('#second').val(), third: $('#third').val() }),
                    contentType: 'application/json',
                    success: function(data){
                        location.reload();
                    }
                });
            }
        });

    });
}