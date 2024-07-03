Fundamento de aplicações Web.

A Web não foi sempre da forma que conhecemos atualmente. Nos primórdios ela e os navegadores foram  desenvolvidos para acessar documentos estáticos de hipertexto, possibilitando navegação entre elas.
O protocolo que possibilitava essa navegação é HTTP, que hoje é utlizado para imagens, vídeos, e diversos outros arquivos alé de hipertexto.
Esse protocolo é baseado em pergunta e resposta (request e reponse).
Quando um navegador por exemplo, faz uma pergunta (request) para um servidor, esse servidor processa essa pergunta e responde (response).

Request
- Método HTTP
- URL
- Parâmetros

```html
GET /docs/index.html HTTP/1.1
Host: www.nowhere123.com
Accept: image/gif, image/jpeg, */*
Accept-Language: en-us
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)
(blank line)
  ```


Response

- Código de Status
- Tipo de Conteúdo
- Conteúdo

```html
HTTP/1.1 200 OK
Date: Sun, 18 Oct 2009 08:56:53 GMT
Server: Apache/2.2.14 (Win32)
Last-Modified: Sat, 20 Nov 2004 07:16:26 GMT
ETag: "10000000565a5-2c-3e94b66c2e680"
Accept-Ranges: bytes
Content-Length: 44
Connection: close
Content-Type: text/html
X-Pad: avoid browser bug
  
<html><body><h1>It works!</h1></body></html>
```

### URL
A url é dividida basicamente como segue:

* Protocolo: HTTP ou HTTPS
* Servidor ou IP:
* Porta:
* Caminho:
* Recurso: Páginas figuras
* Parâmetros: via query String

![image](https://github.com/lschlestein/servlet/assets/103784532/922c571d-40fd-436f-8490-c505fa7498ed)

Métodos HTTP:

*GET*
Acessar um link.
Principal diferença está na forma de passar os parâmetros. 
Nesse método passa-se os parâmetros via query string, na url.
Os parâmetros não devem causar efeitos colaterais no servidor por assim dizer.

*POST*
A passagem de parâmetros vai junto do corpo do requisição.
Isso auxília a enviar parâmetros maiores.
Submeter um formulário.
Uma requisição desse tipo, pode gerar alteração no servidor.

Quais dos métodos é o mais seguro. Get ou Post?
Nenhum dos dois, podemos dizer, o POST encapsula um pouco mais as informações, sendo que nem o GET ou POST são mais seguros.



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
        HttpServletResponse rp) throws ServletExceptio, IOException{
            //....
            RequestDispatcher view = rq.getRequestDispatcher("view.jsp");
            view.forward(rq,rp);
        }
}
```
Assim é possível passar o controle para uma página jsp, e a mesma terminará o processamento.






# Servlets e Java

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

Adicionar as dependências ao POM.xml:
```xml
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>2.0.0</version>
</dependency>


<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>2.0.0</version>
</dependency>
```

[Html Basics](https://www3.ntu.edu.sg/home/ehchua/programming/webprogramming/HTTP_Basics.html)
