/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    /*$('#departamento').click(function() { 
        var opciones={
            url:"",
            cache:"false",
            contentType:"application/json",
            type:"POST"
        };
        $.ajax(opciones).done(function(data){
            
        }).fail(function(){
            
        });
            */
     
  // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
        $.get('JornadaServlet', function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
            var option=createElement("<option>Prueba</option>");
            var municipios=document.getELementById("municipio");
            console.log(municipios);
            console.log(option);
            municipios.appendChild(option);
            
        });
    
});
