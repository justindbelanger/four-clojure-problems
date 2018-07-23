(ns four-clojure-problems.solutions.62)

(def reiterate (fn reiterate-fn [f x]
                 (lazy-seq (cons x (reiterate-fn f (f x))))))

(def examples [{:input [#(* 2 %) 1]
                :postprocess [take 5]
                :result [1 2 4 8 16]}
               {:input [inc 0]
                :postprocess [take 100]
                :result (take 100 (range))}
               {:input [#(inc (mod % 3)) 1]
                :postprocess [take 9]
                :result (take 9 (cycle [1 2 3]))}])
