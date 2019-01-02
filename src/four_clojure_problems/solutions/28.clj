(ns four-clojure-problems.solutions.28
  (:require [clojure.test :refer [deftest is]]))

(def pancake (fn pancake-fn [ss]
               (if (and (sequential? ss) (not (string? ss)))
                 (lazy-seq (reduce (fn [pancaked s]
                                     (concat pancaked (pancake-fn s)))
                                   (list)
                                   ss))
                 (list ss))))

(deftest pancake-tests
  (is (= (pancake '((1 2) 3 [4 [5 6]]))
         '(1 2 3 4 5 6)))
  (is (= (pancake ["a" ["b"] "c"])
         '("a" "b" "c")))
  (is (= (pancake '((((:a)))))
         '(:a))))
