(ns four-clojure-problems.for-146-test
  (:require [clojure.test :refer [deftest is]]
            [four-clojure-problems.for-146 :as sut]))

(deftest trees-into-tables-test
  (is (= (sut/tree-to-table '{a {p 1, q 2}
                              b {m 3, n 4}})
         '{[a p] 1, [a q] 2
           [b m] 3, [b n] 4}))
  (is (= (sut/tree-to-table '{[1] {a b c d}
                              [2] {q r s t u v w x}})
         '{[[1] a] b, [[1] c] d,
           [[2] q] r, [[2] s] t,
           [[2] u] v, [[2] w] x}))
  (is (= (sut/tree-to-table '{m {1 [a b c] 3 nil}})
         '{[m 1] [a b c], [m 3] nil})))
