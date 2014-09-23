/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#departamento").change(function (event) {
        var departamento = $("select#departamento").val();
        console.log(departamento);
        $.get('JornadaServlet', {
            departments: departamento
        }, function (response) {
            console.log(response);
            //Código para agregar opciones al select
            var select = $('#municipio');
            select.find('option').remove();
            $.each(response, function (index, value) {
                $('<option>').val(value).text(value).appendTo(select);
            });
        });
    });
});
