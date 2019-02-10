(ns four-clojure-problems.for-100-test
  (:require [four-clojure-problems.for-100 :refer [lcm]]
            #?(:clj [clojure.test :refer [deftest is testing]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest lcm-tests
  (is (= (lcm 2 3)
         6))
  (is (= (lcm 5 3 7)
         105))
  (is (= (lcm 5 6)
         30))
  (is (= (lcm 9 2)
         18))
  (is (= (lcm 5 21 2)
         210))
  #?(:clj (testing "ratios"
            (is (= (lcm 1/3 2/5)
                   2))
            (is (= (lcm 3/4 1/6)
                   3/2))
            (is (= (lcm 7 5/7 2 3/5)
                   210)))))
