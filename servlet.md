## Servlet

Servlet é um componente que trata requisições que sejam enviadas a esse componente.
Quando ele é embarcado em um Web Container, como o Apache TomCat ou o Glassfish.
Ele é chamado como resposta a essas requisições.
@WebServlet("/test")
Ele deve extender o HttpServlet.
Os métodos doGet e doPost podem rescritos conforme a necessidade.
Os parâmetros dos métodos doGet e doPost são do tipo HttpServletRequest e HttpServletResponse.

HttpServletRequest
Caso desejamos setar algo como requisição, devemos setar o HttpServletRequest

HttpServletResponse
Se desejamos setar algo como resposta, devemos setar esse parâmetro.

* Request
 - Recuperar parâmetros
 - Recuperar headers
 - Recuperar cookies
 - Recuperar o método HTTP
 - Recuperar a InsputStream da requisção

### Recuperando Informações de uma Request

/test?nome=Lucas

```java
@Webservlet("/test")
public class TestServlet extends HttpServlet{
    protected void doGet(
        HttpServletRequest rq,
        HttpServletResponse rp) throws IOException{
            String nome = rq.getParameter("nome"));
        //....
        }
}
```

* Response
 - Configurar headers
 - Configurar tipo de conteúdo (normalmente Html), ou imagens para que o navegador exiba corretamente
 - Retornar texto
 - Retornar outro tipo de dado binário

### Configurando Informações de uma Reponse

```java
@Webservlet("/test")
public class TestServlet extends HttpServlet{
    protected void doGet(
        HttpServletRequest rq,
        HttpServletResponse rp) throws ServletException, IOException{
            String nome = rq.getParameter("nome"));
            rp.GetWriter().println(
                "<H1>Hello " + nome + "</H1>");
        }
}
```

Na abordagem MVC não é usual escrever diretamente o código HTML na saída do servlet.
É possível repassar internament no Servlet o controle para outro recurso. Então o Servlet faz o processamento necessário, e quanto for necessário repassa o controle para o recurso, nesse caso a página "view.jsp"

```java
@Webservlet("/test")
public class TestServlet extends HttpServlet{
    protected void doGet(
        HttpServletRequest rq,
        HttpServletResponse rp) throws ServletException, IOException{
            //....
            RequestDispatcher view = rq.getRequestDispatcher("view.jsp");
            view.forward(rq,rp);
        }
}
```
Assim é possível passar o controle para uma página jsp, e a mesma terminará o processamento.

## Escopos de uma Aplicação Web

### Uma requisição
  Escopo mais restrito. Quando a requisição termina, todas as informações contidas nele são perdidas.
request

### Sessão do Usuário
  Escopo intermediário. Onde são guardadas informações durante o acesso de um usuário a nossa aplicação.
request.getSession()

### Aplicação
  Escopo mais amplo. Acessível de qualquer outra sessão.
getServletContext()

Todos esses escopos, possuem o métodos setAttiribute("name", "John"), e também o getAttribute("name"). Esses escopos são capazes de manipular tantos tipos primitivos, ou Objects, ou seja, qualquer objeto Java (listas, objetos, arrays, etc) podem ser setados ou buscados dentro desses contextos.

E através desses atributos que passamos informações, dentro de uma aplicação Web.

Mas como é possível manter uma sessão ativa, se o protocolo HTTP não mantém uma conexão ativas? Essa funcionalidade de sessões não é uma funcionalidade nativa do protocolo e por isso foram criadas as seguintes ferramentas:

Cookies:
Pequenos arquivos que guardam informações que são trocadas entre o web content e o navegador do usuário.

Reescrita de URL
response.encodeURL(url)
A reescrita só se feita se o container web percebe que não estão sendo trocados cookies, ou melhor, caso os cookies estejam desativados.

ID da sessão SSL
ID da sessão da SSL é opção mais segura de se guardar uma sessão, através do id de uma sessão criptográfica de uma sessão SSL. O protocolo SSL é capaz de guardar o id da sessão em uma conexão segura (https), diferente de uma conexão não segura, que não mantém as informações da sessão.

# Servlets e Java
Para criarmos um Servlet Básico em Java, utilizando o Tomcat, JSP e o IntelliJ como IDE precisaremos fazer as seguintes configurações para nosso ambiente.

Para os nossas aulas utlizaremos o Tomcat na versão 10.1.25 https://tomcat.apache.org/download-10.cgi.
É importante sempre verificar a compatibilidade tanto das bibliotecas entre si, bem como, a compatibilidade das bibliotecas com o web container (Tomcat).


## Configuração da IDE - Intellij IDEA
1 - Baixar o Tomcat https://tomcat.apache.org/download-10.cgi
No Canto superior direito, clicar em Current File -> Edit Configurations
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/ed801e0c-77f5-4436-882d-d6f25813e9d8)
Clicar no +, ou alt + insert.
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/e081bc33-0dde-4aca-a8bf-827aad8c68c1)
Tomcat Server -> local
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/8ddb71e2-fc24-4ff7-a32d-c48be68f2fe2)
Apontar para o local onde estão os arquivos descompactados do Tomcat obtidos anteriormente.
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/5fd5e336-b50c-412c-a425-8193d9821d7d)
Na aba Before Launch configurar como abaixo.
![image](https://github.com/lschlestein/servlet/assets/103784532/cd7b1efd-8306-4f3e-958c-4c8baa5cfa8c)
Na aba Deployment, configura o caminhao de acesso ao projeto em Application Context
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/f6441891-9fa6-464a-b250-336f039730bf)

Criar um novo projeto web no IntelliJ
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/e86e405e-8aca-4e04-b640-86512984473a)

Selecionar Web Profile
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/07d19831-fc37-439a-9320-b1b3de429d58)
Então cliclar em Create

Clicar em Run.
![Intellij](https://github.com/lschlestein/servlet/assets/103784532/7a5b5bf2-9e76-47e7-a72b-fe6bbed68deb)
O Tomcat deverá inicar e aplicação deverá ser iniciada no navegador.

Para nosso projetos, as bibliotecas básicas que precisaremos são:

- jakarta.jakartaee-web-api
``` xml
<dependency>
    <groupId>jakarta.platform</groupId>
    <artifactId>jakarta.jakartaee-web-api</artifactId>
    <version>10.0.0</version>
    <scope>provided</scope>
</dependency>
```
Esta dependência inclui todas as APIs da plataforma Jakarta EE 10, como Servlet, JSP, JSTL, JAX-RS, CDI, entre outras. Utilizando esta dependência, você tem acesso a todas as classes e interfaces da especificação Jakarta EE.

Escopo provided:
O escopo provided significa que esta dependência é necessária para compilar e testar seu projeto, mas não será incluída no arquivo WAR final. Isso acontece porque a implementação dessas APIs é fornecida pelo servidor de aplicação (Tomcat, no seu caso).

- jakarta.servlet.jsp.jstl-api
``` xml
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.0.0</version>
</dependency>
```
Esta dependência fornece a API para a biblioteca de tags JSP Standard Tag Library (JSTL). A JSTL oferece um conjunto de tags úteis para tarefas comuns em páginas JSP, como iteração e formatação.

API vs Implementação:
Esta dependência inclui apenas a API, ou seja, as interfaces e classes abstratas que definem como a JSTL deve se comportar. Ela não inclui a implementação real das funcionalidades.

- jakarta.servlet.jsp.jstl
``` xml
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
</dependency>
```
Esta dependência fornece a implementação real da JSTL. Enquanto a dependência jakarta.servlet.jsp.jstl-api define as interfaces, esta dependência contém o código que executa as funcionalidades descritas por essas interfaces.

Combinação de API e Implementação:
Ambas as dependências (jakarta.servlet.jsp.jstl-api e jakarta.servlet.jsp.jstl) são necessárias porque uma define a API e a outra fornece a implementação. A implementação realiza as operações descritas pela API quando as tags JSTL são usadas nas páginas JSP.

Configurado nosso projeto podemos implementar nosso primeiro servlet.

O nosso primeiro objetivo é criar uma página de login simples, ainda sem acesso ao banco de dados:
Para isso precisaremos configurar um página de acesso a nossa aplicação como segue:

``` html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Servlet</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required />
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required />
    <br/>
    <button type="submit">Login</button>
</form>
</body>
</html>
```
Ao cliclarmos em Login, os parâmetros email e password, são adicionados a requisição enviada ao servlet.
Aqui estamos fazendo uma requisição do tipo "post" em nosso servlet. O action="login", deve estar atribuída a nosso servlet.

```java
package com.servlet.login.loginservletexample;

import com.servlet.login.loginservletexample.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/index", "/login", "/addNewUser"})
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        if (action.equals("/login")) {
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            request.setAttribute("email", email);
            if(email.equals("lucas@mail.com") && password.equals("123")){
              request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else{
              request.getRequestDispatcher("loginFail.jsp").forward(request, response);
            }
        }
    }
}
```
Agora, no servlet adicionamos o atributos "email" a response.
Se o login é de sucesso, redirecionamos os atributos a view "welcome.jsp".
Caso contrário a view "loginFail.jsp" será mostrada.

welcome.jsp
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome ${user.name} your email is ${user.email}</h1>
</body>
</html>
```
loginFail.jsp
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Failed</title>
</head>
<body>

<h1>Couldn't find #${user.email}# in database. Try again!</h1>

<a href="login.jsp">Login</a>

</body>
</html>
```
