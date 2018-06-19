(ns four-clojure-problems.solutions.166)

(def tests [{:input [<
                     5
                     1]
             :result :gt}
            {:input [(fn [x y] (< (count x)
                                  (count y)))
                     "pear"
                     "plum"]
             :result :eq}
            {:input [(fn [x y] (< (mod x 5)
                                  (mod y 5)))
                     21
                     3]
             :result :lt}
            {:input [>
                     0
                     2]
             :result :gt}])

(def comparison (fn [lt x y]
                  (cond
                    (lt x y) :lt
                    (lt y x) :gt
                    :else :eq)))

(defn test-comparison
  [{:keys [input result]}]
  (= (apply comparison
            input)
     result))
