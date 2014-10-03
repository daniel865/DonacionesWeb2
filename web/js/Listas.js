/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getList(type, callback, id) {
    $.ajax({
        url: 'http://localhost:8080/DonacionesREST/rest/lists/depend',
        type: 'GET',
        dataType: 'json',
        async: true,
        data: {type: type, id: id},
        success: function (data, textStatus, jqXHR) {
            callback(data);
        },
        error: function (xhr, options, error) {
            alert('Error: ' + error);
        }
    })
}
;