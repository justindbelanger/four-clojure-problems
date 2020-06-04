(ns four-clojure-problems.for-56-test
  (:require [clojure.test :refer [deftest testing is]]
            [four-clojure-problems.for-56 :as sut]))

(deftest find-distinct-items-test
  (is (= [1 2 3 4] (sut/find-distinct-items [1 2 1 3 1 2 4])))
  (is (= [:a :b :c] (sut/find-distinct-items [:a :a :b :b :c :c])))
  (is (= '([2 4] [1 2] [1 3]) (sut/find-distinct-items '([2 4] [1 2] [1 3] [1 3]))))
  (is (= (range 50) (sut/find-distinct-items (range 50)))))
