{-
1 Crie uma função sumSquares :: Int -> Int -> Int que calcule a soma dos quadrados de dois números x e y.
2 Crie uma função hasEqHeads :: [Int] -> [Int] -> Bool que verifique se 2 listas possuem o mesmo primeiro elemento. Use a função head e o operador lógico == para verificar igualdade.
3 Escreva uma função que receba uma lista de nomes e adicione a string "Super " no início de cada nome. Use o operador ++ para concatenar strings (ou qualquer lista).
4 Crie uma função que receba uma string e retorne o número de espaços nela contidos. Dica: aplique 2 funções consecutivamente.
5 Escreva uma função que, dada uma lista de números, calcule 3*n^2 + 2/n + 1 para cada número n da lista. Dica: defina uma função anônima.
6 Escreva uma função que, dada uma lista de números, selecione somente os que forem negativos.
7 Escreva uma função que receba uma lista de números e retorne somente os que estiverem entre 1 e 100, inclusive. Dica 1: defina uma função anônima. Dica 2: use o operador && para expressar um 'E' lógico.
8 Escreva uma função que, dada uma lista de idades de pessoas no ano atual, retorne uma lista somente com as idades de quem nasceu depois de 1980. Para testar a condição, sua função deverá subtrair a idade do ano atual.
9 Escreva uma função que receba uma lista de números e retorne somente aqueles que forem pares.
10 Crie uma função charFound :: Char -> String -> Bool que verifique se o caracter (primeiro argumento) está contido na string (segundo argumento). Exemplos de uso da função:
> charFound 'a' ""  
False  
> charFound 'a' "uau"  
True  
11 Crie uma função que receba uma lista de nomes e retorne outra lista com somente aqueles nomes que terminarem com a letra 'a'. Dica: conheça o list monster, do autor Miran Lipovača :-)
-}
--1
sumSquares :: Int -> Int -> Int
sumSquares x y = (x*x)+(y*y)

--2
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads l1 l2 = (head l1) == (head l2)

--3
addSuper :: [String] -> [String]
-- addSuper lista = ["Super"++x | x <- lista] --List Comprehension
addSuper lista = map (\i -> "Super"++i) lista --Função anônima

--4
numEspacos :: String -> Int
-- numEspacos palavra = length (filter (\letra -> if letra==' ' then True else False) palavra)  --forma 1
numEspacos palavra = length (filter (==' ') palavra) --forma 2

--5
calculo :: [Int] -> [Float]
calculo lista = map (\n -> 3*(fromIntegral n)^2 + 2/(fromIntegral n) + 1) lista

--5.1
calculo2 :: [Float] -> [Float]
calculo2 lista = map (\n -> 3*n^2 + 2/(n + 1)) lista

--6
selecionaNegativos :: [Float] -> [Float]
--selecionaNegativos lista = filter (\i -> if(i<0) then True else False) lista
selecionaNegativos lista = filter(<0) lista

--7
selecionaIntervalo :: [Float] -> [Float]
selecionaIntervalo lista = filter (\i -> if (i>=1 && i<=100) then True else False) lista

--8
idades :: [Int] -> [Int]
idades lista = filter (\i -> (2019-i>1980)) lista

--9
pares :: [Int] -> [Int]
pares lista = filter (\i -> mod i 2 == 0) lista

--10
charFound :: Char -> String -> Bool
charFound c palavra = filter (==c) palavra /= []

--11
nomes :: [String] -> [String]
nomes lista = filter (\nome -> last nome=='a') lista

--12
