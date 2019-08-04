(ns four-clojure-problems.for-108-test
  (:require [four-clojure-problems.for-108 :as for-108]
            #?(:clj [clojure.test :refer [are deftest is testing]]
               :cljs [cljs.test :refer-macros [are testing deftest is]])))

(deftest lazy-search-test
  (is (= (for-108/lazy-search [3 4 5])
         3))
  (is (= (for-108/lazy-search [1 2 3 4 5 6 7] [0.5 3/2 4 19])
         4))
  (is (= (for-108/lazy-search (range) (range 0 100 7/6) [2 3 5 7 11 13])
         7))
  (is (= (for-108/lazy-search (map #(* % % %) (range)) ;; perfect cubes
                              (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
                              (iterate inc 20)) ;; at least as large as 20
         64)))
