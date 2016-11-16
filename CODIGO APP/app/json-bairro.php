<?php 
header("Access-Control-Allow-Origin: *");

include('conexao.php');

mysql_query("SET NAMES 'utf8'");
$data=array();
$q=mysql_query("select * from `tb_bairro`");
while ($row=mysql_fetch_array($q)){
 $data[]=$row; 
}
echo json_encode($data);
?>