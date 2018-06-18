(def binary-to-decimal
  "Accepts a string representing a binary number. Evaluates to its decimal representation."
  (fn [binary]
    (loop [sum 0
           power 0
           digits (reverse (map (fn [c] (java.lang.Integer/parseInt (str c)))
                                binary))]
      (if (empty? digits)
        sum
        (recur (+ sum
                  (* (int (java.lang.Math/pow 2
                                              power))
                     (first digits)))
               (inc power)
               (rest digits))))))
