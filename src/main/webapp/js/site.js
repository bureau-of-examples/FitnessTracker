

$(function(){

    /*handle panel-accordion*/
    $(".panel-accordion").each(function(index, element){
        var panel = $(element);
        panel.addClass("panel-collapse");
        panel.find(".panel-heading")
            .addClass("cursor-pointer")
            .click(function(){
                panel.toggleClass("panel-collapse");
            }
        );
    });



});



