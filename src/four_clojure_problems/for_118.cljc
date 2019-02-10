(ns four-clojure-problems.for-118)

(def remap (fn remap-fn [f ss]
             (lazy-seq (cons (f (first ss))
                             (let [others (rest ss)]
                               (if (not (empty? others))
                                 (remap-fn f others)
                                 '()))))))
