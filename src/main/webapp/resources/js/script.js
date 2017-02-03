/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
<<<<<<< HEAD
    //$('.price').val($('#price').val());
    //$('#price').mousemove(updatePrice);
    //$('#price').bind('touchmove',updatePrice);
=======
    $('.price').val($('#price').val());
    $('#price').mousemove(updatePrice);
    $('#price').bind('touchmove',updatePrice);
>>>>>>> refs/remotes/origin/master
    $('#language').on('click', function(){
        if ($(this).hasClass('active')){
            $(this).find('ul').slideUp(); 
            $(this).removeAttr('class');
        } else {
            $(this).find('ul').slideDown(); 
            $(this).attr('class', 'active');
        }
    });
    setInterval(function(){
        if (screen.availWidth > 700){
            $('#left').find('form').slideDown();
        }
    }, 100);
    $('#left').on('click', 'h1', function(){
        if (screen.availWidth <= 700){
            var $parent = $(this).closest('#left');
            $parent.find('form').slideToggle();
            if($parent.hasClass('active')){
                $parent.removeAttr('class');
            } else {
                $parent.attr('class', 'active');
            }
        }
    });
});

function updatePrice() {
    var $value = $(this).val();
    $('.price').val($value);
}