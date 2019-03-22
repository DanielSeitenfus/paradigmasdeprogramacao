import Data.Char 
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
userName nome = towlower (head (head (words nome)) : last (words nome))
