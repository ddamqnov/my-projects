/**
 * Created by Damqnov on 14-4-7.
 */

$("#regButton").on("click", function() {

    $("#mainArticle").load(ctx+"resources/form.jsp", function () {

        //Registration form validation script

        $("#reg-form").validate({
            rules : {
                "reg-email" : {
                    required : true,
                    email : true
                },
                "reg-password" : {
                    required: true,
                    minlength: 5
                },
                "confirm-reg-password" : {
                    required: true,
                    minlength: 5,
                    equalTo :  "#reg-password"
                },
                "terms-checkbox" : {
                    required: true
                }
            },

            errorPlacement : function(error,element){
                $("#" + $(element).attr("name") + "-err").append(error);

            },

            highlight: function (element){
                $(element).parent().removeClass("has-success").addClass("has-error");
            },

            unhighlight : function(element){
                $(element).parent().removeClass("has-error").addClass("has-success");
            },

            submitHandler : function(){

                var email = $("#reg-email").val();
                var password = CryptoJS.SHA1($("#reg-password").val()).toString();

                $.ajax({
                    type: "POST",
                    url: "register",
                    data: JSON.stringify({ email: email, password : password  }),
                    contentType: 'application/json',
                    success: function(bool) {
                        var html = '';
                        if(bool == true){
                            html += '<div class="alert alert-success top-buffer">Регистрирахте се успешно !</div>';
                        }else{
                            if(bool == false){
                                html +=  '<div class="alert alert-danger top-buffer">Потребителското име е заето</div>';
                            }
                        }
                        var id = '#confirm-reg-password-err' ;
                        while(id.firstChild != null){
                            id.removeChild(id.firstChild);
                        }
                        $(id).html(html);

                    }
                });
            },

            invalidHandler : function(){
                alert("not submitted");
            },

            messages: {
                "reg-email" : {
                    required: "Моля, въведете имейл адрес.",
                    email : "Моля, въведете валиден имейл адрес."
                },
                "reg-password" : {
                    required: "Моля, въведете вашата парола.",
                    minlength: "Вашата парола трябва да е по дълга от 5 символа."
                },
                "confirm-reg-password" : {
                    required: "Моля, въведете вашата парола.",
                    minlength: "Вашата парола трябва да е по дълга от 5 символа.",
                    equalTo: "Двете пароли , трябва да съвпадат."
                },
                "terms-checkbox" : {
                    required: "Трябва да сте съгласни с нашите условия."
                }
            }

        });
    } );

});