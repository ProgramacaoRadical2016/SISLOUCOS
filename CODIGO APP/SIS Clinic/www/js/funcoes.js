$(document).ready(function(){
	var url="http://localhost/app/funcoes.php?callback=?";
    
    //Função responsavel por entrar no app
    $("#entrar").click(function(){
    	
    	var login=$("#login").val();
    	var senha=$("#senha").val();
    	var dataString="login="+login+"&senha="+senha+"&entrar=";
    	if($.trim(login).length>0 & $.trim(senha).length>0)
		{
			$.ajax({
				type: "POST",
				url: url,
				data: dataString,
				crossDomain: true,
				cache: false,
				beforeSend: function(){ $("#entrar").html('Efetuando login...');},
				success: function(data){
					if(data=="sucesso")
					{
						localStorage.entrar="true";
						localStorage.login=login;
						window.location.href = "index.html";
					}
					else if(data="falhou")
					{
						alert("Usuário ou senha inválido");
						$("#entrar").html('Entrar');
					}
				}
			});
		}return false;

    });

    //Função responsavel por cadastrar o usuário no app/sistema
    $("#cadastrar").click(function(){
    	var nome=$("#usuario_nome").val(); 
    	var email=$("#usuario_email").val();
    	var login=$("#usuario_login").val();
    	var senha=$("#usuario_senha").val();
    	var sexo=$("#listaSexo").val();
    	var dataNascimento=$("#pessoa_data_nascimento").val();
    	var cpf=$("#pessoa_cpf").val();
    	var telefone=$("#pessoa_telefone").val();
    	var celular=$("#pessoa_celular").val();
    	var unidadeFederativa=$("#listaEstado").val();
    	var cidade=$("#listaCidade").val();
    	var bairro=$("#listaBairro").val();
    	var tipoLogradouro=$("#listaTipoLogradouro").val();
    	var logradouro=$("#pessoa_logradouro").val();
    	var numero=$("#pessoa_numero").val();
    	var complemento=$("#pessoa_complemento").val();
    	var cep=$("#pessoa_cep").val();

    	var dataString="nome="+nome+"&email="+email+"&login="+login+"&senha="+senha+"&sexo="+sexo+"&dataNascimento="+dataNascimento+"&cpf="+cpf+"&telefone="+telefone+"&celular="+celular+"&unidadeFederativa="+unidadeFederativa+"&cidade="+cidade+"&bairro="+bairro+"&tipoLogradouro="+tipoLogradouro+"&logradouro="+logradouro+"&numero="+numero+"&complemento="+complemento+"&cep="+cep+"&cadastrar=";

    	if($.trim(nome).length>0 & $.trim(login).length>0 & $.trim(senha).length>0)
		{
			$.ajax({
				type: "POST",
				url: url,
				data: dataString,
				crossDomain: true,
				cache: false,
				beforeSend: function(){ $("#cadastrar").val('Cadastrando...');},
				success: function(data){
					if(data=="existefalhou")
					{
						alert("Usuário já existe. ");
					} 
					else
					{
						alert("Conta criada com sucesso.");
						window.location.href='entrar.html';
					}
				}
			});
		}return false;

    });

	//Função responsavel por cadastrar o usuário no app/sistema
    $("#agendar").click(function(){
    	var usuariologadoid=$("#usuariologadoid").val(); 
    	var especialidade=$("#listaEspecialidade").val(); 
    	var convenio=$("#listaConvenio").val();
    	var data=$("#agendamento_consulta_data").val(); 
    	var horario=$("#agendamento_consulta_horario").val(); 

    	var dataString="especialidade="+especialidade+"&convenio="+convenio+"&data="+data+"&horario="+horario+"&paciente_id="+usuariologadoid+"&agendar=";

    	if($.trim(especialidade).length>0 & $.trim(convenio).length>0 & $.trim(data).length>0 & $.trim(horario).length>0)
		{
			$.ajax({
				type: "POST",
				url: url,
				data: dataString,
				crossDomain: true,
				cache: false,
				beforeSend: function(){ $("#agendar").val('Reservando...');},
				success: function(data){
					if(data=="existefalhou")
					{
						alert("Já possui uma consulta neste dia e horário.");
					} 
					else
					{
						alert("Consulta reservada com sucesso.");
						window.location.href='entrar.html';
					}
				}
			});
		}return false;

    });

    //Função responsavel por enviar uma nova senha para o e-mail do paciente
    $("#lembrarSenha").click(function(){
    	var email=$("#email").val();
    	var dataString="email="+email+"&lembrarSenha=";
    	if($.trim(email).length>0)
		{
			$.ajax({
				type: "POST",
				url: url,
				data: dataString,
				crossDomain: true,
				cache: false,
				beforeSend: function(){ $("#lembrarSenha").val('Redefinindo...');},
				success: function(data){
					if(data=="invalido")
					{
						alert("Não encontramos seu cadastro");
					}
					else if(data="sucesso")
					{
						alert("Enviamos para o seu e-mail favor verificar");
					}
				}
			});
		}return false;

    });


    //Função responsavel por sair do app
    $("#sair").click(function(){
    	localStorage.entrar="false";
    	window.location.href = "entrar.html";
    });
 
    var usuarioLogado = localStorage.login;

    //Jason responsavel por buscar no banco e trazer na tela as informações de consultadas agendadas do cliente
    var urlJasonUsuarioLogado="http://localhost/app/json-usuarioLogado.php?usuario="+ usuarioLogado +"";
	$.getJSON(urlJasonUsuarioLogado,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var usuario_id_logado=field.usuario_id; 
 
			$('#usuariologadoid').val($('#usuariologadoid').val() + + usuario_id_logado +'');

			});
	});


    //Jason responsavel por buscar no banco e trazer na tela as informações de consultadas agendadas do cliente
    var urlJasonConsulta="http://localhost/app/json-consulta.php?usuario="+ usuarioLogado +"";
	$.getJSON(urlJasonConsulta,function(result){
		console.log(result);
			$.each(result, function(i, field){
			var id=field.id; 
			var agendamento_consulta_data=field.data;
			var especialidade_descricao=field.especialidade_descricao;
			var convenio_descricao=field.convenio_descricao;

			$("#listview").append('<a class="item item-icon-right"><h2>'+ especialidade_descricao + ' - '+ convenio_descricao + '</h2><p>'+ agendamento_consulta_data +'</p><i class="icon ion-ios-checkmark"></i></a>');

			});
	});

	//Jason responsavel por buscar no banco e trazer na tela as informações de CONVENIO utilizada no agendamento da consulta
	var urlJasonConvenio="http://localhost/app/json-convenio.php";
	$.getJSON(urlJasonConvenio,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var convenio_id=field.convenio_id;
			var convenio_descricao=field.convenio_descricao;
			
			$("#listaConvenio").append("<option value="+ convenio_id + ">"+ convenio_descricao + "</option>");

			});
	}); 

	//Jason responsavel por buscar no banco e trazer na tela as informações de ESPECIALIDADE utilizada no agendamento da consulta
	var urlJasonEspecialidade="http://localhost/app/json-especialidade.php";
	$.getJSON(urlJasonEspecialidade,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var especialidade_id=field.especialidade_id;
			var especialidade_descricao=field.especialidade_descricao;
			
			$("#listaEspecialidade").append("<option value="+ especialidade_id + ">"+ especialidade_descricao + "</option>");

			});
	}); 

	//Jason responsavel por buscar no banco e trazer na tela as informações de SEXO utilizada no cadastro
	var urlJasonSexo="http://localhost/app/json-sexo.php";
	$.getJSON(urlJasonSexo,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var sexo_id=field.sexo_id;
			var sexo_descricao=field.sexo_descricao;
			
			$("#listaSexo").append("<option value="+ sexo_id + ">"+ sexo_descricao + "</option>");

			});
	});

	//Jason responsavel por buscar no banco e trazer na tela as informações de ESTADO utilizada no cadastro
	var urlJasonEstado="http://localhost/app/json-estado.php";
	$.getJSON(urlJasonEstado,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var unidade_federativa_id=field.unidade_federativa_id;
			var unidade_federativa_descricao=field.unidade_federativa_descricao;
			
			$("#listaEstado").append("<option value="+ unidade_federativa_id + ">"+ unidade_federativa_descricao + "</option>");

			});
	});

	//Jason responsavel por buscar no banco e trazer na tela as informações de CIDADE utilizada no cadastro
	var urlJasonCidade="http://localhost/app/json-cidade.php";
	$.getJSON(urlJasonCidade,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var cidade_id=field.cidade_id;
			var cidade_nome=field.cidade_nome;
			
			$("#listaCidade").append("<option value="+ cidade_id + ">"+ cidade_nome + "</option>");

			});
	});

	//Jason responsavel por buscar no banco e trazer na tela as informações de BAIRRO utilizada no cadastro
	var urlJasonBairro="http://localhost/app/json-bairro.php";
	$.getJSON(urlJasonBairro,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var bairro_id=field.bairro_id;
			var bairro_nome=field.bairro_nome;
			
			$("#listaBairro").append("<option value="+ bairro_id + ">"+ bairro_nome + "</option>");

			});
	});

	//Jason responsavel por buscar no banco e trazer na tela as informações de TIPO DE LOGRADOURO utilizada no cadastro
	var urlJasonTipoLogradouro="http://localhost/app/json-tipo-logradouro.php";
	$.getJSON(urlJasonTipoLogradouro,function(result){
		console.log(result);
			$.each(result, function(i, field){ 
			var tipo_logradouro_id=field.tipo_logradouro_id;
			var tipo_logradouro_descricao=field.tipo_logradouro_descricao;
			
			$("#listaTipoLogradouro").append("<option value="+ tipo_logradouro_id + ">"+ tipo_logradouro_descricao + "</option>");

			});
	}); 

});