(ns four-clojure-problems.for-118-test
  (:require [four-clojure-problems.for-118 :refer [remap]]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest remap-tests
  (is (= (remap inc [2 3 4 5 6])
         [3 4 5 6 7]))
  (is (= (remap (fn [_] nil) (range 10))
         (repeat 10 nil)))
  (is (= (->> (remap inc (range))
              (drop (dec 1000000))
              (take 2))
         [1000000 1000001])))
