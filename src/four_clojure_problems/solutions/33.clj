(ns four-clojure-problems.solutions.33)

(def replicate-seq (fn [ss n]
                     (->> ss
                          (map (fn [s] (repeat n s)))
                          (apply concat))))

(def examples [{:input [[1 2 3] 2]
                :results '(1 1 2 2 3 3)}
               {:input [[:a :b] 4]
                :results '(:a :a :a :a :b :b :b :b)}])
