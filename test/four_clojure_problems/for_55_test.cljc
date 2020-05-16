(ns four-clojure-problems.for-55-test
  (:require [clojure.test :refer [deftest testing is]]
            [four-clojure-problems.for-55 :as sut]))

(deftest count-occurrences-test
  (is (= {1 4, 2 2, 3 1} (sut/count-occurrences [1 1 2 3 2 1 1])))
  (is (= {:a 2, :b 3} (sut/count-occurrences [:b :a :b :a :b])))
  (is (= {[1 2] 1, [1 3] 2} (sut/count-occurrences '([1 2] [1 3] [1 3])))))
