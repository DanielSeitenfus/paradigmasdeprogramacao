import Text.Printf

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)
type Circle    = (Point,Float)


-------------------------------------------------------------------------------
-- Paletas
-------------------------------------------------------------------------------

rgbPalette :: Int -> [(Int,Int,Int)]
rgbPalette n = take n $ cycle [(255,0,0),(0,255,0),(0,0,255)]

greenPalette :: Int -> [(Int,Int,Int)]
greenPalette n = [(0,80+i*10,0) | i <- [0..n] ]


-------------------------------------------------------------------------------
-- Geração de retângulos em suas posições
-------------------------------------------------------------------------------

genRectsInLine :: Int -> [Rect]
genRectsInLine n = [((m*(w+gap),0.0),w,h) | m <- [0..fromIntegral (n-1)]]
  where (w,h) = (50,50)
        gap = 10

--genCircle :: Int -> [Circle]
--genCircle n = [((sin ((pi*m)/n), cos ((pi*m)/n)),10.0) | m <- [1..5], n<-[1..4]]

genCircle :: Int -> [Circle]
genCircle n = [((cos (m*30), sin ((m*30))),10.0) | m <- [0..fromIntegral (n-1)]]


printRect :: [Rect] -> [[Char]]
printRect list =  ["   " ++ svgRect ((x,l*60),w,h) (svgStyle (0,round (51*l+(x/5)+30),0)) | ((x,y),w,h) <- list, l <- [0..fromIntegral(5-1)]]

printCircle :: [Circle] -> [[Char]]
printCircle list =  ["   " ++ svgCircle ((x*100+130,y*100+130),r) (svgStyle (0,255,0)) | ((x,y),r) <- list]

--Minhas funções
genCase1 :: IO ()
genCase1 = putStr (unlines $ printRect (genRectsInLine 10))
--[(X,Y),2.0,2.0]

genCase2 :: IO ()
genCase2 = putStr (unlines $ printCircle (genCircle 12))


-------------------------------------------------------------------------------
-- Strings SVG
-------------------------------------------------------------------------------

-- Gera string representando retângulo SVG 
-- dadas coordenadas e dimensoes do retângulo e uma string com atributos de estilo
svgRect :: Rect -> String -> String 
svgRect ((x,y),w,h) style = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />" x y w h style

svgCircle :: Circle -> String -> String 
svgCircle ((x,y),r) style = 
  printf "<circle cx='%.3f' cy='%.3f' r='%.3f' style='%s'/>" x y r style

-- String inicial do SVG
svgBegin :: Float -> Float -> String
svgBegin w h = printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h 

-- String final do SVG
svgEnd :: String
svgEnd = "</svg>"

-- Gera string com atributos de estilo para uma dada cor
-- Atributo mix-blend-mode permite misturar cores
svgStyle :: (Int,Int,Int) -> String
svgStyle (r,g,b) = printf "fill:rgb(%d,%d,%d); mix-blend-mode: screen;" r g b


-- Gera strings SVG para uma dada lista de figuras e seus atributos de estilo
-- Recebe uma funcao geradora de strings SVG, uma lista de círculos/retângulos e strings de estilo
svgElements :: (a -> String -> String) -> [a] -> [String] -> String
svgElements func elements styles = concat $ zipWith func elements styles

-------------------------------------------------------------------------------
-- Função principal que gera arquivo com imagem SVG
-------------------------------------------------------------------------------

main :: IO ()
main = do
  writeFile "caseX.svg" $ svgstrs
  where svgstrs = svgBegin w h ++ svgfigs ++ svgEnd
        svgfigs = svgElements svgRect rects (map svgStyle palette)
        rects = genRectsInLine nrects
        palette = greenPalette nrects
        nrects = 10
        (w,h) = (1500,500) -- width,height da imagem SVG

