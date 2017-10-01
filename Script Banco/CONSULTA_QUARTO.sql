SET @dataini = "2017-06-01";
SET @datafim = "2017-06-30";

SELECT * FROM hospedagens WHERE
((@dataini BETWEEN periodo_ini AND periodo_fim) 
OR (@datafim BETWEEN periodo_ini AND periodo_fim));


set @ini = "2017-06-05"; 
set @fim = "2017-06-20"; 

select id_quarto from quartos 
where id_quarto not in (select id_quarto from hospedagens where periodo_ini >= @ini and periodo_fim <= @fim);