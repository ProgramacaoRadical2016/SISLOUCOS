jQuery(document).ready(
  function()
  {
    /*
     * Chamamos aqui a função que vai controlar os campos.
     * Desta forma, caso você precise repetir o combo dinâmico
     * basta trocar os ID's dos SELECT's
     */
    comboDinamico("estado", "cidade", "bairro");
    // suposição de segundo bloco de selects
    // comboDinamico("estado_cliente", "cidade_cliente", "bairro_cliente", "bairro_cliente");
  }
);

  /*
   * função para carregar uma lista dinâmica
   */
  comboDinamico = function(estado, cidade, bairro) {
    /*
     * Variáveis que precisamos pegar
     * Usamos getElementById() pois é assim que conseguiremos
     * passar o elemento por variável para jQuery
     */
    var estado   = document.getElementById(estado);
    var cidade = document.getElementById(cidade);
    var bairro = document.getElementById(bairro); 
    /*
     * Carregamos a lista automaticamente quando a página carrega
     */
    $(estado).load('http://192.168.0.12:81/app-sisclinic/enderecamento.php?tipo=estado');

    /*
     * Populamos o combo dos cidades quando trocamos um valor no estado
     * Os próximos blocos serão similares quanto à validação pelo valor igual à zero
     */

    $(estado).change(
    function() {
      if($(this).val() == 0) {
        alert('Você precisa informar um Estado!');
        $(this).focus();
      } else {
        $(cidade).load('http://192.168.0.12:81/app-sisclinic/enderecamento.php?tipo=cidade&amp;estado=' + $(this).val());
      }
    }
  );

    /*
     * Populamos o combo das bairros quando trocamos um valor no cidade
     */

    $(cidade).change(
    function() {
      if($(this).val() == 0) {
        alert('Você precisa informar o ESTADO!');
        $(this).focus();
      } else {
        $(bairro).load('http://192.168.0.12:81/app-sisclinic/enderecamento.php?tipo=bairro&amp;cidade=' + $(this).val());
      }
    }
  );

    /*
     * Populamos o combo dos bairros quando trocamos um valor na bairro
     */
    $(bairro).change(
    function() {
      if($(this).val() == 0) {
        alert('Você precisa informar a CIDADE!');
        $(this).focus();
      } else {
        $(bairro).load('http://192.168.0.12:81/app-sisclinic/enderecamento.php?tipo=bairro&amp;bairro=' + escape($(this).val()));
      }
    }
  );

 
  }