(ns four-clojure-problems.solutions
  (:refer-clojure :exclude [test]))

(defn test
  [f {:keys [input result]}]
  (-> f
      (apply input)
      (= result)))
