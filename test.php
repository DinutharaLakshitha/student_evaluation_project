<?php

require_once("classes/class.database.php");

$database = new Database();

$query="select * from interviewer";
$result=$database->getResults($query);
if ($result){
    while ($row =mysqli_fetch_assoc($result)){
        echo $row['user_id'],$row['user_name'],$row['tel'];
    }
}

?>
