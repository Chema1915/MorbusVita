
function validar(Contacto){
    
    if(Contacto.nombre.value.length < 5){
        alert("Escribe mas de 5 caracteres en el campo nombre");
        Contacto.nombre.focus();
    return false;
    }
    if(Contacto.celular.value.length!= 10){
        alert("El numero tiene que ser de 10 digitos incluyendo el 55");
        Contacto.celular.focus();
        return false;
    }
    if(Contacto.correo.value.length== 0){
        alert("Llene el Campo de Correo");
        Contacto.correo.focus();
        return false;
    }


    var checkOK = "QWERTYUIOPASDFGHJKLÑZXCVBNM"
    + "qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = Contacto.nombre.value;

    var allvalid = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++)
        if(ch == checkOK.charAt(j))
            break;
        if(j == checkOK.length){
            allvalid = false;
            break;
        }
    }

    if(!allvalid){
        alert("Escribe solo letras en el campo nombre");
        Contacto.nombre.focus();
        return false;
    }



    var checkOK = "1234567890-";

    var checkStr = Contacto.celular.value;

    var allvalid = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++)
        if(ch == checkOK.charAt(j))
            break;
        if(j == checkOK.length){
            allvalid = false;
            break;
        }
    }

    if(!allvalid){
        alert("Escribe solo numeros en el campo celular");
        Contacto.celular.focus();
        return false;
    }


    var txt = Contacto.correo.value;

   
    var b = /^[^@\s]+@[^@\.\s]+(\.[^@\.\s]+)+$/;

    alert("correo " + (b.test(txt)?"":" no ")+" valido");

    return b.test(txt);}
