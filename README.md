[![Stories in Ready](https://badge.waffle.io/IFBAEunapolisTOP004/SADE.png?label=ready&title=Ready)](https://waffle.io/IFBAEunapolisTOP004/SADE)
[![Stories in Progress](https://badge.waffle.io/IFBAEunapolisTOP004/SADE.png?label=in%20progress&title=In%20Progress)](https://waffle.io/IFBAEunapolisTOP004/SADE)
[![Travis Status](https://travis-ci.org/IFBAEunapolisTOP004/SADE.svg?branch=master)](https://travis-ci.org/IFBAEunapolisTOP004/SADE)

# SADE

Este repositório será utilizado no desenvolvimento de todo o projeto da disciplina.
https://github.com/IFBAEunapolisTOP004/SADE

## Prova 1

Dentro do pacote *model* foi acrescentado um diagrama para facilitar a compreensão das classes.

Para a primeira prova deverá ser entregue:
- Arquivo de configuração do maven (pom.xml)
- Anotações nas classes do pacote *model* para o JPA;
- Arquivo persistence.xml;
- Telas funcionais para todas as classes do pacote model usando JSF;
- As telas devem apresentar campos para todos os atributos das classes;
- Construir Maneged Beans para todas as telas;
- Para a tela ser considerada pronta ela deve sincronizar os dados dos campos com as atributos do Maneged Bean e exibir uma mensagem de cadastrado com sucesso (mesmo que ainda não esteja cadastrando no banco);

Não deve ser feito *push* sem ter uma tarefa associada.

Ex:

abrir a issue "Criar mapeamento para classe Professor"
realizar a implementação 
fechar a issue 

Só serão considerados os códigos entregues no repositório.

##Cronograma

Por enquanto deixarei ele aqui. No mais resolvi dividir as etapas de desenvolvimento usando a nomenclatura *PACK*, leiam com cuidado e quaisquer dúvidas ou sugestões/questionamentos me mandem um e-mail.

PACK01{

12/02-levantamento de requisitos;

16/02-documento de caso de uso.;
     -diagrama Caso de uso;


17/02:
  - Documento de requisito>>>(Valtecio);
  - Ambiente configurado >>>(Hugo,William Altoé);
	 - NETBEANS 
	 - GLASFISH
	 - MYSQL


18/02-desenvolvimento de layout(Index)>>>(Michael);

19/02-Ambiente com a integração de todos os containeres completo(Hugo,William Altoé e Leonardo).

21/02:
 - Documentação pt-I>>>(Anderson,Luana);
	- Apresentação de ferramenta e amostra do que já foi feito 20/02.
 - Todas as paginas funcionando(CRUD,sem regras de negócio,com primefaces)
	 - professor : (hugo) 17/02
	 - Semestre : (Luana) -17/02
	 - SemestreProfessor : (Jhon) 17/02
	 - Ementa : (Anderson) 17/02
	 - Curso : (Altoé) 17/02
	 - PlanoAula : (Valtecio) 17/02
	 - Disciplina : (William) 18/02
	 - Turma : (leonardo) 18/02
	 - HorarioAula : (Michael) 18/02
	 
25/02-Testes unitários de todas as classes(CRUD sem regras de negocio):

	  - 23/02 - Professor,Semestre,SemestreProfessor;
	  - 24/02 - Ementa,Curso,PlanoAula;
	  - 25/02 - Disciplina,Turma,HorarioAula;

28/02-versão alpha;

}

