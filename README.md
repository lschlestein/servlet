# Fundamentos de aplicações Web.

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

*GET* (PEGAR)
Acessar um link.
Principal diferença está na forma de passar os parâmetros. 
Nesse método passa-se os parâmetros via query string, na url.
Os parâmetros não devem causar efeitos colaterais no servidor por assim dizer.

*POST* (COLOCAR)
A passagem de parâmetros vai junto do corpo do requisição.
Isso auxília a enviar parâmetros maiores.
Submeter um formulário.
Uma requisição desse tipo, pode gerar alteração no servidor.

Quais dos métodos é o mais seguro. Get ou Post?
Nenhum dos dois, podemos dizer, o POST encapsula um pouco mais as informações, sendo que nem o GET ou POST são mais seguros.
## [Páginas JSP](/paginasJSP.md)
## [Servlets](/servlet.md)

Referências
[Html Basics](https://www3.ntu.edu.sg/home/ehchua/programming/webprogramming/HTTP_Basics.html)
[Java Expression Laguage](https://docs.oracle.com/javaee/6/tutorial/doc/gjddd.html)
