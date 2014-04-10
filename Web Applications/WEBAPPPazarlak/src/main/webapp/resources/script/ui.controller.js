/**
 * Created by Damqnov on 14-4-7.
 */


//
////Adding popovers to the aside bar anchors
//$(function(){
//    $('#asideNav').children().popover();
//});


// Showing the Terms  and Conditions  blank
$('#myModal').modal({
    keyboard: false
})

//Generate dynamically  all ad categories
$(document).ready(function(){
    $.getJSON('/get-categories',{
        ajax: true
    },
    function(data){
        var html = '<a href="#" class="list-group-item active" id="all-ads-anchor">' +
                    'Всички обяви</a>';
        var len = data.length;
        for(var i = 0 ; i < len ; i++){
            html += '<a href="#" class="list-group-item " >' + data[i] + '</a>';
        }
        $('#asideNav').html(html);


// This function adds event listeners to all aside bar anchors
        var asideBarChilds =  $("#asideNav").children();
        asideBarChilds.on("click",function(){
            for(var i = 0, len = asideBarChilds.length;i < len ;i++){
                $(asideBarChilds[i]).removeClass('active');
            }
            $(this).addClass("active")
            findAdsByCategory($(this).text());
        });

    });
});



