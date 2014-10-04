/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#FormHospital").bootstrapValidator({
        fields: {
            tipo: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            nit: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            razon: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
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
            representante: {
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
            tel_representante: {
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
            correo_representante: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    emailAddress: {
                        message: 'Formato inválido'
                    }
                }
            },
            nivel: {
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
        $('#FormHospital').bootstrapValidator('resetForm', true);
    });
});

$(document).ready(function () {
    $("#btnlimpiar").click(function () {
        $(':input', '#FormHospital')
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
    });
});