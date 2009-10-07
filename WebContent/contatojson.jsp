<%@page import="com.loiane.json.ContatoJson"%>
<%
	ContatoJson contatoJson = new ContatoJson();
    String contatos = contatoJson.getJson();
    out.println(contatos); 
%>

