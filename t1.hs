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

