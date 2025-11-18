# 📚 Apresentação BIM2 — 2025B  
---

## 📖 Respondendo exercicios

### 1 Considerando o código acima, qual das linhas de código abaixo instancia um objeto da classe SharedObjectExample?
a)SharedObjectExample e = new SharedObjectExample();

b)SharedObjectExample e = new SharedObjectExample(10);

A resposta correta é b, pois o construtor exige um valor inteiro.

### 2 Suponha que existam várias threads acessando instâncias da classe SharedObjectExample. Qual das afirmações abaixo é correta a respeito do compartilhamento de objetos da classe SharedObjectExample?
a)Objetos da classe SharedObjectExample são sempre compartilhados entre threads.

b)O compartilhamento de objetos da classe SharedObjectExample é definido por quem usa a classe.

c)Objetos da classe SharedObjectExample não podem ser compartilhados porque são privados.

d)Objetos da classe SharedObjectExample são automaticamente synchronized, tornando-os thread-safe.

A resposta correta é a b, o compartilhamento dos objetos será definido por quem usa a classe, logo veremos duas formas de compartilhamento de objetos entre threads.

## 📖 Compartilhamento de objetos entre threads

### 🔹Passando referência (local)
Passando a referência desse objeto para cada thread, todas as threads utilizam exatamente a mesma instância.
Isso significa que qualquer alteração feita por uma thread será vista pelas outras, porque todas compartilham o mesmo estado interno do objeto. Endereço de memória da variável original é passado para a função ou thread. Alterações feitas dentro da thread afetam a variável original, pois ambas acessam o mesmo local de memória. Porém, isso também cria riscos de condições de corrida, então normalmente é necessário usar mecanismos de sincronização. 


Exemplo (site:Chronicles of a Pragmatic Programmer):

Você dá ao seu amigo o endereço da biblioteca onde seu livro está. Com esse endereço, seu amigo pode ir até lá e ler o mesmo livro. Se ele fizer anotações no livro da biblioteca, essas mudanças serão vistas por qualquer pessoa que ler o livro depois.

### 🔹Acessando atributo static em uma classe (global)

 Um atributo static pertence à classe, não às instâncias. Ou seja, todas as threads acessam esse mesmo valor automaticamente, sem precisar receber referência a nada.  Uma cópia dos dados originais é criada e enviada para a função ou thread, as alterações nessa cópia dentro da thread não afetam a variável original. Isso simplifica o acesso, mas deixa o estado global, o que reduz encapsulamento e pode dificultar a manutenção. Assim como no caso anterior, também é preciso sincronização para evitar problemas de concorrência.

 Exemplo (site:Chronicles of a Pragmatic Programmer):

 Você faz anotações diretamente no seu livro e envia uma cópia dessas páginas para o seu amigo. Seu amigo pode ler as anotações, mas se ele fizer alterações, elas estarão apenas na cópia dele. Seu livro original permanece inalterado.

### 🔹Qual seria o melhor?
 Pelo que entendi, a melhor escolha seria passar referência ao objeto compartilhado. Essa abordagem mantém mais organizado, com menos dependências globais, e facilita controlar onde e como o estado é usado.
Usar static deve ser reservado para situações em que o valor realmente precisa ser global para toda a aplicação, o que é menos comum quando se trata de sincronização entre threads.

---

## 🖥️ Videos com execução

---

### 🔹Referencia


https://github.com/user-attachments/assets/340d745c-afa0-42a3-b7c4-a5d84293e775




---

### 🔹 Static


https://github.com/user-attachments/assets/8c2ef78b-cf4d-45f2-a121-140cf1f4e834





---

## FONTES:

https://pt.stackoverflow.com/questions/138442/concorrência-e-compartilhamento-de-memória-entre-threads

https://www.quora.com/How-do-I-share-an-object-between-threads-in-Java

https://www.devmedia.com.br/threads-paralelizando-tarefas-com-os-diferentes-recursos-do-java/34309

https://www.devmedia.com.br/modificadores-de-acesso-do-java/27065

https://chroniclesofapragmaticprogrammer.substack.com/p/java-conceitos

https://liascript.github.io/course/?https://raw.githubusercontent.com/AndreaInfUFSM/elc117-2025b/main/classes/28/README.md#17
---

