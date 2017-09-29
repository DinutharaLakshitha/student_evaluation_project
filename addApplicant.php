<<?php
$userRow['user_level'] ='2'


  ?>





<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Add student</title>
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
  <script type="text/javascript" src="jquery-1.11.3-jquery.min.js"></script>
  <link rel="stylesheet" href="style.css" type="text/css"  />
</head>
<body>
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="home.php">Home</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href="home.php">Home</a></li>
          <li><a href="profile.php">Profile</a></li>

            <?php

            if ($userRow['user_level']=='2') { ?>
              <li class="active"><a href="addApplicant.php">Add Applicant</a></li>
              <?php } ?>


              </ul>
              <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  <!--  <span class="glyphicon glyphicon-user"></span>&nbsp;Hi' <?php echo $userRow['user_email']; ?>&nbsp;<span class="caret"></span></a> -->
                    <ul class="dropdown-menu">
                      <li><a href="profile.php"><span class="glyphicon glyphicon-user"></span>&nbsp;View Profile</a></li>
                      <li><a href="changePass.php"><span class="glyphicon glyphicon-user"></span>&nbsp;Change Password</a></li>
                      <li><a href="logout.php?logout=true"><span class="glyphicon glyphicon-log-out"></span>&nbsp;Sign Out</a></li>
                    </ul>
                  </li>
                </ul>
              </div><!--/.nav-collapse -->
            </div>
          </nav>
          <div class="signin-form">

            <div class="container">

              <form method="post" class="form-signin">
                <h2 class="form-signin-heading">Add Applicant</h2><hr />
                <?php
                if(isset($error))
                {
                  foreach($error as $error)
                  {
                    ?>
                    <div class="alert alert-danger">
                      <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                    </div>
                    <?php
                  }
                }
                else if(isset($_GET['joined']))
                {
                  ?>
                  <div class="alert alert-info">
                    <i class="glyphicon glyphicon-log-in"></i> &nbsp; Successfully registered <a href='index.php'>Go back</a>
                  </div>
                  <?php
                }
                ?>
                <h4 class="form-signin-heading">ID</h4>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_idno" placeholder="Application Number" value="<?php if(isset($error)){echo $idno;}?>" />
                </div>
                <h4 class="form-signin-heading">Name</h4>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_fname" placeholder="First Name" value="<?php if(isset($error)){echo $fname;}?>" />
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_mname" placeholder="Middle Name Initial in Capital" value="<?php if(isset($error)){echo $mname;}?>" />
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_lname" placeholder="Last Name" value="<?php if(isset($error)){echo $lname;}?>" />
                </div>
                <h4 class="form-signin-heading">Address</h4>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_home_num" placeholder="Home Number" value="<?php if(isset($error)){echo $home_num;}?>" />
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_street_name" placeholder="Street Name" value="<?php if(isset($error)){echo $street_name;}?>" />
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_city_name" placeholder="City" value="<?php if(isset($error)){echo $city_name;}?>" />
                </div>
                <h4 class="form-signin-heading">Contact</h4>
                <div class="form-group">
                  <input type="text" class="form-control" name="txt_phone" placeholder="Phone Number" value="<?php if(isset($error)){echo $phone;}?>" />
                </div>
              <h4 class="form-signin-heading">Date of Birth</h4>
              <div class="form-group">
                <select name="date">
                  <option value="NO">Date</option>
                  <option value="0">0</option>
                  <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option>
                  <option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option>
                  <option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>
                  <option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>
                  <option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option>
                  <option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
                  <option value="31">31</option>



                </select>
                <select name="month">
                  <option value="NO">Month</option>
                  <option value="1">jan</option>
                  <option value="2">feb</option>
                  <option value="3">mar</option>
                  <option value="4">aprl</option>
                  <option value="5">may</option>
                  <option value="6">june</option>
                  <option value="7">july</option>
                  <option value="8">aug</option>
                  <option value="9">sep</option>
                  <option value="10">oct</option>
                  <option value="11">nov</option>
                  <option value="13">dec</option>

                </select>
                <br>
              </div>
              <h4 class="form-signin-heading">Distance</h4>
              <div class="form-group">
                <input type="text" class="form-control" name="txt_distance" placeholder="Distance from home" value="<?php if(isset($error)){echo $distance;}?>" />
              </div>

                <div class="clearfix"></div><hr />
                <div class="form-group">
                  <button type="submit" class="btn btn-primary" name="btn-signup">
                    <i class="glyphicon glyphicon-open-file"></i>&nbsp;Add Applicant
                  </button>
                </div>
                <br />
                <label>want to cancel! <a href="index.php">Cancel</a></label>
              </form>
            </div>
          </div>

        </div>
        <script src="bootstrap/js/bootstrap.min.js"></script>
      </body>
      </html>
