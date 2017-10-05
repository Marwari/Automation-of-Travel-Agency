<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home | ATA Project</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<!-- including header file -->
	<%@include file="includes/header.html" %>
	
<!--body starts here-->
<body>
	<!--container starts here-->
	<div class="container">
		<!--row 1 starts here-->
		<div class="row">
			<div class="text-right">
				<a href="">About Us</a>
				<a href="">Contact Us</a>
			</div>
		<!--row 1 ends here-->
		</div><hr><br>
		<!--row 2 starts here-->
		<div class="row">
			<!--column 1 starts here-->
			<div class="col-sm-6">
				<img src="">
			<!--column 1 ends here-->
			</div>
			<!--column 2 starts here-->
			<div class="col-sm-6">
				<!--panel starts here-->
				<div class="panel panel-info">
					<!--panel heading-->
					<div class="panel-heading text-center"> Login</div>
					<!--panel body starts here-->
					<div class="panel-body">
						<!--form starts here-->
						<form action="" method="post">
							<div class="form-group">
      							<input type="text" class="form-control" id="uname" placeholder="Username" name="uname">
    						</div>
   							<div class="form-group">
      							<input type="password" class="form-control" id="pwd" placeholder="Password" name="pwd">
    						</div>
    						<div class="checkbox">
     							<label><input type="checkbox" name="remember"> Remember me on this computer</label>
   							</div>
   							<div class="text-right">
    							<button type="submit" class="btn btn-info">Login</button>
    						</div>
    					<!--form ends here-->
    					</form>
    				<!--footer starts and ends here
    				<div class="panel-footer text-center"><a href="">Forget your password?</a></div>
					<!--panel body ends here-->
					</div>
				<!--panel ends here-->
				</div>
				<!--linking for sign up-->
				<div class="text-center">
					<a href="">Register Here</a>
				</div>

			<!--column 2 ends here-->
			</div>
		<!--row ends here-->
		</div>
	<!--container ends here-->	
	</div>
<!--body ends here-->
</body>

<script src="js/bootstrap.js"></script>
<!-- including footer file -->
	<%@include file="includes/footer.html" %>
</html>