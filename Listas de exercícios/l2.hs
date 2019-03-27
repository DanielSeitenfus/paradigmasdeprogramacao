--1
add10toall :: [Int] -> [Int]
add10toall lista = [x+10 | x <- lista]

--2
multN :: Int -> [Int] -> [Int]
multN num lista = [x*num | x <- lista]

--3
applyExpr :: [Int] -> [Int]
applyExpr lista = [x*3+2 | x <- lista]

--4
addSuffix :: String -> [String] -> [String]
addSuffix sufixo lista = [x++sufixo | x <- lista]

--5
selectgt5 :: [Int] -> [Int]
selectgt5 lista = [x | x <- lista, x>5]

--6
sumOdds :: [Int] -> Int
sumOdds lista = sum [x | x <- lista, mod x 2 /= 0]

--7
selectExpr :: [Int] -> [Int]
selectExpr lista = [x | x <- lista, x>20, x<50, mod x 2 == 0]

--8
countShorts :: [String] -> Int
countShorts lista = length [x | x <- lista, length(x)<5]

--9
calcExpr :: [Float] -> [Float]
calcExpr lista = [x^2/2 | x <- lista, (x^2/2)>10]

calcExpr2 :: [Float] -> [Float]
calcExpr2 lista = filter (\i -> i>10) [x^2/2 | x <- lista]

--10
trSpaces :: String -> String
trSpaces string = [if x==' ' then '-' else x | x <- string]

--12
selectSnd :: [(Int,Int)] -> [Int]
selectSnd tupla = [snd(x) | x <- tupla]

--13
dotProd :: [Int] -> [Int] -> Int
dotProd lista1 lista2 = sum [fst(x)*snd(x) | x <- zip lista1 lista2]

--14
--genRects :: Int -> (Int,Int) -> [(Float,Float,Float,Float)]
--genRects qt tuplaInicio =

--fatorial n = aux n 1
--where aux n res
--            | n > 1     = aux (n - 1) (res * n)
--            | otherwise = res 

