(ns four-clojure-problems.for-46-test
  (:require [four-clojure-problems.for-46 :as sut]
            #?(:clj [clojure.test :refer [are deftest is testing]]
               :cljs [cljs.test :refer-macros [are testing deftest is]])))

(deftest flipper-tests
  (is (= 3 ((sut/flipper nth) 2 [1 2 3 4 5])))
  (is (= true ((sut/flipper >) 7 8)))
  (is (= 4 ((sut/flipper quot) 2 8)))
  (is (= [1 2 3] ((sut/flipper take) [1 2 3 4 5] 3))))
