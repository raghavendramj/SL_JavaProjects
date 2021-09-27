<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET vs POST Demo</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="mt-4 p-5 bg-primary text-white rounded">
			<h1>GET vs POST Demo</h1>
			<p>Servlet GET and POST Request!</p>
		</div>

		<form method=post action="posthandler">
			<div class="form-group">
				<label for="email">Do A Get Request:</label> <a
					href="gethandler?name=John+Doe&address=145+Lake+Avenue">Do a Servlet GET</a>
			</div>

			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="pwd">Address:</label> 
				<input type="text" class="form-control" id="address" name="address">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>