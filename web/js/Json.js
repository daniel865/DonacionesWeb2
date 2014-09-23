$(document).ready(function () {
    $('#departamento').change(function (event) {
        $.ajax({
        type: "GET",
                url: "JornadaServlet",
                success: function (responseJson) {
                    //alert and success handler
                    alert('entro success');
                },
                dataType: 'json',
                error : function () {
                    // error handler
                    alert('entro error');
                }});
            
                /*$.get('JornadaServlet', {
                 value: sports
                 }, function(jsonResponse) {
                 alert('entro');
                 var select = $('#municipio');
                 select.find('option').remove();
                 $.each(jsonResponse, function(key, value) {
                 $('<option>').val(key).text(value).appendTo(select);
                 });
                 },
                 'json'
                 ); */

    });
});


