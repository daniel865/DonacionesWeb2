/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#FormBolsas").bootstrapValidator({
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
            cod_jornada: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            grupo_sanguineo: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            rh: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            recoleccion: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            vencimiento: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            cantidad: {
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
