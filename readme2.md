Eclipse IDE for Enterprise Java and Web Developers - 
Version: 2021-03 (4.19.0)

Tomcat 7.0
Java C:\Program Files\Oracle\Java\java-se-7u75


Outra abordagem de mapeamento de Controlador é:
O nosso controlador foi mapeado para a URL /entrada. Ou seja, qualquer link ou formulário sempre usará /entrada e, para saber a ação concreta, devemos enviar o parâmetro acao, por exemplo:

http://localhost:8080/gerenciador/entrada?acao=ListaEmpresas
Nossa abordagem é funcional, mas vários controladores do mercado usam uma outra abordagem para definir o nome da ação. A ideia é que nosso controlador receba qualquer requisição para qualquer URL, através do mapeamento /:

@WebServlet("/")
public class UnicaEntradaServlet extends HttpServlet {
Assim, podemos usar o nome da URL para definir a ação. Por exemplo, um mapeamento possível seria:

/listaEmpresas
/novaEmpresaForm
/removeEmpresa

Repare que não precisamos mais do parâmetro acao, apenas a URL. Isso significa que devemos analisar a URL no nosso controlador para saber qual ação deveria ser chamada.

O método getRequestURI(), do objeto HttpServletRequest, devolve exatamente essa informação:

String url = request.getRequestURI();
No curso, continuaremos com o mapeamento /entrada do nosso controlador e o uso do parâmetro acao!

MVC significa Model-View-Controller
MVC divide a aplicação em 3 camadas lógicas
Cada camada tem a sua responsabilidade
O controlador central e as ações fazem parte da camada Controller, que define o fluxo da aplicação
Os JSPs fazem parte da camada View, que define a interface
As classes do modelo fazem parte da camada Model, que encapsula as regras de negócio
MVC facilita a manutenção e evolução da aplicação
Os JSPs devem ficar "escondidos" na pasta WEB-INF, pois dependem da ação

A representar o usuário através de uma classe Usuario
A criar um formulário de login
A criar a ação para chamar o formulário
A criar a ação verificar o login e a senha

  <role rolename="ADMINISTRADOR"/>
  <role rolename="USUARIO"/>
  <user username="admin" password="123" roles="ADMINISTRADOR, USUARIO"/>
  <user username="user" password="123" roles="USUARIO"/>

Tudo isso foi definido dentro de um outro padrão, chamado Java Autenthication and Authorization Service (JAAS - API padrão do Java para segurança), no entanto, ele não é tão utilizado em aplicações web Java.

Aprendemos que:

Por padrão, o navegador não envia nenhuma identificação sobre o usuário
Quando o Tomcat recebe uma nova requisição (sem identificação), gerará um ID
O ID fica salvo no cookie de nome JSessionID
O ID é um hash (número aleatório)
O cookie é anexado à resposta HTTP
O navegador reenvia o cookie automaticamente nas próximas requisições
O Tomcat gera, além do ID, um objeto chamado HttpSession
A vida do objeto HttpSession fica atrelado ao ID
Para ter acesso à HttpSession, basta chamar request.getSession()
Usamos a HttpSession para guardar dados sobre o usuário (login, permissões, carrinho de compra)
A HttpSession tem um ciclo de vida e será automaticamente invalidada
Com esse conhecimento, conseguimos proteger a nossa aplicação e criar um login, logout e autorizar o acesso.

Aprendemos que:

Um Filter e Servlet são bem parecidos
Comparado com Servlet, o Filter tem o poder de parar o fluxo
Para escrever um filtro, devemos implementar a interface javax.servlet.Filter
Para mapear o filtro, usamos a anotação @WebFilter ou o web.xml
Vários filtros podem funcionar numa cadeia (um chama o próximo, mas todos são independentes)
Para definir a ordem de execução, devemos mapear os filtros no web.xml
Um filtro recebe como parâmetro, do método doFilter, um ServletRequest e um ServletResponse
Ambos, ServletRequest e ServletResponse, são interfaces mais genéricas do que HttpServletRequest e HttpServletResponse
Para chamar o próximo filtro na cadeia, usamos o objeto FilterChain
Na próxima aula, falaremos sobre Web Services!! Ficou curioso? Então vamos continuar!

erro
SEVERE: Failed to trigger creation of the GC Daemon thread during Tomcat start to prevent possible memory leaks. This is expected on non-Sun JVMs.
java.lang.ClassNotFoundException: sun.misc.GC
classe não existe no java 10

Nesta aula, focamos no mundo de web service e introduzimos esse tópico extenso. Aprendemos:

Que um web service usa HTML, JSON ou XML como retorno
Que um web service oferece alguma funcionalidade para seu cliente
Que um web service é útil quando precisa oferecer uma funcionalidade para cliente diferentes
Que para o web service não importa se o cliente foi escrito em Java, C# ou outra linguagem, pois usamos um protocolo e formatos independentes da plataforma
Como gerar JSON no código Java através de GSON
Como gerar XML no código Java através de XStream
Como escrever um web service através de um HttpServlet
Como criar um cliente HTTP a partir do código Java, usando a biblioteca Apache HttpClient
Como gerar JSON ou XML a partir do cabeçalho Accept da requisição
Novamente, isso foi apenas uma introdução ao tópico importante de Web Services. Você aprenderá ainda em outros cursos como trabalhar com XML e Web Services, usando Spring MVC, JAX-RS ou JAX-WS.

para rodar o jetty 9.4.12
java -jar start.jar -> unsupported java version 
-> foi necessário mudar o java_home para 11


Nesta aula, aprendemos:

A disponibilizar a nossa aplicação no servlet container Jetty
Que Servlet é uma especificação
Que a especificação Servlet faz parte do Java EE/Jakarta EE
Que, ao usar Servlet, programamos independentemente do servidor/container
A diferença entre servlet container e application server
Fechamos a aula com mais um deploy e conhecimento sobre a especificação Servlet. Espero que você tenha gostado do nosso curso e desejo sucesso na sua carreira.



