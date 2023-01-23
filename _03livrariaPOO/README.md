# Exercício Turma 925 Polo Tech Back-End


## Exercício Livraria
O exercício foi proposto pelo professor [Alex Facincani](https://www.linkedin.com/in/alex-facincani-86408259/) como parte do segundo 
módulo da trilha de Back-end oferecida pela [Ada](https://ada.tech/sou-aluno) junto com a [Americanas](https://carreiras.americanas.com/).

O objetivo do exercício era desenvolver um sistema de livraria aplicando os conceitos de Programação Orientada a Objetos exercitados em sala de aula.
<div align="center">

![image](https://user-images.githubusercontent.com/86507721/213899571-1389ae95-be91-47d4-bdaa-059dc6e192f4.png)

</div>


## Solução:

Iniciei a implementação do código criando a nossa classe abstract Produtos que é uma 
[Classe Abstrata](https://www.devmedia.com.br/conceitos-classes-abstratas-programacao-orientada-a-objetos/18812), 
pois ela não será instanciada, mas sim herdada pelas suas subclasse e servirá de modelo para suas filhas, assim essa classe é utilizada para implementar 
o conceito de [Herança](https://www.devmedia.com.br/conceitos-e-exemplos-heranca-programacao-orientada-a-objetos-parte-1/18579), 
com isso foi criado os atributos que todas as subclasses precisam herda.
Para implementar a categoria dos Produtos foi criado um 
[Enum](https://www.devmedia.com.br/tipos-enum-no-java/25729#:~:text=S%C3%A3o%20tipos%20de%20campos%20que,implicitamente%20estendem%20a%20classe%20java.) 
de CategoriaDeProdutos que pode ser definido como uma lista de valores pré-definidos. após definir o enums, partir para a criação das subclasses de Produtos,
sendo elas Album, Brinquedo, Filme, Jogo, Livro: dentro de cada classe foi criado seus atributos de acordo com o requisitos solicitados.

Então continuei a implementação construindo uma 

- Classe TelasUsuario que tem como objetivo a interação com usuário a partir 
do que o usuário for escolhendo, temos os 
[Métodos](https://www.devmedia.com.br/metodos/7348#:~:text=Um%20m%C3%A9todo%20em%20Java%20%C3%A9,definidos%20dentro%20de%20uma%20classe.):

telaMenuInicial(), telaDeCadastro(), telaDeEstoque(), telaBuscarProduto,, telaAlterarProduto, telaRemoveQuantidade(), telaCaixa.

As telas recebem a informação do usuário e conforme a interação acionar os métodos que executam determinada ação que foram definidas dentro da
Classe Funcionalidades, para o objetivo de cadastrar produto foi criado a Classe RecebeDadosDeCadastro ao chamar o método cadastrarProduto
da classe Funcionalidades é feito uma verificação que a partir da escolha do usuário ele chama os métodos  para cadastramento de determinada 
categoria, após receber todas as entradas do usuário é instanciado o produto passando os argumentos para o construtor da categoria, em seguida 
é adicionado o produto dentro de uma [ArrayList](https://www.devmedia.com.br/explorando-a-classe-arraylist-no-java/24298) de Produtos, 
ou seja, todos os produtos ficam guardados na classe Produtos, ao cadastrar um produto é gerado uma id única de acordo com sua categoria, adicionado 
a quantidade no estoque da determinada categoria e preenchido a data atual e horário.

- Classe FormataData possui um método que recebe um new Date() e retorna a data formatada de acordo com o DateFormat.

- Classe ValidacaoDeInputs é fundamental, nela possui o método inputIsvalido() para ser chamada em todos os lugares que deve receber um valor 
númerico e em caso de uma [Exception](https://www.devmedia.com.br/tratando-excecoes-em-java/25514) ela informa para o usuário informar um valor 
válido esperado pelo sistema.

## Classe Funcinalidades 
Além do método cadastrarProduto(), essa classe possui outros métodos:

### isTemProdutoNoEstoque()
Esse método é utilizado no menu inicial para validar se existe algum produto já cadastrado, se for verdadeiro permiti o usuário abrir o estoque, se for 
   falso o estoque não pode ser aberto.
   <div align="center">
  
  ![image](https://user-images.githubusercontent.com/86507721/213933540-cbd5da1f-1294-467c-892e-b1d6dc4ebe15.png)
  
  </div>
  
  
  ### mostraTodoEstoque()
  Esse método verifica se existe produto no estoque através da reutilização do método isTemProdutoNoEstoque() se o retorno for verdadeiro
  ele imprimi todos os produtos cadastrado no estoque indepedente da quantidade através de um for
  
  <div align="center">
  
 
  ![Gravação de tela de 2023-01-22 14-52-27](https://user-images.githubusercontent.com/86507721/213934399-effd9be9-1678-43c3-a9b7-5f02dc5a5496.gif)
  
  </div>
  
  ### quantidadeEstoqueTotal()

  Esse método tem como objetivo retornar a soma de todos os estoques de cada categoria e exibir conforme abaixo

  
  <div align="center">
  
  ![image](https://user-images.githubusercontent.com/86507721/213934909-6393fced-ca51-4ccd-aa50-24f0adc42c90.png)

  
   </div>
   
   ### mostrarEstoquePorCategoria()

Esse método tem como objetivo percorre todo o ArrayList de Produtos e imprimir na tela somente a categoria que foi passada por argumento 
através da condição que verifica se produto instanceof “da categoria solicitada”.
  
  
  <div align="center">
  
  ![Gravação de tela de 2023-01-22 15-17-30](https://user-images.githubusercontent.com/86507721/213935657-fc1dc2da-1d5b-4b8d-b611-fb93bb3f03c2.gif)
  

  </div>
  
  ### buscarProdutoPelaID()
  
Esse método recebe uma id informada pelo usuário e percorre todo ArrayList verificando se a id informada é igual a alguma id existente, para 
essa verificação foi utilizada forEach e dentro equals da classe Object.


<div align="center">
  
 ![Gravação de tela de 2023-01-22 15-40-04 (1)](https://user-images.githubusercontent.com/86507721/213936668-940b2715-12d4-401b-a458-0c07f1a68154.gif)

  
  </div>
  
  ### removeQuantidadeNoEstoqueDoProduto()

Esse método recebe por argumento uma id e quantidade, percorre todo o ArrayList através de um forEach e verifica se a id informada existe e 
se a quantidade informada é menor ou igual que a quantidade do produto em estoque, caso seja a remoção é realizada. 
Não consegue realizar uma remoção de uma quantidade maior do que a disponível em estoque.

<div align="center">
  
  ![Gravação de tela de 2023-01-22 15-53-10](https://user-images.githubusercontent.com/86507721/213937349-ca220981-719a-4362-83ba-46fa45f76f8f.gif)

  
  </div>
  
  
  ### adicionarQuantidadeNoEstoque()

Esse método é utilizado primeiramente no construtor padrão de cada categoria
para que na instancia do produto já seja adicionado a quantidade informada pelo usuário no estoque  da categoria especificada.
Também é utilizado quando temos a necessidade de alterar um produto.

### alterarProdutoCadastrado()

Esse método é acionado pelo método telaAlterarProduto() da classe TelasUsuario que faz busca uma e recebe como retorno um produto e passa por 
argumento na chamada do método a opção que deseja alterar e o produto alterarProdutoCadastrado, de acordo com essas informações retorna para o 
usuário escrever a nova informação.

<div align="center">
  
 
![Gravação de tela de 2023-01-22 16-09-33](https://user-images.githubusercontent.com/86507721/213938095-cf99851f-0b01-4234-a6c6-39ab24ac562f.gif)


</div>


### realizarVenda()

Esse método recebe um o produto que foi pesquisa e a quantidade que deseja realiza a venda verifica se a quantidade é valida e remove a 
quantidade informada do estoque e realiza o calculo para o saldo em caixa.

<div align="center">

![Gravação de tela de 2023-01-22 16-27-48](https://user-images.githubusercontent.com/86507721/213938802-69c26020-eef8-4a8b-9b23-f2e942f1ed9e.gif)

  
 </div>
 
 ### validaQuantidade()
 
 Esse método tem como objetivo receber o input informado e verifica se os valor é maior que 0 e é utilizado em ocasiões onde o usuário 
 precisa adicionar algo no estoque ou remover, então isso impede que o usuário informe um valor negativo ou 0.
 
 <div align="center">
  
  ![Gravação de tela de 2023-01-22 16-32-33](https://user-images.githubusercontent.com/86507721/213938991-ae40e5b1-3c88-415c-9bc7-c418d79a391f.gif)

  
  </div>
	
  
















