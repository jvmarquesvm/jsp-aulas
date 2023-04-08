# jsp-aulas

C:\Users\joaovictor>java -version
openjdk version "11" 2018-09-25
OpenJDK Runtime Environment 18.9 (build 11+28)
OpenJDK 64-Bit Server VM 18.9 (build 11+28, mixed mode)

TomCat 7.0.69
Que dê suporte ao Servlet 3.0 em diante

https://tomcat.apache.org/whichversion.html

Eclipse Version: 2021-03 (4.19.0)
Gerenciar o tomcat a partir da IDE

Local do Projeto
C:\Users\joaovictor\Documents\Alura\JavaServletProgramacaoWeb

Estrutura de uma requisição
Correto, seguindo da definição:
protocolo://ip:porta/contexto/recurso

Passo-a-Passo
Baixe o Tomcat, descompacte e configure como servidor na Eclipse IDE.
Crie um novo Dynamic Web Project chamado gerenciador. Não esqueça de gerar o arquivo web.xml
Associe o projeto gerenciador com o Tomcat instalado (Add and Remove project).
Para testar a integração, crie dentro da pasta WebContent o arquivo bem-vindo.html e adicione algum conteúdo dentro do elemento body.
Acesse a página através do endereço http://localhost:8080/gerenciador/bem-vindo.html
Crie a servlet OiMundo no pacote br.com.caelum.gerenciador.servlet e estendendo a classe HttpServlet.
Sobrescreva o método service para que responda com um HTML criado manualmente através de um PrintWriter obtido através da instância de HttpServletResponse recebida pelo método service.

Aprendemos que:
Apache Tomcat ou apenas Tomcat é um servidor web em Java
Tomcat entende o protocolo HTTP e roda por padrão no http://localhost:8080
O projeto Java faz parte da URL, no nosso caso: http://localhost:8080/gerenciador
Uma aplicação web Java pode ter páginas HTML
Uma servlet é um objeto Java que podemos chamar a partir de uma requisição HTTP
Para mapear a URL para uma servlet usamos a anotação @WebServlet
Uma servlet deve estender a classe HttpServlet e sobrescrever um determinado método (por exemplo service)

1) GET foi pensado para acessar algum recurso.
3) POST foi pensado para criar algum recurso.
5) GET gera problemas quando precisamos enviar muitas informações.

doGet / doPost / service - Tipos de métodos para um servlet.

Crie uma servlet chamada NovaEmpresaServlet no pacote br.com.caelum.gerenciador.servlet. Utilize como URL o endereço /novaEmpresa através da anotação WebServlet, estende a classe HttpServlet
Sobrescreve o método service com os dois parâmetros HttpServletRequest e HttpServletResponse
Inicialmente apenas renderize a mensagem "Empresa cadastrada com sucesso!" no corpo da mensagem. Lembre-se de usar o método getWriter da resposta.
Altere a servlet para que através do seu método service ela seja capaz de obter o parâmetro nome da URL http://localhost:8080/gerenciador/novaEmpresa?nome=Alura. Lembre-se que é através do método getParameter de uma HttpServletRequest que conseguimos ter acesso aos parâmetros. Com o valor do parâmetro obtido, adicione-o na resposta no HTML renderizado pelo usuário.
Crie o formNovoEmpresa.html dentro da pasta WebContent. Lembre-se que todos os arquivos dentro desta página são acessíveis pelo usuário (menos o diretório WEB-INF que veremos ainda).

Aprendemos como:
Escrever uma servlet que atende apenas GET ou POST
ler parâmetros da requisição dentro da servlet
criar um formulário HTML usando as tags form e input
enviando os dados pelo formulário através do POST
diferença entre GET e POST

Ainda dentro do pacote br.com.caelum.gerenciador.servlet, crie a classe Empresa, nosso modelo com os atributos id (tipo Integer), nome (String) com seus devidos getters e setters.

Crie a classe Banco para simular um banco de dados em memória. A classe deve ter uma atributo estático para guardar uma lista de empresas (cuidado, use java.util.List), além do método adiciona e getEmpresas.

A ideia é simularmos a inclusão de uma empresa no banco de dados. Sendo o atributo lista estático, estará acessível por qualquer classe da nossa aplicação, inclusive servlets que capazes de listar os dados para o usuário.

Ainda na classe Banco adicione o bloco estático para inicializar duas empresas:
Em NovaEmpresaServlet, no método doPost, crie uma instância de Banco e através do seu método adiciona adicione uma instância de Empresa criada com base no nome da empresa recebida.

Crie a nova servlet ListaEmpresaServlet com url pattern "/listaEmpresas". O objetivo do seu método doGet será devolver como resposta para o usuário a lista de empresas cadastradas. Para ter acesso à lista, basta criar uma instância de Banco e invocar seu método getEmpresas.

Usamos uma servlet para informar o usuário sobre os dados cadastrados, porém podemos fazer isso através de um JSP. Crie o arquivo novaEmpresaCriada.jsp dentro da pasta WebContent. Inicialmente, através de um scriptlet através da sintaxe <% %> crie uma instância de Empresa e, através dessa instância, exiba o nome da empresa usando <% out.println(empresa.getNome()) %>

Você aprendeu que a expressão <% out.println(empresa.getNome()) %> pode ser simplificada através de <%= nomeDaVariavel %>. Simplifique o código anterior.

Em NovaEmpresaServlet, assim que adicionar uma empresa ao banco, faça o despacho da requisição para novaEmpresaCriada.jsp. Em suma, queremos fazer um despacho de uma requisição recebida pela servlet para um JSP. Porém, como JSP precisa obter o nome da empresa, adicione essa informação através do método setAttribute de HttpServletRequest para que essa informação esteja disponível durante a renderização do JSP.

Altere novaEmpresaCriada.jsp para obter o parâmetro adicionada na requisição através de setAttribute em NovaEmpresaServlet. Não esqueça que você precisará realizar um casting para String ao chamar o método request.getAttribute() do objeto implícito request acessível em todo JSP.

Separe melhor as responsabilidades. Crie o jsp listaEmpresas.jsp que terá como responsabilidade exibir a lista de empresas. No JSP voce deve importar as classes List e Empresa:

Pegue o atributo da requisição:

e gere uma lista HTML (elementos <ul> e <li>) com o nome da empresa dinamicamente.

Lembre-se ListaEmpresasServlet deverá adicionar a lista de empresas como atributo da requisição antes de realizar o despacho para o JSP listaEmpresas.jsp.

Nessa aula começamos a separar as responsabilidades entre servlet e JSP e aprendemos:

JSP significa Java Server Pages
JSP é uma página automaticamente processada pelo Tomcat
Para gerar HTML dinamicamente no JSP usamos Scriptlets
Um scriptlet <% %> é um código Java dentro do HTML
Um scriptlet só funciona em uma página JSP
Usamos o RequestDispatcher para chamar um JSP a partir da servlet
Obtemos o RequestDispatcher a partir do HttpServletRequest
Usamos a requisição para colocar ou pegar um atributo (setAttribute(.., ..) ou getAttribute(..))

JSTL(Java Standard Tag Libary )
core - controle de fluxo 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
fmt - internacionalização
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
sql - executar SQL
xml - gerar XML

url antigas a não serem usadas
//nunca use esses uris
http://java.sun.com/jstl/core
http://java.sun.com/jstl/fmt

Modificar o nome do contexto do projeto
	- Geralmente é igual o nome do projeto
Properties do projeto -> Web Project Settings -> Context root
Utilizar o core - c:url

Vimos:
Expression Language (EL) é uma linguagem simples e limitada para imprimir o resultado de uma expressão
EL usa a sintaxe de ${ .. }
JSTL é a biblioteca padrão de tags
JSTL não vem com Tomcat e precisamos copiar um JAR
JSTL define 4 taglibs, as mais importantes são core e fmt
a taglib core serve para controle de fluxo, fmt para formatação
é preciso importar as taglib, core e fmt separadamente:
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
JSTL e EL devem ser usados em conjunto
vimos várias tags do core como c:if, c:forEach e c:url
da fmt vimos a tag fmt:formatDate
JARs ficam na pasta WEB-INF/lib do projeto

Assim que cadastrar uma empresa, faça um forward para "/listaEmpresas". A ideia é exibirmos a listagem sempre logo após uma inclusão. Porém, não esqueça de alterar o método doGet de ListaEmpresaServlet para service, pois como será feito um forward de uma requisição do tipo POST, precisamos trabalhar com um método mais genérico caso contrário não funcionará.

Para evitarmos a repetição de dados com o botão F5, realize um redirect através do método doPost de NovaEmpresaServlet para a Servlet de url pattern "/listaEmpresas". Lembre-se que redirecionamentos são feitos através do método sendRedirect de uma HttpServletResponse.

aprendemos:

Como implementar a remoção de empresas
Como implementar a edição de empresas
Qual atributo correto devemos utilizar para identificação dos elementos (id)
Como definir um input escondido
O que significa CRUD
Com o CRUD completo podemos pensar no deploy da aplicação. Na próxima aula veremos o que é e como fazer! Vamos?


Servlet tem scopo de Singleton
Tomcat tem a característica de estâncias os servlets por Lazy
	- somenter se houver necessidade, se for chamado

Aprendemos que o Tomcat só instancia a servlet quando realmente ocorre uma requisição. Isso é o comportamento padrão que podemos alterar facilmente! A anotação @WebServlet possui um atributo loadOnStartup que muda esse comportamento:

@WebServlet(urlPatterns="/oi", loadOnStartup=1)
public class OiMundoServlet extends HttpServlet {

Tópico de Inversão de Controle- IOC
Servlet ser criado em cada requisição
Gerencie transação com o banco de dados
Verifique regra de segurança
Cache

Para configurar variáveis de ambiente para o java
apontar para uma jkd
JAVA_HOME - C:\Program Files\Oracle\Java\java-se-7u75 (Sem a pasta \bin )
utilizar variável já configurada
JRE_HOME - %JAVA_HOME%\jre









