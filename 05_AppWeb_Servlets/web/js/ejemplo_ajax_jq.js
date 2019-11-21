$(document).ready(function () {

    // Evento click del botón
    $("#btn_peticion_ajax_jq").click(function () {

        // creamos la petición AJAX:
        $.ajax({
            "url": "./datosjson",
            "type": "GET",
            "success": function (respuestaJson) {
                $("#div_datos_json").html(
                        JSON.stringify(respuestaJson));
            },
            "error": function (jqXHR, textStatus, errorThrown) {
                console.error("No se ha podido obtener la info:");
                console.warn(jqXHR);
                console.warn(textStatus);
                console.warn(errorThrown);
            },
            statusCode: {
                404: function () {
                    alert("page not found");
                }
            }
        });

    });

    $("#btn_peticion_ajax_post").click(function () {

        let nombre = document.getElementById("nombre").value;
        let email = document.getElementById("email").value;
        if (nombre !== "" && nombre.length > 1 && "" !== email) {

            let expresionNombre = new RegExp("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
            let expresionEmail = /^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$/;

            if (!expresionNombre.test(nombre)) {
                alert("Primera letra mayúscula y mínimo una minúscula, apellido opcional");
            } else if (!expresionEmail.test(email)) {
                alert("Email incorrecto");
            } else {

                let datosUsuario = {
                    "nombre": nombre,
                    "email": email
                };

                $.post("./datosjson", datosUsuario, function (resp) {
                    $("#div_datos_json").html(JSON.stringify(resp));
                });
            }
        } else {
            alert("Los datos no son válidos");
        }
    });


});