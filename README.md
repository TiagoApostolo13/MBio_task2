#Testes Selenium com Maven

Este projeto contém testes automatizados usando Selenium WebDriver e é configurado para ser executado com o Maven.

##Pré-requisitos

Antes de executar os testes, certifique-se de ter o seguinte instalado em sua máquina:

- Java Development Kit (JDK) 8 ou superior
- Maven
- Chrome WebDriver (ou outro WebDriver compatível com o seu navegador)

##Configuração do WebDriver

Certifique-se de ter o WebDriver adequado para o seu navegador instalado e configurado corretamente. Para o Chrome, você pode baixar o WebDriver mais recente em Chrome WebDriver Downloads.

##Executando os testes

Para executar os testes, siga estes passos:

1. Clone este repositório em sua máquina local:

git clone https://github.com/seu-usuario/nome-do-repositorio.git

2. Navegue até o diretório do projeto:

cd nome-do-repositorio

3. Execute os testes com o seguinte comando Maven, especificando o navegador desejado (neste exemplo, estamos usando o Chrome):

mvn clean test -Dbrowser=chrome

Isso irá limpar os resultados de testes anteriores, compilar o código e executar os testes automatizados no navegador Chrome.

Personalização

Você pode personalizar o navegador e outras configurações de teste editando o arquivo pom.xml e o código-fonte do teste conforme necessário.

Suporte

Se você encontrar problemas ou tiver dúvidas sobre este projeto, sinta-se à vontade para abrir uma issue aqui no GitHub.