/**
 * Created by Damqnov on 14-4-7.
 */



//Adding advertisement
$("#add-ad-btn").on("click",function(){

    $("#mainArticle").load(ctx+"resources/ad-form.jsp",function(){

        var optionsHtml = "";
        $.getJSON('/get-categories',{
            ajax: true
        },function(data){

            var len = data.length;
            for(var i = 0 ; i < len ; i++){
                optionsHtml += '<option>' + data[i] + '</option>';
            }
            $("#ad-select-category").html(optionsHtml);
        });

        $("#add-ad-form").validate({
            rules: {
                "ad-title" : {
                    required: true,
                    minlength: 5,
                    maxlength: 15
                },
                "ad-category": {
                    required: true
                },
                "ad-content": {
                    required: true,
                    minlength: 10,
                    maxlength:100
                }
            },
            messages:{
                "ad-title" : {
                    required: "Моля въведете заглавие на обявата.",
                    minlength: "Залгавието трябва да е по-дълго от 5 символа.",
                    maxlength: "Залгавието трябва да е по-малко от 15 символа."
                },
                "ad-category": {
                    required: "Моля изберете категория."
                },
                "ad-content": {
                    required: "Моля въведете заглавие на обявата.",
                    minlength: "Описанието трябва да е по-дълго от 10 символа.",
                    maxlength: "Описанието трябва да е по-малко от 100 символа."
                }
            },
            highlight: function (element){
                $(element).parent().removeClass("has-success").addClass("has-error");
            },

            unhighlight : function(element){
                $(element).parent().removeClass("has-error").addClass("has-success");
            },
            submitHandler : function(){
                alert("submitted");

                var title = $("#ad-title-fld").val();
                var content = $("#ad-content-area").val().toString();
                var category = $("#ad-select-category").find(":selected").text().toString();

                console.log(title + content + category);

                $.ajax({
                    type: "POST",
                    url: "ad/save",
                    data: JSON.stringify({ title: title, content : content, category: category }),
                    contentType: 'application/json',
                    success: function(data){
                        alert(data);
                    }
                });

            },

            invalidHandler : function(){
                alert("not submitted");
            }

        });
    });
});

//Getting all advertisements
function getAds(data){

        var html = '';
        var len = data.length;
        html += '<div class = "row">';
        for(var i = 0 ; i < len ; i++){
            html +=     '<div class="col-sm-6 col-md-4">'+
                '<div class="thumbnail">'+
                '<h4 class="text-center">' + data[i][0] +  '</h4>' +
                '<img src = "/resources/resources/images/1.jpg" alt="300x200" width="200" height="300">'+
                '<div class = "caption">'+
                '<p><a href = "#" class = "btn btn-primary " role = "button">Покажи</a>'+
                '</div>'+
                '</div>'+
                '</div>'
        }
        html += '</div>'
        html += '<div class=" col-md-6 col-md-offset-4">'+
            '<ul class="pagination" >'+
            '<li><a href="#">&laquo;</a></li>'+
            '<li class="active"><a href="#">1</a></li>'+
            '<li><a href="#">2</a></li>'+
            '<li><a href="#">3</a></li>'+
            '<li><a href="#">4</a></li>'+
            '<li><a href="#">5</a></li>'+
            '<li><a href="#">&raquo;</a></li>'+
            '</ul>'+
            '</div>';
        $('#container').html(html);
}

function findAdsByCategory(categoryName){
    $.ajax({
        type: "POST",
        url: "ad/by+category",
        data: JSON.stringify({categoryName: categoryName}),
        contentType: 'application/json',
        success: function(data){
            $('#mainArticle').hide();
            getAds(data);
        }
    });
}
