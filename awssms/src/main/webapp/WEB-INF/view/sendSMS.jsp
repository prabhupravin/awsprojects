<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Send SMS to a mobile number</h1>
	<form action="sendSMS" method="post">
		<table>
			<tr>
				<td><label>+</label></td>
				<td>ISD<input name="isdcode" type="number" min="1" maxlength="3" pattern="\d*"/></td>
				<td>Number<input name="mobileNumber" type="number" min="1" pattern="\d*"/></td>
			</tr>
			<tr>
				<td colspan="3">Enter Message here:<textarea name="message" rows="4" cols="50" maxlength="159"></textarea></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit"> </td>
			</tr>
		</table>
	</form>
</body>
</html>