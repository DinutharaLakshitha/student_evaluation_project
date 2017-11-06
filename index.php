
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Login to Student Evaluation System</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" href="style.css" type="text/css"  />
</head>
<body>

	<div class="signin-form">

		<div class="container">


			<form class="form-signin" method="post" id="login-form">

				<h2 class="form-signin-heading">Log In</h2><hr />

				<div id="error">
					<?php
                    require_once("classes/class.database.php");
					if(isset($error))
					{
						?>
						<div class="alert alert-danger">
							<i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?> !
						</div>
						<?php
					}
                    if (isset($_POST['btn-login']) && !empty($_POST['username'])
                        && !empty($_POST['password'])) {

                        $database = new Database();

                        $query="select * from interviewer where user_id = ".$_POST['username'];
                        $result=$database->getResults($query);
                        if ($result){
                            if ($row =mysqli_fetch_assoc($result)){
                                if ($_POST['username'] == $row['user_id'] && $_POST['password'] == $row['password']) {
                                    $_SESSION['valid'] = true;
                                    $_SESSION['timeout'] = time();
                                    $_SESSION['username'] = 'tutorialspoint';

                                    echo 'You have entered valid use name and password';
                                } else {
                                    $msg = 'Wrong username or password';
                                    echo 'wrong credentials';
                                }
                            }
                        }
                        else{
                            echo "no results found";
                        }


                    }
                    ?>
				</div>

				<div class="form-group">
					<input type="text" class="form-control" name="username" placeholder="Username or Email" required />
					<span id="check-e"></span>
				</div>

				<div class="form-group">
					<input type="password" class="form-control" name="password" placeholder="Your Password" />
				</div>

				<hr />

				<div class="form-group">
					<button type="submit" name="btn-login" class="btn btn-default" >
						<i class="glyphicon glyphicon-log-in"></i> &nbsp; SIGN IN
					</button>
				</div>

				<br />
				<!--<label>Don't have account yet ! <a href="sign-up.php">Sign Up</a></label>-->
			</form>

		</div>

	</div>

</body>
</html>
