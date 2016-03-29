<%-- 
    Document   : newjsp
    Created on : 26/02/2016, 10:54:37
    Author     : Zilderlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
</head>

	

<SCRIPT LANGUAGE="JavaScript" TYPE="text/javascript">
	vetor = new Array ("José", "Maria", "João", "Patrícia");
	document.write ("Este array possui "+vetor.length+" elementos.<BR>");
	document.write ("Vamos remover "+vetor.shift()+" da lista.<BR>");
	document.write ("Agora, temos "+vetor.length+" elementos.<BR>"
	+ "Que são: "+vetor.join(", "));


	vetor1 = new Array ("A", "2", "3", "4", "5", "R", "6",
	"7", "8", "9", "10", "J", "Q", "K");
	document.write("<BR>Tamanho: " + vetor1.length);
	document.write("<BR>"+vetor1 + "");
	for (i=5; i<vetor.length-1; i++) {
	vetor[i] = vetor[i+1];
	}
	vetor1.pop()
	document.write("<BR>Tamanho: " + vetor1.length);
	document.write("<BR>"+vetor1 + "");
</SCRIPT>

<body>

<img src="C:\uploads/user.jpg">

</body>
</html>