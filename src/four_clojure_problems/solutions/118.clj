(ns four-clojure-problems.solutions.118)

(def remap (fn remap-fn [f ss]
             (lazy-seq (cons (f (first ss))
                             (let [others (rest ss)]
                               (if (not (empty? others))
                                 (remap-fn f others)
                                 '()))))))

(def examples [{:result [3 4 5 6 7]
                :input [inc [2 3 4 5 6]]}
               {:result (repeat 10 nil)
                :input [(fn [_] nil) (range 10)]}
               {:result [1000000 1000001]
                :input (fn [f]
                         (->> (f inc (range))
                              (drop (dec 1000000))
                              (take 2)))}])
