$(document).ready(function() {
    $('#FormJornada').validate_popover({
        rules: {
            codigo: {
                digits: true,
                required: true
            },
            fecha_programada: {
                required: true,
                date: true
            },
            departamento: {
                required: true
            },
            municipio: {
                required: true
            },
            direccion: {
                required: true
            },
            donantes: {
                required: true,
                digits: true
            },
            sangre_a1: {
                digits: true
            },
            sangre_a2: {
                digits: true
            },
            sangre_ab1: {
                digits: true
            },
            sangre_ab2: {
                digits: true
            },
            sangre_b1: {
                digits: true
            },
            sangre_b2: {
                digits: true
            },
            sangre_o1: {
                digits: true
            },
            sangre_o2: {
                digits: true
            },
            estado: {
                required: true
            }
        },
        messages: {
            codigo: {
                digits: "Por favor, Ingrese solamente números",
                required: "Campo Obligatorio"
            },
            fecha_programada: {
                required: "Campo Obligatorio",
                date: "Formato de Fecho Incorrecto"
            },
            departamento: {
                required: "Campo Obligatorio"
            },
            municipio: {
                required: "Campo Obligatorio"
            },
            direccion: {
                required: "Campo Obligatorio"
            },
            donantes: {
                required: "Campo Obligatorio",
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_a1: {
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_a2: {
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_ab1: {
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_ab2: {
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_b1: {
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_b2: {
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_o1: {
                digits: "Por favor, Ingrese solamente números"
            },
            sangre_o2: {
                digits: "Por favor, Ingrese solamente números"
            },
            estado: {
                required: "Campo Obligatorio"
            }
        },
        highlight: function(element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            //$(element).closest('.ocultar').removeClass('success').addClass('glyphicon glyphicon-ok form-control-feedback');
        },
        success: function(element) {
            element
                    .text('OK!').addClass('valid')
                    .closest('.form-group').removeClass('has-error').addClass('has-success');
            //.closest('.ocultar').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('has-success');
        }
    });

}); // end document.ready