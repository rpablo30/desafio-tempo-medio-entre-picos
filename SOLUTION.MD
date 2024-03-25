Solução para o Desafio Tempo Médio Entre Picos
Implementação da Solução
Para resolver o desafio Tempo Médio Entre Picos, optei por implementar a lógica em Java. Minha abordagem consistiu em seguir os seguintes passos:

Identificação dos Picos: Primeiramente, desenvolvi um algoritmo para identificar todos os picos presentes nos dados fornecidos pelo sensor. Utilizei técnicas de processamento de sinais para detectar os pontos máximos locais que satisfaziam os critérios de serem considerados picos verdadeiros.

Filtro dos Picos Verdadeiros: Em seguida, implementei um método para filtrar os picos verdadeiros, descartando aqueles que não atendiam aos critérios definidos para serem considerados picos válidos. Isso garantiu que apenas os picos relevantes fossem considerados no cálculo do tempo médio entre picos.

Apresentação Visual dos Dados: Para facilitar a compreensão dos resultados, desenvolvi uma interface gráfica que exibia o gráfico dos dados do sensor, destacando os picos verdadeiros detectados. Isso permitiu uma visualização clara dos pontos de interesse para o usuário.

Desenvolvimento do Frontend: Em paralelo, trabalhei no desenvolvimento do frontend utilizando Angular. A interface de usuário foi projetada para fornecer uma experiência visual intuitiva, permitindo ao usuário interagir com os dados e compreender facilmente as informações apresentadas.

Cálculo Dinâmico do TMEP: Por fim, implementei um método para calcular dinamicamente o Tempo Médio Entre Picos (TMEP) com base nos picos verdadeiros identificados. Utilizei uma abordagem flexível que permitia ajustar o cálculo de acordo com a quantidade e a distribuição dos picos nos dados do sensor.

Validação da Solução
Para validar a solução, utilizei um conjunto de dados de teste que representavam diferentes cenários de oscilação. Realizei testes exaustivos, verificando se os picos eram corretamente identificados e se o cálculo do TMEP estava de acordo com as expectativas.

Exemplos de Entradas
Aqui estão alguns exemplos de entradas que foram utilizadas para testar a implementação:

Dados simulados de um sensor de oscilação com ruído
Conjuntos de dados reais coletados em ambientes controlados
Dados de teste gerados aleatoriamente para verificar a robustez da solução
Dificuldades Encontradas
Durante o desenvolvimento da solução, enfrentei algumas dificuldades, especialmente na implementação dos algoritmos de detecção e filtragem de picos. Lidar com o ruído nos dados do sensor e garantir a precisão na identificação dos picos foi um desafio significativo.

Além disso, integrar o frontend com o backend e garantir uma comunicação eficiente entre os componentes foi outro ponto que demandou atenção e esforço.

Execução da Solução
Para executar a solução, siga estas etapas:

Compile e execute o backend utilizando o Maven.
Inicie o servidor do frontend e abra a interface de usuário em um navegador web.
Interaja com a interface para visualizar os dados do sensor e calcular o Tempo Médio Entre Picos.

Para acessar o código do backend, visite [este link](  https://github.com/rpablo30/desafio-tempo-medio-entre-picos/tree/master  ).

Para acessar o código do frontend, visite [este link](  https://github.com/rpablo30/desafio-tempo-medio-entre-picos/tree/main/tempo-medio-front ).
