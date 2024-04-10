## Lojinha WEB Automação
Esse é um repositorio que contém a automação de alguns testes WEB de um software denominado Lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto

## Tecnologias Usadas

- Java
  https://www.oracle.com/br/java/technologies/downloads/
- JUnit
  [Maven Repository: org.junit.jupiter » junit-jupiter-engine » 5.10.2 (mvnrepository.com)](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.10.2)
- Selennium
  https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.19.1
- WebDrive
  https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/?form=MA13LH#downloads
- Maven
  [Maven – Welcome to Apache Maven](https://maven.apache.org/)

## Testes Automatizados
- Testes para validar as partições de equivalencia relacionadas ao valor do produto na Lojinha, que estão veinculadas diretamente a regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.
- Validar que a aplicação não cadastra valores que sejam superiores ao maximo ou inferior ao menor citados acima.
- Esse teste Valida como um Usuario iria se comportar perante a aplicação, sendo um Teste End-2-End


## Notas Gerais
- Sempre utilizamos as anotações Before Each para que todos os cenarios nao precisem passar essas variaveis todas as vezes, sendo assim reduzindo codigo.
- E utilizamos as anotações After Each para evitar redundancia e reduzir o uso de codigo
- A versão do WebDrive foi a do navegador da Microsoft o EDGE
- Usamos CssSelector para selecionar botões ou caixas dentro da pagina WEB
- E utilizamos XPATH para diferenciar um botão do outro para que o teste automatizado nao falhasse
- Armazenamos os comandos de Selecionar o espaço e Clickar com PageObjects
- Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes.
- Selennium + WebDrive para "Dirigir" os testes 