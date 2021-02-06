# Avaliação Final de API 

Esse projeto foi proposto como atividade do final do segundo semestre do curso de desenvolvimento de sistemas do  **SENAI - São José -SC**, a atividade requeria

 - [x ] Java Poo 															---> valendo 1,0  ponto
 - [ x] MVC																	--->  não seria avaliado
 - [ x] REST																	---> valendo 1,0 ponto
 - [x ] Serviços Web Crud											---> valendo 2,0 pontos
 - [ ] Serviço listar Carros Disponiveis						--->  valendo 1,0 ponto
 - [ ] Serviço calcular Margem de Lucro em 15% 	---> valendo 2,5 pontos
 - [ ] Serviço atualizar lucro total								---> valendo 2,5 pontos

#MVC
-
minha estrutura MVC consiste em 

java>
		
		-br  >-com > -mariani > 
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
# Entidade 
A classe proposta para a atividade foi:

Carro                                                
------------
 - id:int
 - renavan:String
 - Modelo: String
 - Cor:String
 - Ano:int
 - Preco:String
 - Vendido:boolean

Como eu fiz minha classe modelo carro.

Carro
-------

 - id:int
 - renavan:String
 - Modelo: String
 - Modelo: String
 - Cor:String
 - Ano:int
 - Preco:Double
 - Situacao:boolean


#Rotas
-
Minha api usa as seguntes rotas:

 * ADD CARRO > http://localhost:8080/WebLoja/carro
 * DELETAR CARRO > http://localhost:8080/WebLoja/carro/{ID}
 * ATUALIZAR CARRO > http://localhost:8080/WebLoja/carro/{ID}
 * BUSCAR CARRO > http://localhost:8080/WebLoja/carro/{ID}
 * BUSCAR TODOS > http://localhost:8080/WebLoja/carro

#Json
-
No meu projeto o @Consume e @Produces trabalha com o arquivo Json;
[
  {
    "renavan": "rdgs1254",
    "modelo": "gol",
    "montadora": "vw",
    "cor": "branco",
    "ano": 2013,
    "preco": 25255.0,
    "situacao": false
  },
  {
    "renavan": "rdgs1254",
    "modelo": "saveiro",
    "montadora": "vw",
    "cor": "vermelha",
    "ano": 2013,
    "preco": 25255.0,
    "situacao": false
  }
]

#JDBC
-
No meu projeto aproveitei o conhecimento pré adquirido em estudos por conta e  com o professor Gustavo para fazer também a integração com o banco nesta atividade, usando o PostgresSQL

**SQL's**

*CRIAR O BANCO*

 (CREATE DATABASE db_lojacarro WITH OWNER = postgres ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252' TABLESPACE = pg_default CONNECTION LIMIT = -1; );
 
*CRIAR TABELA*

 CREATE TABLE public.carro ( id integer NOT NULL DEFAULT nextval('carro_id_seq'::regclass), renavan character varying COLLATE pg_catalog."default", modelo character varying COLLATE pg_catalog."default", montadora character varying COLLATE pg_catalog."default", cor character varying COLLATE pg_catalog."default", ano integer, preco numeric, situacao boolean, CONSTRAINT carro_pkey PRIMARY KEY (id) ) TABLESPACE pg_default; ALTER TABLE public.carro OWNER to postgres;


**Design Pattern** & Classe ConectionFactory
-
Seguindo esse padrão de conexão com o banco fiz a minha aplicação que em um aplicação mais complexa facilmente posso dar manutenção sem bugar todo o código.
