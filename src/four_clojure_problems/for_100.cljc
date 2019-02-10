(ns four-clojure-problems.for-100)

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
