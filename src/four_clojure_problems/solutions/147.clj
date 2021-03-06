(ns four-clojure-problems.solutions.147
  (:require [clojure.test :refer [deftest is]]))

(def sum-as-pairs (fn sum-fn [[i & others]]
                    (let [j (first others)]
                      (if (and i j)
                        (let [summed (+' i j)
                              more (if others
                                     (lazy-seq (sum-fn others))
                                     '())]
                          (cons summed more))
                        '()))))

(defn pascal-trapezoid [row]
  (iterate (fn [current]
             (vec (concat (list (first current))
                          (sum-as-pairs current)
                          (list (last current)))))
           row))

(deftest pascal-trapezoid-tests
  (is (= (second (pascal-trapezoid [2 3 2]))
         [2 5 5 2]))
  (is (= (take 5 (pascal-trapezoid [1]))
         [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]]))
  (is (= (take 2 (pascal-trapezoid [3 1 2]))
         [[3 1 2] [3 4 3 2]]))
  (is (= (take 100 (pascal-trapezoid [2 4 2])))
      (rest (take 101 (pascal-trapezoid [2 2])))))

(def solution (fn pt [row]
              (let [sum-as-pairs (fn sum-fn [[i & others]]
                                    (let [j (first others)]
                                      (if (and i j)
                                        (let [summed (+' i j)
                                              more (if others
                                                    (lazy-seq (sum-fn others))
                                                    '())]
                                          (cons summed more))
                                        '())))
                    next-row (vec (concat (list (first row))
                                          (sum-as-pairs row)
                                          (list (last row))))]
                (lazy-seq (cons row
                                (pt next-row))))))
