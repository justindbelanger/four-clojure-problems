(ns four-clojure-problems.solutions.166)

(fn [keys values]
  (let [resultMap {}]
    (loop [[theKeys theValues theMap] [keys values resultMap]]
      (if (or (empty? theKeys) (empty? theValues)) 
        theMap 
        (recur [(rest theKeys) (rest theValues) (assoc theMap (first theKeys) (first theValues))])
      )
    )
  )
)
