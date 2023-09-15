# Projeto de Exemplo - Arquitetura Hexagonal

## Arquitetura Hexagonal (Hexagonal Architecture)

A Arquitetura Hexagonal (também conhecida como Arquitetura de Portas e Adaptadores) é um padrão arquitetural que visa separar a lógica de negócios da aplicação de detalhes de implementação, como interfaces de usuário e acesso a banco de dados. Ela promove uma estrutura organizada e flexível para o desenvolvimento de aplicativos.

### Modelo Geral das Camadas na Arquitetura Hexagonal:

1. **Camada de Domínio**: Contém as regras de negócios e modelos de domínio. É a parte central da aplicação.

2. **Camada de Aplicação**: Contém casos de uso, serviços e lógica de aplicação que orquestram as operações do sistema.

3. **Camada de Adaptadores de Entrada**: Lida com a entrada de dados e interage com o mundo externo, incluindo interfaces de usuário e serviços externos.

4. **Camada de Adaptadores de Saída**: Lida com a saída de dados e a interação com sistemas externos, como bancos de dados.

## Estrutura de Pacotes e Classes do Projeto:

A estrutura de pacotes e classes do projeto segue os princípios da Arquitetura Hexagonal:

- `br.uece.listadetarefas.Main.java`: Classe principal que inicia a aplicação.

- `br.uece.listadetarefas.adaptadores.entrada.InterfaceUsuario.java`: Classe responsável pela interação com o usuário (GUI).

- `br.uece.listadetarefas.adaptadores.saida.ConexaoJdbcUtil.java`: Classe que lida com a conexão com o banco de dados.

- `br.uece.listadetarefas.adaptadores.saida.RepositorioTarefaAdapter.java`: Classe que implementa um adaptador de saída para o repositório de tarefas.

- `br.uece.listadetarefas.aplicacao.portas.entrada.CasoDeUsoManterTarefa.java`: Classe de caso de uso que define a porta de entrada para a aplicação.

- `br.uece.listadetarefas.aplicacao.service.ServicoManterTarefa.java`: Classe que implementa a lógica de aplicação para o caso de uso "Manter Tarefa".

- `br.uece.listadetarefas.dominio.modelo.Tarefa.java`: Classe que representa o modelo de domínio "Tarefa".

- `br.uece.listadetarefas.dominio.repositorio.portas.saida.RepositorioTarefa.java`: Interface que define a porta de saída para o repositório de tarefas.

## Como Utilizar o Projeto:

1. Clone o repositório para o seu ambiente de desenvolvimento.

2. Importe o projeto em sua IDE de escolha.

3. Execute a classe `Main.java` para iniciar a aplicação.

4. Explore as classes e pacotes para entender a estrutura e os princípios da Arquitetura Hexagonal aplicados neste projeto.

5. Personalize o projeto para atender às necessidades específicas da sua aplicação.

## Como Abrir o Projeto no Eclipse:

1. Abra o Eclipse IDE em seu ambiente de desenvolvimento.

2. Vá para "File" (Arquivo) > "Open Projects from File System..." (Abrir Projetos do Sistema de Arquivos).

3. Na janela "Import Source," clique no botão "Directory..." (Diretório) e navegue até o diretório onde você clonou o repositório do projeto.

4. Selecione o diretório do projeto e clique em "Finish" (Concluir).

5. O Eclipse importará o projeto e o adicionará à sua visão "Package Explorer."

6. Para abrir a classe principal `Main.java`, navegue até `src/br/uece/listadetarefas` no "Package Explorer," clique com o botão direito do mouse na classe `Main.java` e escolha "Run As" > "Java Application" (Executar Como > Aplicação Java).

7. O projeto agora está aberto no Eclipse e pronto para ser explorado e personalizado conforme necessário.

Certifique-se de configurar seu ambiente de desenvolvimento Java corretamente no Eclipse, incluindo a seleção da versão correta do Java e as configurações de compilação, conforme necessário para seu projeto.


## Contribuições:

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas (issues) e enviar solicitações de pull (pull requests) para melhorar este projeto.

## Utilizando o SQLite e DBeaver:

**SQLite**: O SQLite no contexto do Java é um sistema de gerenciamento de banco de dados relacional embutido, amplamente utilizado para aplicativos móveis e de desktop. É leve, não requer um servidor dedicado e é incorporado diretamente nas aplicações Java. Usado para armazenar e gerenciar dados de maneira eficiente, é acessado através de bibliotecas JDBC ou APIs específicas do SQLite para Java, tornando-se uma escolha popular para aplicativos que necessitam de um banco de dados local eficaz.


**DBeaver**: O DBeaver é uma IDE de banco de dados universal que permite gerenciar e interagir com diversos sistemas de gerenciamento de banco de dados.


### Passo a Passo para Usar o SQLite (Armazenamento no arquivo `test.bd`):

1. Faça o download do jar do SQLite em seu sistema a partir do site oficial ou no repositório central do Maven (dá para baixar o jar via link tb)

2. Para adicionar um arquivo JAR ao classpath no Eclipse, acesse as propriedades do projeto, vá para "Java Build Path," na guia "Libraries," adicione o JAR via "Add JARs" ou "Add External JARs."

3. Você pode agora executar consultas SQL no arquivo `test.bd` utilizando o SQLite.

### Como Baixar o DBeaver e Conectar ao Banco de Dados SQLite:

1. Faça o download e a instalação do DBeaver em seu sistema a partir do site oficial.

2. Após a instalação, abra o DBeaver.

3. Crie uma nova conexão ao banco de dados usando as informações do arquivo `test.bd`. Certifique-se de selecionar o driver de banco de dados adequado.

4. Estabeleça a conexão com o banco de dados SQLite e comece a explorar e executar consultas usando o DBeaver.


## Licença:

Este projeto está licenciado sob a [Licença MIT](LICENSE).
