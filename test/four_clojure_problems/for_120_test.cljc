(ns four-clojure-problems.for-120-test
  (:require [four-clojure-problems.for-120 :as sut]
            #?(:clj [clojure.test :refer [deftest is testing]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest less-than-sum-of-squares-test
  (let [ltss sut/less-than-sum-of-squares]
    (is (= 8 (ltss (range 10))))
    (is (= 19 (ltss (range 30))))
    (is (= 50 (ltss (range 100))))
    (is (= 50 (ltss (range 1000))))))
