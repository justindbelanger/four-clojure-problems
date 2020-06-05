(ns four-clojure-problems.for-58-test
  (:require [clojure.test :refer [deftest is]]
            [four-clojure-problems.for-58 :as sut]))

(deftest compo-test
  (is (= [3 2 1] ((sut/compo rest reverse) [1 2 3 4])))
  (is (= 5 ((sut/compo (partial + 3) second) [1 2 3 4])))
  (is (= true ((sut/compo zero? #(mod % 8) +) 3 5 7 9)))
  (is (= "HELLO" ((sut/compo #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))
