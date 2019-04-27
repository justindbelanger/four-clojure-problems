(ns four-clojure-problems.for-95-test
  (:require [four-clojure-problems.for-95 :as sut]
            #?(:clj [clojure.test :refer [are deftest is testing]]
               :cljs [cljs.test :refer-macros [are testing deftest is]])))

(deftest is-binary-tree-tests
  (are [input expected] (= (sut/is-binary-tree? input) expected)
    '(:a (:b nil nil) nil) true
    '(:a (:b nil nil)) false
    [1 nil [2 [3 nil nil] [4 nil nil]]] true
    [1 [2 nil nil] [3 nil nil] [4 nil nil]] false
    [1 [2 [3 [4 nil nil] nil] nil] nil] true
    [1 [2 [3 [4 false nil] nil] nil] nil] false
    '(:a nil ()) false))
