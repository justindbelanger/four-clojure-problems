(ns four-clojure-problems.for-122)

(def parse-integer #?(:clj #(java.lang.Integer/parseInt %)
                      :cljs #(js/parseInt %)))

(def pow #?(:clj #(java.lang.Math/pow %1 %2)
            :cljs #(js/Math.pow %1 %2)))

(def binary-to-decimal
  "Accepts a string representing a binary number. Evaluates to its decimal representation."
  (fn [binary]
    (loop [sum    0
           power  0
           digits (reverse (map (fn [c] (parse-integer (str c)))
                                binary))]
      (if (empty? digits)
        sum
        (recur (+ sum
                  (* (int (pow 2 power))
                     (first digits)))
               (inc power)
               (rest digits))))))
