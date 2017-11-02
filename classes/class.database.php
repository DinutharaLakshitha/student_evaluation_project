<?php



class Database
{
  private $host = "localhost";
  private $dbname = "dbschoolintake";
  private $username = "root";
  private $password = "";
  private $port="3306";
  public $conn;


  public function __construct()
  {
    $this->conn = new mysqli($this->host, $this->username, $this->password,$this->dbname,$this->port);
  }

  public function getResults($query){
      $result = mysqli_query($this->conn, $query);
      return $result;
  }
    
}
?>
