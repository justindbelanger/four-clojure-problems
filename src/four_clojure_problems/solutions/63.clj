(ns four-clojure-problems.solutions.63)

(def group (fn [f ss]
             (reduce (fn [m s]
                       (let [fs (f s)
                             v (or (get m fs) [])]
                         (assoc m fs (conj v s))))
                     {}
                     ss)))

(def examples [{:input [#(> % 5) [1 3 6 8]]
                :result {false [1 3], true [6 8]}}
               {:input [#(apply / %) [[1 2] [2 4] [4 6] [3 6]]]
                :result {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}}
               {:input [count [[1] [1 2] [3] [1 2 3] [2 3]]]
                :result {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}}])
