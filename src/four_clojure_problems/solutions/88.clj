(ns four-clojure-problems.solutions.88)

(def symmetric-difference (fn [a b]
                            (reduce
                             (fn [a* bi]
                               (let [applied-to-pair (fn [f] (apply f [a* bi]))]
                                 (if (applied-to-pair contains?)
                                   (applied-to-pair disj)
                                   (applied-to-pair conj))))
                             a
                             b)))
