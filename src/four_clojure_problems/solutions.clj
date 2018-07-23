(ns four-clojure-problems.solutions)

(defn test
  [f {:keys [input result]}]
  (= (apply f
            input)
     result))
