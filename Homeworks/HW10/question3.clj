; Imports the clojure.string namespace as 'str' alias
 (require '[clojure.string :as str])

;;reading in temperatures.txt
(def filepath "temperatures.txt")
(def rows (str/split (slurp filepath) #"\n"))

;;function to convert temperature to celcius
(defn toCelsius[tempF](*(- (parse-double tempF) 32) (/ 5 9)))

;;convert temperatures to celcius
(def rows (map toCelsius rows))

;;get average
(def sum (reduce + rows))
(def avgTemp (/ sum (count rows)))

;;get max and min
(def maxTemp (reduce max rows))
(def minTemp (reduce min rows))

(println "min=" minTemp)
(println "max=" maxTemp)
(println "avg=" avgTemp)