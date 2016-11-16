<?php 
header("Access-Control-Allow-Origin: *");

include('conexao.php');

$data=array();
$usuarioLogado = $_GET['usuario'];
$q=mysql_query("select * from `tb_usuario` where usuario_login = '$usuarioLogado'");
while ($row=mysql_fetch_array($q)){
 $data[]=$row; 
}
echo json_encode($data);
?>