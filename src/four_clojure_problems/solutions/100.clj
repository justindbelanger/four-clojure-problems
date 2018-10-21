(ns four-clojure-problems.solutions.100)

(defn lcm-for-two [c d]
  (letfn [(gcd [a b]
            (if (= b 0)
              a
              (recur b (rem a b))))]
    (/ (* c d)
       (gcd c d))))

(defn lcm-for-many [& args]
  (reduce lcm-for-two args))

(def lcm (fn [& args]
           (letfn [(gcd [a b]
                     (if (= b 0)
                       a
                       (recur b (rem a b))))
                   (lcm-for-two [a b]
                     (/ (* a b)
                        (gcd a b)))]
             (reduce lcm-for-two args))))

(def tests [{:input [2 3]
             :result 6}
            {:input [5 3 7]
             :result 105}
            {:input [1/3 2/5]
             :result 2}
            {:input [3/4 1/6]
             :result 3/2}
            {:input [7 5/7 2 3/5]
             :result 210}])
