/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
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
    $('#find').on('submit', function(e){
        var controlOut = hoursFormat($('[id$="Out"]').val());
        var controlIn = hoursFormat($('[id$="In"]').val());
        if (!controlOut || !controlIn){
            e = e || window.event;
            e.preventDefault();
        }
    });
    $('#reservation').on('submit', function(e){
        var name = emptyControl("Nombre", $('[id$="Name"]').val());
        var surname = emptyControl("Apellidos", $('[id$="Surname"]').val());
        var telephone = telephoneFormat("Teléfono", $('[id$="Telephone"]').val());
        var creditCard = creditCardFormat("Número de Tarjeta", $('[id$="CreditCardNumber"]').val());
        if (!name || !surname || !telephone || !creditCard){
            e = e || window.event;
            e.preventDefault();
        }
    });
});

function hoursFormat(hour){
    var pattern = /^((([01]?\d)|(2[0-3])):[0-5]\d)$/gi;
    if (hour.length !== 0 && !pattern.test(hour)){
        toastrAlert("error",  "<b>Error en la hora</b><br />Por favor, ponlo en el formato correcto HH:MM");
        return false;
    }
    return true;
}

function emptyControl(name, input){
    if (input.length === 0){
        toastrAlert("error",  "<b>Error en "+name+"</b><br />Por favor, todos los campos son obligatorios");
        return false;
    }
    return true;
}

function telephoneFormat(name, input){
    var pattern = /^\d{9}$/gi;
    if (!pattern.test(input)){
        toastrAlert("error",  "<b>Error en "+name+"</b><br />Por favor, el número de "+name+" tiene 9 cifras");
        return false;
    }
    return true;
}

function creditCardFormat(name, input){
    var pattern = /^\d{16}$/gi;
    if (!pattern.test(input)){
        toastrAlert("error",  "<b>Error en "+name+"</b><br />Por favor, el "+name+" tiene 16 cifras");
        return false;
    }
    return true;
}

function toastrAlert(type, message){
    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }

    Command: toastr[type](message);
}