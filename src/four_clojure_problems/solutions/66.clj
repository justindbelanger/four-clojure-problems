(ns four-clojure-problems.solutions.66)

(def gcd (fn [a b]
           (let [mod* (fn [x y]
                        (- a (* b (int (/ a b)))))]
             (if (= b 0)
              a
              (recur b (mod* a b))))))

(def examples [{:input [2 4]
                :result 2}
               {:input [10 5]
                :result 5}
               {:input [5 7]
                :result 1}
               {:input [1023 858]
                :result 33}])
