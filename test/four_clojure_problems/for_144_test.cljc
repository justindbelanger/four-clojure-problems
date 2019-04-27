(ns four-clojure-problems.for-144-test
  (:require [four-clojure-problems.for-144 :as sut]
            #?(:clj [clojure.test :refer [deftest is testing]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest osilrate-tests
  (is (= (take 3 (sut/osilrate 3.14 int double))
         '(3.14 3 3.0)))
  (is (= (take 5 (sut/osilrate 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])))
