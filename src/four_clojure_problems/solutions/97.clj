(ns four-clojure-problems.solutions.97
  (:require [clojure.test :refer [deftest is]]
            [four-clojure-problems.solutions.147 :as drug]))

(def pascal-triangle (fn pt [n]
                       (nth (drug/pascal-trapezoid [1]) (dec n))))

(def solution (fn pt [n]
                (let [sum-fn (fn sum-fn [[i & others]]
                               (let [j (first others)]
                                 (if (and i j)
                                   (let [summed (+ i j)
                                         more (if others
                                                (lazy-seq (sum-fn others))
                                                '())]
                                     (cons summed more))
                                   '())))]
                  (if (= 1 n)
                    '(1)
                    (concat [1]
                            (sum-fn (pt (- n 1)))
                            [1])))))

(deftest pascal-triangle-tests
  (is (= (pascal-triangle 1)
         [1]))
  (is (= (map pascal-triangle (range 1 6))
         [     [1]
          [1 1]
          [1 2 1]
          [1 3 3 1]
          [1 4 6 4 1]]))
  (is (= (pascal-triangle 11)
         [1 10 45 120 210 252 210 120 45 10 1])))
