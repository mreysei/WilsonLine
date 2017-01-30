/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('.price').val($('#price').val() + ' €');
    $('#price').on('change', function(){
        var $value = $(this).val();
        $('.price').val($value+' €');
    });
});