---


---

<h1 id="avaliação-final-de-api">Avaliação Final de API</h1>
<p>Esse projeto foi proposto como atividade do final do segundo semestre do curso de desenvolvimento de sistemas do  <strong>SENAI - São José -SC</strong>, a atividade requeria</p>
<ul>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" checked="true" disabled=""> Java Poo 															—&gt; valendo 1,0  ponto</li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" checked="true" disabled=""> MVC																	—&gt;  não seria avaliado</li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" checked="true" disabled=""> REST																	—&gt; valendo 1,0 ponto</li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" checked="true" disabled=""> Serviços Web Crud											—&gt; valendo 2,0 pontos</li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" checked="true" disabled=""> Serviço listar Carros Disponiveis						—&gt;  valendo 1,0 ponto</li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" disabled=""> Serviço calcular Margem de Lucro em 15% 	—&gt; valendo 2,5 pontos</li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" disabled=""> Serviço atualizar lucro total								—&gt; valendo 2,5 pontos<br>
<strong>EXTRAS</strong></li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" disabled=""> JDBC <em>integração com banco de dados</em></li>
<li class="task-list-item"><input type="checkbox" class="task-list-item-checkbox" disabled=""> Design Pattern Connection</li>
</ul>
<h2 id="mvc">#MVC</h2>
<p>minha estrutura MVC consiste em</p>
<p>java&gt;</p>
<pre><code>	-br  &gt;-com &gt; -mariani &gt; 
		   -controle
			   -ControleCarro
		   -aplicacao
			   -ServicoCarro
			   -ApplicationConfig
		   -modelos
			   -Carro
		   -dao
			   -DaoCarro
		   -conexao
			   -ConnectionFactory
		   -utilidades	
			   -ConversorDeDatas																			
</code></pre>
<h1 id="entidade">Entidade</h1>
<p>A classe proposta para a atividade foi:</p>
<h2 id="carro">Carro</h2>
<ul>
<li>id:int</li>
<li>renavan:String</li>
<li>Modelo: String</li>
<li>Cor:String</li>
<li>Ano:int</li>
<li>Preco:String</li>
<li>Vendido:boolean</li>
</ul>
<p>Como eu fiz minha classe modelo carro.</p>
<h2 id="carro-1">Carro</h2>
<ul>
<li>id:int</li>
<li>renavan:String</li>
<li>Modelo: String</li>
<li>Modelo: String</li>
<li>Cor:String</li>
<li>Ano:int</li>
<li>Preco:Double</li>
<li>Situacao:boolean</li>
</ul>
<h2 id="rotas">#Rotas</h2>
<p>Minha api usa as seguntes rotas:</p>
<ul>
<li>ADD CARRO &gt; <a href="http://localhost:8080/WebLoja/carro">http://localhost:8080/WebLoja/carro</a></li>
<li>DELETAR CARRO &gt; <a href="http://localhost:8080/WebLoja/carro/%7BID%7D">http://localhost:8080/WebLoja/carro/{ID}</a></li>
<li>ATUALIZAR CARRO &gt; <a href="http://localhost:8080/WebLoja/carro/%7BID%7D">http://localhost:8080/WebLoja/carro/{ID}</a></li>
<li>BUSCAR CARRO &gt; <a href="http://localhost:8080/WebLoja/carro/%7BID%7D">http://localhost:8080/WebLoja/carro/{ID}</a></li>
<li>BUSCAR TODOS &gt; <a href="http://localhost:8080/WebLoja/carro">http://localhost:8080/WebLoja/carro</a></li>
</ul>
<h2 id="json">#Json</h2>
<p>No meu projeto o @Consume e @Produces trabalha com o arquivo Json;<br>
[<br>
{<br>
“renavan”: “rdgs1254”,<br>
“modelo”: “gol”,<br>
“montadora”: “vw”,<br>
“cor”: “branco”,<br>
“ano”: 2013,<br>
“preco”: 25255.0,<br>
“situacao”: false<br>
},<br>
{<br>
“renavan”: “rdgs1254”,<br>
“modelo”: “saveiro”,<br>
“montadora”: “vw”,<br>
“cor”: “vermelha”,<br>
“ano”: 2013,<br>
“preco”: 25255.0,<br>
“situacao”: false<br>
}<br>
]</p>
<h2 id="jdbc">#JDBC</h2>
<p>No meu projeto aproveitei o conhecimento pré adquirido em estudos por conta e  com o professor Gustavo para fazer também a integração com o banco nesta atividade, usando o PostgresSQL</p>
<p><strong>SQL’s</strong></p>
<p><em>CRIAR O BANCO</em></p>
<p>(CREATE DATABASE db_lojacarro WITH OWNER = postgres ENCODING = ‘UTF8’ LC_COLLATE = ‘Portuguese_Brazil.1252’ LC_CTYPE = ‘Portuguese_Brazil.1252’ TABLESPACE = pg_default CONNECTION LIMIT = -1; );</p>
<p><em>CRIAR TABELA</em></p>
<p>CREATE TABLE public.carro ( id integer NOT NULL DEFAULT nextval(‘carro_id_seq’::regclass), renavan character varying COLLATE pg_catalog.“default”, modelo character varying COLLATE pg_catalog.“default”, montadora character varying COLLATE pg_catalog.“default”, cor character varying COLLATE pg_catalog.“default”, ano integer, preco numeric, situacao boolean, CONSTRAINT carro_pkey PRIMARY KEY (id) ) TABLESPACE pg_default; ALTER TABLE public.carro OWNER to postgres;</p>
<h2 id="design-pattern--classe-conectionfactory"><strong>Design Pattern</strong> &amp; Classe ConectionFactory</h2>
<p>Seguindo esse padrão de conexão com o banco fiz a minha aplicação que em um aplicação mais complexa facilmente posso dar manutenção sem bugar todo o código.</p>

