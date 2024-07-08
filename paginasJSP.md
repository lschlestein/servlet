# Páginas JSP (Java Server Page)
``` mermaid
flowchart TD
    A[Página JSP] -->|Tradução| B(Página.java)
    B-->|Compilação| C[Página.class]-->|Carregamento e inicialização| D[Servlet]
```
 
 A gente tem ali cima a página JSP, o primeiro passo que acontece é uma tradução que vai transformar a página JSP numa classe Java, que vai gerar aquela página. 
 Depois, essa classe Java é compilada, da mesma forma que todas as nossas classes são, ocorrendo então o carregamento e inicialização e aquilo ali, em tempo de execução dentro do Web Container, vai-se transformar servlet. 
 Então, na verdade, a página JSP em tempo de execução vira um servlet. 
 É notável, que a primeira renderização de uma pagína JSP é mais demorar, pelo fato dela estar sendo compilada nesse primeiro acesso. Essa compilação ocorre somente no primeiro acesso.
 É importante também ressaltar, caso haja algum erro, verificar pela mensagem onde esse erro ocorre. Se foi por exemplo no mento de tranformar JSP em Java? Ou no momento de compilar o código, caso estejamos tentar
 por exemplo, acessar uma varáivel que não exista.

## Codificando uma página JSP.

### Scriptlet
Veja o scriptle abaixo.
```html
<% out.println(request.getParameter(var));%>
```
Dessa forma, a informação que está entre  <%...%> vai diretamente para o código.

### Expressão
```html
<%= request.getParameter(var) %>
```
Dessa forma, a informação que está entre  <%=...%> vai ser exibida dentro de um print.

### Declaração
```html
<%! int count=0; %>
```
Dessa forma, a informação que está entre  <%!...%> vai ser declara, fora do método.

## Diretiva
A diretiva são orietações passadas ao Web Container de como se dever ser feita a tradução da página. Ou definem como o Web Container deverá transformar a página JSP em código Java.
```html
<%@ page import = "java.util.Date" session="false"%>
```
Acima definimos parâmetros para a traduação da página.

```html
<%@ taglib tagdir="/WEB-INF/cool" prefix="c" %>
```
Acima importamos uma taglib que será utilizada nessa página.

## Expression Language
Uma forma mais elegante e poderosa de acessar objetos nas JSP.
``` html
${pessoa.nome}
${pessoa["nome"]}
${pessoa.getNome()}
```
O objeto acima poderia estar em qualquer um dos escopos. *(request, session ou application)*
### Bibliotecas de Tag
As biliotecas disponibilizam várias funcionalidades para auxilar com nossas páginas.
Um exemplo é a exibição de uma lista através de uma laço For.

```jsp
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<ul>
    <c:forEach var="person" items="${persons}">
        <li>
            Id: ${person.id}
            Name: ${person.name}
        </li>
    </c:forEach>
</ul>
```



