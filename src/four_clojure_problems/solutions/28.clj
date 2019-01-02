(ns four-clojure-problems.solutions.28
  (:require [clojure.test :refer [deftest is]]))

(def pancake (fn pancake-fn [ss]
               (if (empty? ss)
                 ss
                 (let [s (first ss)
                       pancaked (if (or (string? s) (not (sequential? s)))
                                  (list s)
                                  (pancake-fn s))]
                   (concat pancaked (lazy-seq (pancake-fn (rest ss))))))))

(deftest pancake-tests
  (is (= (pancake '((1 2) 3 [4 [5 6]]))
         '(1 2 3 4 5 6)))
  (is (= (pancake ["a" ["b"] "c"])
         '("a" "b" "c")))
  (is (= (pancake '((((:a)))))
         '(:a))))
