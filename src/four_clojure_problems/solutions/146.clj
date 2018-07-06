(ns four-clojure-problems.solutions.146)

(def tree-to-table (fn [t]
                     (let [seq-kvs (fn [tree]
                                     (apply concat (for [[k v] tree]
                                                     (for [[l w] v]
                                                       [[k l] w]))))]
                       (reduce (fn [result [k v]]
                                 (assoc result
                                        k
                                        v))
                               {}
                               (seq-kvs t)))))

(def examples [{:input '{a {p 1, q 2}
                        b {m 3, n 4}}
                :result '{[a p] 1, [a q] 2
                         [b m] 3, [b n] 4}}
               {:input '{[1] {a b c d}
                        [2] {q r s t u v w x}}
                :result '{[[1] a] b, [[1] c] d,
                         [[2] q] r, [[2] s] t,
                         [[2] u] v, [[2] w] x}}
               {:input '{m {1 [a b c] 3 nil}}
                :result '{[m 1] [a b c], [m 3] nil}}])
