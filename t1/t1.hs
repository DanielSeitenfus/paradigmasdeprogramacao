import Data.Char (isDigit)
import Data.Char (toLower)
--1
isVowel :: Char -> Bool
isVowel letra = if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') then True else False

--2
addComma :: [String] -> [String]
addComma lista = map (\i -> i++",") lista

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

codifica2 :: String -> String
codifica2 frase = codifica frase

--6
firstName :: String -> String
firstName nome = head (words nome)

--7
isDigit :: Char -> Bool
isDigit c = if(c=='0' || c=='1' || c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9') then True else False

isInt :: String -> Bool 
isInt int = all isDigit int

--8
lastName :: String -> String
lastName nome = last (words nome)

--9
--toLower :: Char -> Char
--toLower c = chr (towlower (ord c))
userName :: String -> String
userName nome = map toLower (head (head (words nome)) : last (words nome))

--10
encodeName :: String -> String
encodeName palavra = map (\letra -> if letra == 'a' then '4' else if letra == 'e' then '3' else if letra == 'i' then '2' else if letra == 'o' then '1' else if letra == 'u' then '0' else letra) palavra

--11
subs :: Char -> String
subs c = if (toLower c) == 'a' then "4" else if (toLower c) == 'e' then "3" else if (toLower c) == 'i' then "1" else if (toLower c) == 'o' then "0" else if (toLower c) == 'u' then "00" else [c]

betterEncodeName :: String -> String
betterEncodeName nome = concatMap (\c -> subs c) nome

--12
corrigeString :: [String] -> [String]
corrigeString list = map (\p ->  if (length p) > 10 then (take 10 p) else (take 10 (p ++ ".........."))) list
