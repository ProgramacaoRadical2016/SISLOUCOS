<?php 
header("Access-Control-Allow-Origin: *");

include('conexao.php');

$data=array();
$usuarioLogado = $_GET['usuario'];
$q=mysql_query("select ac.*, co.*, es.*, pa.*, DATE_FORMAT( `agendamento_consulta_data` , '%d/%c/%Y %H:%i:%s' ) AS `data` from `tb_agendamento_consulta` ac
				inner join `tb_especialidade` es on ac.especialidade_id = es.especialidade_id
				inner join `tb_convenio` co on ac.convenio_id = co.convenio_id
				inner join `tb_paciente` pa on ac.paciente_id = pa.paciente_id
				inner join `tb_usuario` us on pa.usuario_id = us.usuario_id
				where us.usuario_login = '$usuarioLogado'");
while ($row=mysql_fetch_array($q)){
 $data[]=$row; 
}
echo json_encode($data);
?>