(ns four-clojure-problems.for-56-test
  (:require [clojure.test :refer [deftest testing is]]
            [four-clojure-problems.for-56 :as sut]))

(deftest find-distinct-items-test
  (doseq [f [sut/find-distinct-items-transducer
             sut/find-distinct-items-nested-ifs
             sut/find-distinct-items-cond
             sut/find-distinct-items-sets]]
    (is (= [1 2 3 4] (f [1 2 1 3 1 2 4])))
    (is (= [:a :b :c] (f [:a :a :b :b :c :c])))
    (is (= '([2 4] [1 2] [1 3]) (f '([2 4] [1 2] [1 3] [1 3]))))
    (is (= (range 50) (f (range 50))))))
