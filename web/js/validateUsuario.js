/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#FormUsuario").bootstrapValidator({
        fields: {
            nro_identificacion: {
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
            apellido1: {
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
            apellido2: {
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
            usuario: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    }
                }
            },
            pass: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    identical: {
                        field: 'pass2',
                        message: 'El campo no coincide'
                    }
                }
            },
            pass2: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    identical: {
                        field: 'pass',
                        message: 'El campo no coincide'
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
            user_perfil: {
                validators: {
                    notEmpty: {
                        message: "El campo no puede estar vacío"
                    },
                    stringLength: {
                        min: 2,
                        max: 20,
                        message: "El nombre de usuario debe tener entre 2 y 20 carácteres"
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