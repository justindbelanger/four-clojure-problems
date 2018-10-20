(ns four-clojure-problems.solutions.33)

(def replicate-seq (fn [ss n]
                     (mapcat (fn [s]
                               (repeat n
                                       s))
                             ss)))

(def tests [{:input [[1 2 3] 2]
             :result '(1 1 2 2 3 3)}
            {:input [[:a :b] 4]
             :result '(:a :a :a :a :b :b :b :b)}])
