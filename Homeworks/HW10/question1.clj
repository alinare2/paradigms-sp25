;;get first comand line arg and cast to int
(def arg (Integer/parseInt (first *command-line-args*)))

;;define a function to square numbers
(defn squareNum [num] 
  (* num num))

;;map the range from 1 to arg(inclusive) to the squares. Save to var Squares
(def Squares (map squareNum (range 1 (+ arg 1))))

;;for each item in Squares println 
(doseq [square Squares](println square))

;;define the sum by reducing the squares with adition
(def sum (reduce + Squares))
(println "Sum: " sum)