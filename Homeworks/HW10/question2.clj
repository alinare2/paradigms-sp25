;;taxation namespace
(ns taxation)
;;teax function where it takes a percentage and multiplies the amount by rate
(defn tax [amt percentRate]
  (let [rate (/ percentRate 100)] (double (* amt rate))))

;;new namespace application
(ns application)
;;importing taxation namespace
(use 'taxation)
;;runing tax function from taxation namespace.
(println (taxation/tax 117 7))