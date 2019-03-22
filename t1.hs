--import Data.Char 
--1
isVowel :: Char -> Bool
isVowel letra = if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') then True else False

--2
addVirgula :: [String] -> [String]
addVirgula lista = map (\i -> i++",") lista

--3
--Não anônima:
addTag :: String -> String
addTag texto = "<li>"++texto++"</li>"

htmlListItems :: [String] -> [String]
htmlListItems lista = map addTag lista

--Anônima
htmlListItems2 :: [String] -> [String]
htmlListItems2 lista = map (\i -> "<li>"++i++"</li>") lista

--4
--Anônima
retiraVogais :: String -> String
retiraVogais palavra = filter (\letra -> if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') then False else True) palavra

--Não anônima
isVogal :: Char -> Bool
isVogal letra = if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') then False else True

retiraVogais2 :: String -> String
retiraVogais2 palavra = filter isVogal palavra

--5
codifica :: String -> String
codifica palavra = map (\c -> if c /= ' ' then '-' else c) palavra

--6
firstName :: String -> String
firstName nome = head (words nome)

--7
--isInt :: String -> Bool
--isNumber USAR ESSA FUNÇÃO 

--8
lastName :: String -> String
lastName nome = last (words nome)

--9
--toLower :: Char -> Char
--toLower c = chr (towlower (ord c))
userName :: String -> String
userName nome = head (head (words nome)) : last (words nome)

--10
encodeName :: String -> String
encodeName palavra = map (\letra -> if letra == 'a' then '4' else if letra == 'e' then '3' else if letra == 'i' then '2' else if letra == 'o' then '1' else if letra == 'u' then '0' else letra) palavra

--11
betterEncodeName :: String -> String
betterEncodeName palavra = map (\letra -> if letra == 'a' then '4' else if letra == 'e' then '3' else if letra == 'i' then '1' else if letra == 'o' then '0' else if letra == 'u' then '0' else letra) palavra --tem que ser 00

--12
laco :: String -> String
laco string = if(length(string)<10) then string++"." else string

acr :: String -> String
acr palavra = if length(palavra)<10 then laco palavra else if length(palavra)==10  then "igual a 10" else if length(palavra)>10 then "maior que 10" else palavra

acrString :: [String] -> [String]
acrString lista = map acr lista
