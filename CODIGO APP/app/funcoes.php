<?php
header("Access-Control-Allow-Origin: *");

// Conecta no banco
include('conexao.php');

// Responsavel por criar a conta no aplicativo/sistema
if(isset($_POST['cadastrar']))
{
	$nome=mysql_real_escape_string(htmlspecialchars(trim($_POST['nome'])));
	$email=mysql_real_escape_string(htmlspecialchars(trim($_POST['email'])));
	$login=mysql_real_escape_string(htmlspecialchars(trim($_POST['login'])));
	$senha=md5(mysql_real_escape_string(htmlspecialchars(trim($_POST['senha']))));
	$sexo=mysql_real_escape_string(htmlspecialchars(trim($_POST['sexo'])));
	$dataNascimento1=mysql_real_escape_string(htmlspecialchars(trim($_POST['dataNascimento']))); 
	$cpf=mysql_real_escape_string(htmlspecialchars(trim($_POST['cpf'])));
	$telefone=mysql_real_escape_string(htmlspecialchars(trim($_POST['telefone'])));
	$celular=mysql_real_escape_string(htmlspecialchars(trim($_POST['celular'])));
	$unidadeFederativa=mysql_real_escape_string(htmlspecialchars(trim($_POST['unidadeFederativa'])));
	$cidade=mysql_real_escape_string(htmlspecialchars(trim($_POST['cidade'])));
	$bairro=mysql_real_escape_string(htmlspecialchars(trim($_POST['bairro'])));
	$tipoLogradouro=mysql_real_escape_string(htmlspecialchars(trim($_POST['tipoLogradouro'])));
	$logradouro=mysql_real_escape_string(htmlspecialchars(trim($_POST['logradouro'])));
	$numero=mysql_real_escape_string(htmlspecialchars(trim($_POST['numero'])));
	$complemento=mysql_real_escape_string(htmlspecialchars(trim($_POST['complemento'])));
	$cep=mysql_real_escape_string(htmlspecialchars(trim($_POST['cep'])));

	$loginVerifica=mysql_num_rows(mysql_query("select * from `tb_usuario` where `usuario_login`='$login'"));
	if($loginVerifica==1)
	{
		echo "existe";
	}
	else
	{
		$tbUsuario=mysql_query("INSERT INTO `tb_usuario` (`usuario_nome`,`usuario_email`,`usuario_login`,`usuario_senha`) values ('$nome','$email','$login','$senha')"); 
		$tbPessoa=mysql_query("INSERT INTO `tb_pessoa` (`pessoa_nome`, `sexo_id`, `pessoa_data_dascimento`, `pessoa_cpf`, `pessoa_telefone`, `pessoa_celular`, `pessoa_email`, `pessoa_cep`, `tipo_logradouro_id`, `pessoa_logradouro`, `pessoa_numero`, `unidade_federativa_id`, `cidade_id`, `bairro_id`, `pessoa_complemento`) VALUES ('$nome', '$sexo', '$dataNascimento1', '$cpf', '$telefone', '$celular', '$email', '$cep', '$tipoLogradouro', '$logradouro', '$numero', '$unidadeFederativa', '$cidade', '$bairro', '$complemento');
"); 
		$tbPaciente=mysql_query("INSERT INTO `tb_paciente` (`pessoa_id`,`usuario_id`) values ((SELECT MAX(pessoa_id) FROM `tb_pessoa`),(SELECT MAX(usuario_id) FROM `tb_usuario`))");
 
		echo "sucesso"; 
	
	}
	echo mysql_error();
}

// Responsavel por agendar a consulta no aplicativo/sistema
if(isset($_POST['agendar']))
{	
	$paciente=mysql_real_escape_string(htmlspecialchars(trim($_POST['paciente_id'])));
	$especialidade=mysql_real_escape_string(htmlspecialchars(trim($_POST['especialidade'])));
	$convenio=mysql_real_escape_string(htmlspecialchars(trim($_POST['convenio'])));
	$data=mysql_real_escape_string(htmlspecialchars(trim($_POST['data']))); 
	$horario=mysql_real_escape_string(htmlspecialchars(trim($_POST['horario']))); 
 
	$data_consulta = $data." ".$horario; 
  
	$agendarVerifica=mysql_num_rows(mysql_query("select * from `tb_agendamento_consulta` where `agendamento_consulta_data`='$data_consulta'"));
	if($agendarVerifica==1)
	{
		echo "existe";
	}
	else
	{
		$tbUsuario=mysql_query("INSERT INTO `tb_agendamento_consulta` (`convenio_id`, `especialidade_id`, `agendamento_consulta_data`, `paciente_id`, `empresa_id`) VALUES ('$convenio', '$especialidade', '$data_consulta', '$paciente', '1')"); 
		
		echo "sucesso"; 
	
	}
	echo mysql_error();
}

// esponsavel por logar no aplicativo
if(isset($_POST['login']))
{
	$login=mysql_real_escape_string(htmlspecialchars(trim($_POST['login'])));
	$senha=md5(mysql_real_escape_string(htmlspecialchars(trim($_POST['senha']))));
	$entrar=mysql_num_rows(mysql_query("select * from `tb_usuario` where `usuario_login`='$login' and `usuario_senha`='$senha'"));
	if($entrar!=0)
	{
		echo "sucesso";
	}
	else
	{
		echo "falhou";
	}
} 

// Responsavel por gerar e enviar uma nova senha por e-mail
if(isset($_POST['lembrarSenha']))
{
	$email=mysql_real_escape_string(htmlspecialchars(trim($_POST['email'])));
	$q=mysql_query("select * from `tb_usuario` where `usuario_email`='$email'");
	$check=mysql_num_rows($q);
	if($check!=0)
	{
		echo "sucesso";

		mysql_query("update `tb_usuario` set `usuario_senha`='$new_password' where `usuario_email`='$email'");

		$data=mysql_fetch_array($q);
		$string="Olá,".$data['nome'].", Sua senha é ".$data['password'];
		mail($email, "Nova Senha", $string);
	}
	else
	{
		echo "invalido";
	}
}

?>