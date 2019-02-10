(ns four-clojure-problems.for-135-test
  (:require [four-clojure-problems.for-135 :refer [infix-calc]]
            #?(:clj [clojure.test :refer [deftest is]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest infix-calc-tests
  (is (= (infix-calc 2 + 5)
         7))
  (is (= (infix-calc 38 + 48 - 2 / 2)
         42))
  (is (= (infix-calc 10 / 2 - 1 * 2)
         8))
  (is (= (infix-calc 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)
         72)))
