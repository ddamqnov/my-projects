

var html = '';

$(document).ready(function(){

    html =
        '<option selected >Специалност</option>';

    $.getJSON('/speciality/all/name',function(data){
        console.log(data);
        var len = data.length;
        for(var i = 0 ; i < len ; i++){
            html += '<option>' + data[i] + '</option>'
        }

        var speciality = $('#get-spec-field');
        speciality.html(html);

        speciality.on('change',function(){

            html = '';
            html =
                '<option selected >Курс</option>' +
                    '<option>1</option>' +
                    '<option>2</option>' +
                    '<option>3</option>' +
                    '<option>4</option>';

            var course = $('#get-course-field');
            course.html(html);
            course.focus();


            course.on('change',function(){

                $.ajax({
                    type: "POST",
                    url: "subject/name/speciality+course",
                    data: JSON.stringify({ speciality: speciality.val(), course : course.val() }),
                    contentType: 'application/json',
                    success: function(data){

                        html = '';
                        html = '<option selected >Предмет</option>';
                        var len = data.length;
                        for(var i = 0 ; i < len ; i++){
                            html +=  '<option>' + data[i] + '</option>';
                        }

                        var subject = $('#get-subject-field');
                        subject.html(html);
                        html = "";

                        subject.focus();

                        subject.on('change',function(){
                            html = "";

                            $.ajax({
                                type: "POST",
                                url: "subject/type",
                                data: JSON.stringify({ name: subject.val()}),
                                contentType: 'application/json',
                                success: function(data){
                                    var len =  data.length;
                                    for(var i = 0 ; i < len ; i++){
                                        html += '<option>' + data[i] + '</option>';
                                    }

                                    var type = $('#get-type-field');
                                    type.html(html);
                                    type.focus();

                                    html = '';
                                    html =   '<input type="submit" class="btn btn-success" value="Покажи">';
                                    $('#submit-btn').html(html);



                                    jQuery.validator.addMethod("notEqual", function(value, element, param) {
                                        return this.optional(element) || value != param;
                                    }, "Моля изберете опция!");


                                    $('#main-nav').validate({
                                        rules : {
                                            "get-subject-field" : {
                                                required : true,
                                                notEqual : "Предмет"
                                            },
                                            "get-spec-field" : {
                                                required: true,
                                                notEqual: "Факултет"
                                            },
                                            "get-course-field" : {
                                                required: true,
                                                notEqual: "Курс"
                                            },
                                            "get-type-field" : {
                                                required: true
                                            }
                                        },

                                        submitHandler: function(){
                                            alert('success!');

                                            var courseWork = false;
                                            var courseProject = false;

                                            if(type.val() == 'Всички'){
                                                courseProject = true;
                                                courseWork = true;
                                            }
                                            else{
                                                if(type.val() == "Курсова работа"){
                                                    courseWork = true;
                                                }
                                                else{
                                                    if(type.val() == "Курсова проект"){
                                                        courseProject = true;
                                                    }
                                                }

                                            }


                                            $.ajax({
                                                type: "POST",
                                                url: "subject/students/all",
                                                data: JSON.stringify({ name : subject.val() , courseProject : courseProject,
                                                    courseWork : courseWork}),
                                                contentType: 'application/json',
                                                success: function(data){
                                                    console.log(data);
                                                }
                                            });
                                        }

                                    });
                                }
                            });
                       });

                    }
                });
            });

        });
    });
});