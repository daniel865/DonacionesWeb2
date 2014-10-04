/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#FormJornada").bootstrapValidator({
        fields: {
            codigo: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            descripcion: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            fecha_programada: {
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
            direccion: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            donantes: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_a1: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_a2: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_b1: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_b2: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_ab1: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_ab2: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_o1: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
                    }
                }
            },
            sangre_o2: {
                validators: {
                    digits: {
                        message: "Números Únicamente"
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
        $('#FormJornada').bootstrapValidator('resetForm', true);
    });
});

$(document).ready(function () {
    $("#btnlimpiar").click(function () {
        $(':input', '#FormJornada')
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
    });
});
