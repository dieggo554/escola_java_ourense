// jQuery(...) se abrevia como $(...)
jQuery(document).ready(function () {

    jQuery("section").append("<div><p>LEYENDA DE LO QUE SEA</p></div>");
    $(".articulo").append("<p>UN PARRAFO EN CADA ELEM con class = 'articulo'</p>");

    $("tr").append("<td>Info</td>");    // Añadir quinta col
    // tr.setAttribute("style", "background-color: red");
    $("td:nth-child(5)").attr("style", "background-color: red; color: white");
    $("td:nth-child(5)").click(() => {
        alert('un click desde jQ');
    });
    $("#otro_menu").html("<h2>Menú de artículos</h2>");

    /* Mi forma
    
        $("article").each(function (index) {
            let idArticulo = "articulo_29juR_" + index;
            $(this).attr("id", idArticulo);
            $("#otro_menu")
            .append("<a href='#" + idArticulo + "' class='enlace-articulo'>Articulo nº " + index + "</a>");
        });
        
        $("article").slideUp("fast");
    
        $("#otro_menu a").click(function () {
            let idObjetivo = $(this).attr("href");
            $(idObjetivo).siblings().hide();
            $(idObjetivo).slideDown();
        }); 
        */

    var articuloActivo;
    $("article").each(function (index) {
        let idArticulo = "articulo_29juR_" + index;
        $(this).slideUp();
        $(this).attr("id", idArticulo);
        $("#otro_menu")
            .append("<a id='enlace_" + idArticulo
                + "' href='#" + idArticulo
                + "' class='enlace-articulo'>Articulo nº "
                + index + "</a>");
        $("#enlace_" + idArticulo).click(function () {
            if (typeof (articuloActivo) === "undefined") { // La primera vez
                $("#" + idArticulo).slideDown(1500);
            } else {
                $(articuloActivo).slideUp(800, function () {
                    $("#" + articuloActivo).slideDown(1500);
                });
            }
            articuloActivo = $("#" + idArticulo);
        })
    });

    // $("#otro_menu").click(function() {
    //     // $("#otro_menu").fadeOut();
    //     $(this).slideUp();
    // });

    // Evento hover()
});
