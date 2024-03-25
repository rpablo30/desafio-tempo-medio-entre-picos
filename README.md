**Desafio Tempo Médio Entre Picos - Backend**

**Este é o backend do projeto desenvolvido em resposta ao desafio Tempo Médio Entre Picos, proposto como parte do processo seletivo da Improvess Informática. O desafio original pode ser encontrado [aqui](link_do_desafio_original).**

**O backend é responsável por processar os dados do sensor, identificar os picos verdadeiros e calcular o tempo médio entre eles.**

**Pré-requisitos**
Antes de iniciar, verifique se você possui os seguintes pré-requisitos:

- **Java Development Kit (JDK)** - Versão 17 ou superior
- **Maven** - Ferramenta de gerenciamento de dependências e construção de projetos para Java

**Configuração**
Certifique-se de ter o **Java Development Kit (JDK) 17** e o **Maven** instalados em sua máquina.

**Instalação e Execução**
Clone este repositório para o seu ambiente local usando o seguinte comando:

```bash
git clone https://github.com/seu-usuario/desafio-tempo-medio-back.git
Navegue até o diretório do projeto:

bash
cd desafio-tempo-medio-back
Execute o seguinte comando para compilar e executar o projeto:

bash
mvn spring-boot:run
O servidor será iniciado na porta padrão 8080.

Endpoints
Após iniciar o servidor, você poderá acessar os seguintes endpoints:

/tempo-medio-entre-picos: Retorna os pontos do gráfico, representando o tempo médio entre picos.
/valores-de-pico: Retorna os valores dos picos detectados.
/todosPicos: Retorna informações detalhadas sobre os picos detectados, incluindo o tempo médio entre eles.
Frontend
Além disso, para visualizar a interface de usuário, é necessário rodar o frontend disponível no seguinte repositório: desafio-tempo-medio-front.

Sobre o Desafio
Este desafio de programação tem dificuldade média e tem como objetivo incentivar o raciocínio lógico e algorítmico. Para mais informações sobre o desafio original, consulte aqui.
