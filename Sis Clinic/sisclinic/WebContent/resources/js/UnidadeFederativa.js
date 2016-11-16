$(document).ready(function () {  
    $('#tabela').empty(); //Limpando a tabela  
    $.ajax({  
        type: 'POST', //Definimos o método HTTP usado  
        dataType: 'json', //Definimos o tipo de retorno  
        url: '/washcarprime/UnidadeFederativaServlet', //Definindo o arquivo onde serão buscados os dados  
        success: function (dados) {  
            for (var i = 0; i <  1; i++) {  
            	 for (var j = 0; j <  dados.length ; j++) {  
                     //Adicionando registros retornados na tabela  
                     $('#tabela').append('<tr><td>' + dados[i][j]["id"] + '</td><td>' + dados[i][j].nome + '</td><td>' + dados[i][j].sigla + '</td></tr>'); 
                 } 
            }  
        }  
    });  
});  
