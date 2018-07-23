(ns four-clojure-problems.solutions.49)

(def split-seq (fn [n s]
                 (loop [i 1 t '() u s]
                   (let [t* (conj t (first u))
                         u* (rest u)]
                     (if (= n i)
                       [(reverse t*) u*]
                       (recur (inc i) t* u*))))))

(def examples [{:input [3 [1 2 3 4 5 6]]
                :result [[1 2 3] [4 5 6]]}
               {:input [1 [:a :b :c :d]]
                :result [[:a] [:b :c :d]]}
               {:input [2 [[1 2] [3 4] [5 6]]]
                :result [[[1 2] [3 4]] [[5 6]]]}])
