(ns four-clojure-problems.for-44-test
  (:require [clojure.test :refer [deftest testing is]]
            [four-clojure-problems.for-44 :as sut]))

(deftest rotate-sequence-test
  (is (= (sut/rotate-sequence 2 [1 2 3 4 5])
         '(3 4 5 1 2)))
  (is (= (sut/rotate-sequence -2 [1 2 3 4 5])
         '(4 5 1 2 3)))
  (is (= (sut/rotate-sequence 6 [1 2 3 4 5])
         '(2 3 4 5 1)))
  (is (= (sut/rotate-sequence 1 '(:a :b :c))
         '(:b :c :a)))
  (is (= (sut/rotate-sequence -4 '(:a :b :c))
         '(:c :a :b))))
