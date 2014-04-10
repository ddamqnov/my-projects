<html>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/resources/script/jquery-2.1.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/jquery.validate.js" ></script>
<script src="${pageContext.request.contextPath}/resources/script/bootstrap.js"></script>

<body>
<h1>${message}</h1>


<div id="ads"></div>
<script>
    $(document).ready(function() {
        $.getJSON('/mitko',{
            ajax:true
        },function(data){
            var html = '';
            var len = data.length;
            for(var i = 0 ; i < len ; i++){
                html += '<div class = "row">';
                html +=     '<div class="col-sm-6 col-md-2">'+
                        '<div class="thumbnail">'+
                        '<h4 class="text-center">' + data[i][0] +  '</h4>' +

                        '<img src="${pageContext.request.contextPath}/resources/resources/images/3.jpg" alt="300x200" width="100" height="200">'+
                        '<div class="caption">'+
                        ' <p><a href="#" class="btn btn-primary " role="button">Покажи</a>'+
                        '</div>'+
                        '</div>'+
                        '</div>'
            }
            html += '</div>'
            $('#ads').html(html);
        });
    });



</script>
</body>
</html>