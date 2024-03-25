# Desafio Gastos Recife em 2017 (Front-end)
Crie um App em Angular e Backend Java com SpringBoot, para ler e apresentar dados
sobre os gastos do Recife

datasource http://dados.recife.pe.gov.br/dataset/despesas-orcamentarias/resource/d4d8a7f0-d4be-4397-b950-f0c991438111

## Detalhes do desafio
  - O sistema deve ter três visualizações:
    -  Mostrando as despesas totais em cada mês
    -  Mostrando as despesas totais agrupadas por categoria
    -  Mostrar de onde vem o dinheiro agrupado por fonte
  - Também escolha uma das seguintes opções para implementar:
    - Possibilitar a edição e persistência dos dados.
    - Unificar as três visualizações em uma única tela (SPA - Single Page Application)

## Inicializando o Projeto

Este projeto foi feito utilizando o [Angular CLI](https://github.com/angular/angular-cli) versão 16.0.2.

Para rodar corretamente o sistema, será necessário instalar as dependencias do Angular para desenvolvimento local [Como configurar o ambiente Angular](https://angular.io/guide/setup-local).

Para carregar corretamente as informações do front, será necessário ainda, configurar o sistema de [Back-end](https://github.com/Allanfd12/gastos-recife-back).

Rode o comando `npm install` para baixar as bibliotecas do sistema

Para inicializar o servidor de dev utilize o comando `ng serve` no terminal. A aplicação ira criar por padrão um link em  `http://localhost:4200/`,
todas as alterações feitas serão refletidas automaticamente no site apos salvas

## Imagens do Sistema

![image](https://github.com/Allanfd12/gastos-recife-front/assets/75325265/895aea04-c171-4c2d-8f2d-713afa9aa891)
![image](https://github.com/Allanfd12/gastos-recife-front/assets/75325265/d9a87352-52c6-410a-b246-113326da3aeb)

