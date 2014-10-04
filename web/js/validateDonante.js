/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#FormDonante").bootstrapValidator({
        fields: {
            tipo_doc: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            nro_doc: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            nombres: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'Letras únicamente'
                    },
                    stringLength: {
                        min: 2,
                        max: 80,
                        message: "Los nombres deben estar entre 2 y 80 carácteres"
                    }
                }
            },
            primer_apellido: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'Letras únicamente'
                    },
                    stringLength: {
                        min: 2,
                        max: 40,
                        message: "El apellido debe tener entre 2 y 40 carácteres"
                    }
                }
            },
            segundo_apellido: {
                validators: {
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'Letras únicamente'
                    },
                    stringLength: {
                        min: 2,
                        max: 40,
                        message: "El apellido debe tener entre 2 y 40 carácteres"
                    }
                }
            },
            telefono: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    digits: {
                        message: "Números Únicamente"
                    },
                    stringLength: {
                        min: 7,
                        max: 10,
                        message: "Fotmato de teléfono inválido"
                    }
                }
            },
            direccion: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            departamento: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            municipio: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            genero: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            correo: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    emailAddress: {
                        message: 'Formato inválido'
                    }
                }
            },
            enfermedades: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            habitos: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }           
            },
            estado: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            }
        }
    });
});

$(document).ready(function (){
    $("#btnlimpiar").click(function (){
        $('#FormDonante').bootstrapValidator('resetForm', true);
    });
});

$(document).ready(function () {
    $("#btnlimpiar").click(function (){
        $(':input', '#FormDonante')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
    });
});
