(ns four-clojure-problems.for-143-test
  (:require [clojure.test :refer [deftest is]]
            [four-clojure-problems.for-143 :as sut]))

(deftest dot-product-test
  (is (= 0 (sut/solution [0 1 0] [1 0 0])))
  (is (= 3 (sut/solution [1 1 1] [1 1 1])))
  (is (= 32 (sut/solution [1 2 3] [4 5 6])))
  (is (= 256 (sut/solution [2 5 6] [100 10 1]))))
