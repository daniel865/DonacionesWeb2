$(document).ready(function() {
    $('#departamento').change(function(event) {
        var sports = $("select#departamento").val();
        $.get('JornadaServlet', {
            value: sports
        }, function(jsonResponse) {
            var select = $('#municipio');
            select.find('option').remove();
            $.each(jsonResponse, function(key, value) {
                $('<option>').val(key).text(value).appendTo(select);
            });
        });
    });
});


